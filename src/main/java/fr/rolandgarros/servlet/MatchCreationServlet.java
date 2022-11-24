package fr.rolandgarros.servlet;

import fr.rolandgarros.core.Utils;
import fr.rolandgarros.model.*;
import fr.rolandgarros.model.Double;
import fr.rolandgarros.services.CourtService;
import fr.rolandgarros.services.MatchService;
import fr.rolandgarros.services.PlayerService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public class MatchCreationServlet extends HttpServlet {
    private static final CourtService courtService = new CourtService();
    private static final MatchService matchService = new MatchService();
    private static final PlayerService playerService = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ViewMatch/CreateMatch.jsp";
        HttpSession session = request.getSession();

        Role role = (Role) session.getAttribute("role");
        boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

        // Redirects the user if he is not permitted
        if (! isMatchEditor) {
            response.sendRedirect("/Matches");
            return;
        }

        // Or display the page
        String lastStep = (String) session.getAttribute("matchCreationStep");

        // Match creation : modalities
        if (lastStep == null) {
            request.setAttribute("courts", courtService.getAllCourt());
        }
        // Match creation : players
        else {
            String matchType = (String) session.getAttribute("tempMatchType");
            String matchGender = (String) session.getAttribute("tempMatchGender");
            List<Player> players;

            if (matchGender.equals("Male")) {
                players = playerService.getPlayersByGender(Gender.MALE);
            }
            else {
                players = playerService.getPlayersByGender(Gender.FEMALE);
            }

            request.setAttribute("players", players);
            request.setAttribute("matchType", matchType);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Role role = (Role) session.getAttribute("role");
        boolean isMatchEditor = role == Role.ADMINISTRATOR || role == Role.MATCH_EDITOR;

        // Redirects the user if he is not permitted
        if (! isMatchEditor) {
            response.sendRedirect("/Matches");
            return;
        }

        // Or handle the form
        String submittedStep = request.getParameter("step");
        String lastStep = (String) session.getAttribute("matchCreationStep");

        if (submittedStep.equals("createMatchModality") && lastStep == null) {
            boolean error = false;
            Court court = null;
            Timestamp ts = null;

            String matchType = request.getParameter("matchType");
            String matchGender = request.getParameter("matchGender");
            String matchCourt = request.getParameter("matchCourt");
            String matchStartDate = request.getParameter("matchStartDate");

            if (matchType == null || matchGender == null || matchCourt == null || matchStartDate == null) {
                error = true;
            }
            else if (!matchType.equals("Simple") && !matchType.equals("Double")) {
                error = true;
            }
            else if (!matchGender.equals("Male") && !matchGender.equals("Female")) {
                error = true;
            }
            else {
                try {
                    // Get court and check is not null
                    court = courtService.getCourtById(Integer.parseInt(matchCourt));
                    if (court == null) {
                        throw new IllegalArgumentException("This court does not exist.");
                    }

                    // The HTML input[type=datetime] has the ISO 8601 format yyyy-mm-ddThh:mm
                    // But Timestamp needs the yyyy-mm-dd hh:mm:ss format or a long
                    // So we convert the input to a long with a specific format parser
                    ts = new Timestamp(Utils.dateFormatHTMLInput.parse(matchStartDate).getTime());

                    // Check no match is planned at this datetime and on the same court
                    Match match = matchService.getMatch(court, ts);
                    if (match != null) {
                        throw new IllegalArgumentException("A match already exists at the same datetime and court.");
                    }
                }
                // NumberFormatException is a subtype of IllegalArgumentException
                catch (IllegalArgumentException | ParseException iae) {
                    error = true;
                }
            }

            // If an error has been found in the submission
            if (error) {
                session.setAttribute("tempCreationError", true);
            }

            // Else, save the data for the next step
            else {
                session.setAttribute("tempMatchType", matchType);
                session.setAttribute("tempMatchGender", matchGender);
                session.setAttribute("tempMatchCourt", court);
                session.setAttribute("tempMatchStartDate", ts);
                session.setAttribute("matchCreationStep", "createMatchModality");
            }

            // Redirects the user to the same form to prevent new submission and skip to the next step if no error encountered
            response.sendRedirect("/MatchCreation");
        }

        else if (submittedStep.equals("createMatchPlayers") && lastStep.equals("createMatchModality")) {
            Timestamp ts = (Timestamp) session.getAttribute("tempMatchStartDate");
            String matchGender = (String) session.getAttribute("tempMatchGender");
            Gender gender = matchGender.equals("Male") ? Gender.MALE : Gender.FEMALE;
            Court court = (Court) session.getAttribute("tempMatchCourt");

            String matchType = (String) session.getAttribute("tempMatchType");

            if (matchType.equals("Simple")) {
                Player player1 = playerService.getPlayerById(Integer.parseInt(request.getParameter("player1")));
                Player player2 = playerService.getPlayerById(Integer.parseInt(request.getParameter("player2")));

                matchService.createMatch(new Single(ts, gender, court, player1, player2));

                clearTemporaryData(session);

                // Then redirects the user to prevent resubmission
                response.sendRedirect("/Matches");
            }
            else {
                try {
                    Player team1player1 = playerService.getPlayerById(Integer.parseInt(request.getParameter("team1player1")));
                    Player team1player2 = playerService.getPlayerById(Integer.parseInt(request.getParameter("team1player2")));
                    Player team2player1 = playerService.getPlayerById(Integer.parseInt(request.getParameter("team2player1")));
                    Player team2player2 = playerService.getPlayerById(Integer.parseInt(request.getParameter("team2player2")));

                    matchService.createMatch(new Double(ts, gender, court, team1player1, team1player2, team2player1, team2player2));

                    clearTemporaryData(session);

                    // Then redirects the user to the list of matches
                    response.sendRedirect("/Matches");
                }
                catch (IllegalArgumentException iae) {
                    session.setAttribute("tempCreationError", true);

                    // Redirects the user to the same form to prevent resubmission
                    response.sendRedirect("/MatchCreation");
                }
            }
        }

        else if (submittedStep.equals("cancelMatchCreation")) {
            clearTemporaryData(session);

            // Then redirects the user to prevent resubmission
            response.sendRedirect("/Matches");
        }

        // Impossible case: should crash in 403 Forbidden
        else {
            response.setStatus(403);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Template/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void clearTemporaryData(HttpSession session) {
        // Removes all temporary saved data and last step to reset the form
        session.removeAttribute("tempMatchType");
        session.removeAttribute("tempMatchGender");
        session.removeAttribute("tempMatchCourt");
        session.removeAttribute("matchCreationStep");
        session.removeAttribute("tempCreationError");
    }
}
