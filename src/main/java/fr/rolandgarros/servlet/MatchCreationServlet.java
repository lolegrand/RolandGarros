package fr.rolandgarros.servlet;

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
import java.util.List;

public class MatchCreationServlet extends HttpServlet {
    final CourtService courtService = new CourtService();
    final MatchService matchService = new MatchService();
    final PlayerService playerService = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ViewMatch/CreateMatch.jsp";
        HttpSession session = request.getSession();

        String role = (String) session.getAttribute("role");
        boolean isMatchEditor = role != null && (role.equals("MatchEditor") || role.equals("Admin"));

// TODO inverser la condition
        // Redirects the user if he is not permitted
        if (isMatchEditor) {
            response.sendRedirect("/Matchs");
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

        String role = (String) session.getAttribute("role");
        boolean isMatchEditor = role != null && (role.equals("MatchEditor") || role.equals("Admin"));

// TODO inverser la condition
        // Redirects the user if he is not permitted
        if (isMatchEditor) {
            response.sendRedirect("/Matchs");
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

            if (matchType == null || matchGender == null || matchStartDate == null) {
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
                        error = true;
                    }

                    // The HTML input[type=datetime] has the format yyyy-mm-ddThh:mm, but timestamp needs yyyy-mm-dd hh:mm:ss so we convert it
                    // By replacing the T by a space and adding default :00 for seconds
                    ts = Timestamp.valueOf(matchStartDate.replace('T', ' ').concat(":00"));

                    // Check no match is planned at this datetime and on the same court
                    Match match = matchService.getMatch(court, ts);
                    if (match != null) {
                        error = true;
                    }
                }
                // NumberFormatException is a subtype of IllegalArgumentException
                catch (IllegalArgumentException iae) {
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
                response.sendRedirect("/Matchs");
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
                    response.sendRedirect("/Matchs");
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
            response.sendRedirect("/Matchs");
        }

        // Impossible case: should crash in 403 (forbidden)
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
