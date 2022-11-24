package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Match;
import fr.rolandgarros.model.Role;
import fr.rolandgarros.services.MatchService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MatchServlet extends HttpServlet {
    private static final MatchService matchService = new MatchService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ViewMatch/Matches.jsp";

        String matches = request.getParameter("matches");
        if (matches == null || matches.equals("all")) {
            matches = "all";
            request.setAttribute("matches", matches);
            request.setAttribute("MSM", matchService.getSimpleMen());
            request.setAttribute("MSW", matchService.getSimpleWomen());
            request.setAttribute("MDM", matchService.getDoubleMen());
            request.setAttribute("MDW", matchService.getDoubleWomen());
        }
        else if (matches.equals("past")) {
            request.setAttribute("matches", matches);
            request.setAttribute("MSM", matchService.getSimpleMenPast());
            request.setAttribute("MSW", matchService.getSimpleWomenPast());
            request.setAttribute("MDM", matchService.getDoubleMenPast());
            request.setAttribute("MDW", matchService.getDoubleWomenPast());
        }
        else if (matches.equals("toCome")) {
            request.setAttribute("matches", matches);
            request.setAttribute("MSM", matchService.getSimpleMenToCome());
            request.setAttribute("MSW", matchService.getSimpleWomenToCome());
            request.setAttribute("MDM", matchService.getDoubleMenToCome());
            request.setAttribute("MDW", matchService.getDoubleWomenToCome());
        }
        else {
            // 400 Bad Request
            response.setStatus(400);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Template/error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Role role = (Role) request.getSession().getAttribute("role");
        boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

        // Redirects the user if he is not permitted
        if (! isMatchEditor) {
            response.sendRedirect("/Matches");
            return;
        }

        // Or handle the form to delete the match

        boolean error = false;
        String matchId = request.getParameter("matchIdDeletion");
        Match match = null;

        try {
            // check this match exists and is has not been played yet
            match = matchService.getMatchById(Integer.parseInt(matchId));
            if (match == null || match.isTimeEventPassed()) {
                throw new IllegalArgumentException("Match should exist and not be already passed.");
            }
        }
        // NumberFormatException is a subtype of IllegalArgumentException
        catch (IllegalArgumentException iae) {
            error = true;
        }

        // If no error has been found in the submission
        if (! error) {
            // Delete the match
            matchService.deleteMatch(match);
        }

        // Then redirects the user to prevent form resubmission
        response.sendRedirect("/Matches");
    }
}