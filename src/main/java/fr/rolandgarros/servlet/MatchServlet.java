package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.Match;
import fr.rolandgarros.services.MatchService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;

public class MatchServlet extends HttpServlet {
    final MatchService matchService = new MatchService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ViewMatch/Matchs.jsp";

        request.setAttribute("MSMT", matchService.getSimpleMenToCome());
        request.setAttribute("MSWT", matchService.getSimpleWomenToCome());
        request.setAttribute("MDMT", matchService.getDoubleMenToCome());
        request.setAttribute("MDWT", matchService.getDoubleWomenToCome());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String role = (String) request.getSession().getAttribute("role");
        boolean isMatchEditor = role != null && (role.equals("MatchEditor") || role.equals("Admin"));

// TODO inverser la condition
        // Redirects the user if he is not permitted
        if (isMatchEditor) {
            response.sendRedirect("/Matchs");
            return;
        }

        // Or handle the form to delete the match

        boolean error = false;
        String matchId = request.getParameter("matchIdDeletion");
        Match match = null;

        try {
            // check this match exists
            match = matchService.getMatchById(Integer.parseInt(matchId));
            if (match == null) {
                error = true;
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

        // Then redirects the user to prevent multiple form submission
        response.sendRedirect("/Matchs");
    }
}