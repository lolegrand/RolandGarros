package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Match;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.services.MatchService;
import fr.rolandgarros.services.PlayerService;
import fr.rolandgarros.servlet.utils.StatisticsCriteria.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StatisticServlet extends HttpServlet {

    final static PlayerService playerService = new PlayerService();

    final static MatchService matchService = new MatchService();

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


        List<Player> players = playerService.getAllPlayers();
        List<Map.Entry<Player, Float>> playersSorted = null;
        List<Match> matches = matchService.getAllMatches();


        String genderStr = req.getParameter("Gender");
        if (genderStr != null) {
            Gender gender = null;
            if (genderStr.equals("Male")) gender = Gender.MALE;
            if (genderStr.equals("Female")) gender = Gender.FEMALE;
            StatisticsFilterCriteria criteria = new GenderPlayerFilterFilterCriteria(gender);
            if (gender != null) players = criteria.filterPlayer(players);
        }

        String sortBy = req.getParameter("Sort");
        if (sortBy != null) {
            if (sortBy.equals("Victories")) {
                StatisticsSortCriteria sortCriteria = new NumberOfVictorySortPlayer();
                playersSorted = sortCriteria.sortPlayer(players, matches);
                req.setAttribute("sortName", "Nombre de victoire");
            }

            if (sortBy.equals("TotalGameDuration")) {
                StatisticsSortCriteria sortCriteria = new TimeGameSortPlayer();
                playersSorted = sortCriteria.sortPlayer(players, matches);
                req.setAttribute("sortName", "Temps de jeu total");
            }
        }

        req.setAttribute("genderStr", genderStr);
        req.setAttribute("playerSorted", playersSorted);
        req.setAttribute("players", players);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
