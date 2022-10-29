package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Match;
import fr.rolandgarros.services.MatchService;
import fr.rolandgarros.services.PersonService;
import fr.rolandgarros.services.PlayerService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MatchServlet extends HttpServlet {

    final PlayerService playerService = new PlayerService();
    final PersonService personService = new PersonService();
    final MatchService matchService = new MatchService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
        String page = "/ViewMatch/Matchs.jsp";



        List<Match> matches = matchService.getAllMatches();
        req.setAttribute("matches", matches);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
