package fr.rolandgarros.servlet;

import fr.rolandgarros.core.Utils;
import fr.rolandgarros.model.*;
import fr.rolandgarros.services.CourtService;
import fr.rolandgarros.services.MatchService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;

public class MatchUpdateServlet extends HttpServlet {
    private static final CourtService courtService = new CourtService();
    private static final MatchService matchService = new MatchService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ViewMatch/UpdateMatch.jsp";

        Role role = (Role) request.getSession().getAttribute("role");
        boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

        // Redirects the user if he is not permitted
        if (! isMatchEditor) {
            response.sendRedirect("/Matches");
            return;
        }

        // Or display the page
        boolean error = false;
        String matchId = request.getParameter("id");

        if (matchId == null) {
            error = true;
        }
        else {
            try {
                // Check if the match exists
                Match match = matchService.getMatchById(Integer.parseInt(matchId));
                if (match == null) {
                    throw new IllegalArgumentException("This match does not exist.");
                }

                request.setAttribute("match", match);
                request.setAttribute("matchType", match instanceof Single ? "Simple" : "Double");
                request.setAttribute("courts", courtService.getAllCourt());
            }
            catch (IllegalArgumentException iae) {
                error = true;
            }
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(error ? "/Template/error.jsp" : page);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute("role");
        boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

        // Redirects the user if he is not permitted
        if (! isMatchEditor) {
            response.sendRedirect("/Matches");
            return;
        }

        // Or handle the form to update start date and court, everything else is read-only

        boolean error = false;
        Match match = null;
        Court court = null;
        Timestamp ts = null;

        String matchId = request.getParameter("matchId");
        String matchCourt = request.getParameter("matchCourt");
        String matchStartDate = request.getParameter("matchStartDate");

        if (matchId == null || matchCourt == null || matchStartDate == null) {
            error = true;
        }
        else {
            try {
                // check this match exists
                match = matchService.getMatchById(Integer.parseInt(matchId));
                if (match == null) {
                    throw new IllegalArgumentException("This match does not exist.");
                }

                // Get court and check is not null
                court = courtService.getCourtById(Integer.parseInt(matchCourt));
                if (court == null) {
                    throw new IllegalArgumentException("This court does not exist.");
                }

                // The HTML input[type=datetime] has the ISO 8601 format yyyy-mm-ddThh:mm
                // But Timestamp needs the yyyy-mm-dd hh:mm:ss format or a long
                // So we convert the input to a long with a specific format parser
                ts = new Timestamp(Utils.dateFormatHTMLInput.parse(matchStartDate).getTime());

                // Check time is not passed
                Timestamp now = new Timestamp(System.currentTimeMillis());
                if (ts.before(now)) {
                    throw new IllegalArgumentException("Datetime cannot be already passed.");
                }

                // Check no match is planned at the same datetime and court
                // Considering that data could stay unchanged in the submission, this match could be our modified match
                Match otherMatch = matchService.getMatch(court, ts);
                if (otherMatch != null && !(match.getIdT().equals(otherMatch.getIdT()))) {
                    throw new IllegalArgumentException("This datetime and court are already reserved for another match.");
                }
            }
            // NumberFormatException is a subtype of IllegalArgumentException
            catch (IllegalArgumentException | ParseException iae) {
                error = true;
            }
        }

        if (match == null) {
            // 400 Bad Request
            response.setStatus(400);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Template/error.jsp");
            dispatcher.forward(request, response);
        }
        // If an error has been found in the submission
        else if (error) {
            session.setAttribute("tempUpdateError", true);
            // Redirects the user to the same form to prevent resubmission
            response.sendRedirect("/MatchUpdate?id=" + match.getIdT());
        }

        else {
            match.setCourt(court);
            match.setStartDate(ts);
            matchService.modifyMatch(match);
            session.removeAttribute("tempUpdateError");

            // Then redirects the user to the list of matches
            response.sendRedirect("/Matches");
        }
    }
}
