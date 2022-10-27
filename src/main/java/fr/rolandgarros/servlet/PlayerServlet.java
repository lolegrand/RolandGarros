package fr.rolandgarros.servlet;

import fr.rolandgarros.services.PlayerService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
            playerService.createPlayer();
        }

        if ( req.getParameter("submitFormUpdatePlayer").equals("Mettre à jour") ){
            playerService.updatePlayer();
        }

        if ( req.getParameter("deletePlayer").equals("Supprimer") ){
            playerService.deletePlayer();
        }
*/
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
