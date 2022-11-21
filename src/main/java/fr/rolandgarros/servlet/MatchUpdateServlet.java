package fr.rolandgarros.servlet;

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

public class MatchUpdateServlet extends HttpServlet {
    private static final CourtService courtService = new CourtService();
    private static final MatchService matchService = new MatchService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ViewMatch/UpdateMatch.jsp";

        Role role = (Role) request.getSession().getAttribute("role");
        boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

// TODO inverser la condition
        // Redirects the user if he is not permitted
        if (isMatchEditor) {
            response.sendRedirect("/Matchs");
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
                    error = true;
                }
            }
            catch (IllegalArgumentException iae) {
                error = true;
            }
        }

        if (error) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Template/error.jsp");
            dispatcher.forward(request, response);
        }

        else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Role role = (Role) request.getSession().getAttribute("role");
        boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

// TODO inverser la condition
        // Redirects the user if he is not permitted
        if (isMatchEditor) {
            response.sendRedirect("/Matchs");
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

        try {
            // check this match exists
            match = matchService.getMatchById(Integer.parseInt(matchId));
            if (match == null) {
                error = true;
            }
            else {
                // Get court and check is not null
                court = courtService.getCourtById(Integer.parseInt(matchCourt));
                if (court == null) {
                    error = true;
                }

                // The HTML input[type=datetime] has the format yyyy-mm-ddThh:mm (ISO 8601)
                // But timestamp needs yyyy-mm-dd hh:mm:ss so we convert it
                // By replacing the T by a space and adding default :00 for seconds
                ts = Timestamp.valueOf(matchStartDate.replace('T', ' ').concat(":00"));

                // check time is not passed
                Timestamp now = new Timestamp(System.currentTimeMillis());
                if (ts.before(now)) {
                    error = true;
                }

                // Check no match is planned at the same datetime and court (considering that data could stay unchanged in the submission)
                Match otherMatch = matchService.getMatch(court, ts);
                if (otherMatch != null && ! (match.getIdT().equals(otherMatch.getIdT()))) {
                    error = true;
                }
            }
        }
        // NumberFormatException is a subtype of IllegalArgumentException
        catch (IllegalArgumentException iae) {
            error = true;
        }

        // If an error has been found in the submission
        if (error) {
            // Redirects the user to the same form to prevent resubmission
            response.sendRedirect("/MatchUpdate?id=" + match.getIdT());
        }

        else {
            match.setCourt(court);
            match.setStartDate(ts);
            matchService.modifyMatch(match);

            // Then redirects the user to the list of matches
            response.sendRedirect("/Matchs");
        }
    }
}
