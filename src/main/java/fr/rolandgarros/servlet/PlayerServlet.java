package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Player;
import fr.rolandgarros.services.PlayerService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PlayerServlet extends HttpServlet {

    final PlayerService playerService = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
        String page = "/ViewPlayer/Players.jsp";

        /*
        if ( req.getParameter("submitFormCreatePlayer").equals("Nouveau Joueur") ){
            //playerService.createPlayer();
        }

        if ( req.getParameter("submitFormUpdatePlayer").equals("Mettre à jour") ){
            //playerService.updatePlayer();
        }

        if ( req.getParameter("deletePlayer").equals("Supprimer") ){
            //playerService.deletePlayer();
        }
         */

        List<Player> players = playerService.getAllPlayer();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        req.setAttribute("players", players);
        //req.getSession().setAttribute("role", "Admin");

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
