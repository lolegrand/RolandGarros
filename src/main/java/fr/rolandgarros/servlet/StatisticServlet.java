package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Match;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.services.PlayerService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class StatisticServlet extends HttpServlet {

    final PlayerService playerService = new PlayerService();

    Integer nbVictory = null;
    Integer ranking = null;
    Gender gender = null;
    String gametime = null;

    List<Player> players = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
        String page = "/ViewStatistic/Statistics.jsp";

        if ( req.getAttribute("SortByGender") != null ){
            gender = (Gender) req.getAttribute("SortByGender");
            players = playerService.getPlayersOrderByGender(gender);
        }

        if ( req.getAttribute("SortByNbVictory") != null ){
            players = playerService.getPlayersOrderByNbVictory();
        }

        if ( req.getAttribute("SortByRanking") != null ){
            players = playerService.getPlayersOrderByRank();
        }

        if ( req.getAttribute("SortByTotalGameTime") != null ){
            players = playerService.getPlayersOrderByTotalGameTime();
        }


        players = playerService.getAllPlayers();
        req.setAttribute("players", players);


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
