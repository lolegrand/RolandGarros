package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.services.PersonService;
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
    final PersonService personService = new PersonService();
    Player player = null;
    Person trainer = null;
    String errorMsg = null;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp){

        String page = "/ViewPlayer/Players.jsp";

        // Get all information possible from request

        String lastname = req.getParameter("playerLastname");
        String firstname = req.getParameter("playerFirstname");
        String gender = req.getParameter("gender");
        String nationality = req.getParameter("nationality");
        Integer ranking = Integer.valueOf(req.getParameter("ranking"));
        Integer bestRanking = Integer.valueOf(req.getParameter("bestRanking"));
        Integer startCareer = Integer.valueOf(req.getParameter("startCareer"));
        Float height = Float.valueOf(req.getParameter("height"));
        Float weight = Float.valueOf(req.getParameter("weight"));
        Hand hand = Hand.valueOf(req.getParameter("hand"));
        // String trainerLastname = req.getParameter("trainer");
        // String trainerFirstname = req.getParameter("trainer");
        // trainer = personService.getPersonByName( trainerLastname, trainerFirstname );


        // Get what the user wants to do

        boolean createPlayer = req.getParameter("createPlayer") != null;
        boolean displayPlayer = req.getParameter("displayPlayer") != null;
        boolean updatePlayer = req.getParameter("updatePlayer") != null;

        /*
         * If there is a request for a view that needs a player's information:
         * Check if the first and last name aren't null
         * If true, get the matching player, then return the corresponding request with the player needed
         * Else, ignore
         */

        if ( lastname != null && firstname != null ){
            player = playerService.getPlayerByName(lastname, firstname);

            if ( player != null ){

                if( displayPlayer ){
                    req.setAttribute("displayedPlayer", player);
                }

                if( updatePlayer ){
                    req.setAttribute("updatedPlayer", player);
                }
            }
        }

        /*
         * If there is a request for validation of a form:
         * Check parameters
         */

        boolean formCreatePlayer = req.getParameter("submitFormCreatePlayer") != null;

        if ( formCreatePlayer ){

            if ( !playerService.checkGender( gender ) ){
                errorMsg = "Genre invalide.";
            }

            if ( !playerService.checkRanking( ranking ) ){
                errorMsg = "Classement invalide.";
            }

            if ( !playerService.checkBestRanking( bestRanking ) ){
                errorMsg = "Meilleur rang invalide.";
            }

            if ( !playerService.checkNationality( nationality ) ){
                errorMsg = "Nationalité invalide.";
            }

            if ( !playerService.checkHeight( height ) ){
                errorMsg = "Taille invalide.";
            }

            if ( !playerService.checkWeight( weight ) ){
                errorMsg = "Poids invalide.";
            }

            if ( !playerService.checkStartCareer( startCareer ) ){
                errorMsg = "Début de carrière invalide.";
            }

            if ( !playerService.checkHand( hand ) ){
                errorMsg = "Main de jeu invalide.";
            }

            if ( !playerService.checkTrainer( trainer ) ){
                errorMsg = "Entraineur invalide.";
            }

            if ( errorMsg != null )
                req.setAttribute("CreatePlayerError", errorMsg);
        }

        boolean formUpdatePlayer = req.getParameter("submitFormUpdatePlayer") != null;

        if ( formUpdatePlayer ){

            if ( !playerService.checkRanking( ranking ) ){
                errorMsg = "Classement invalide.";
            }

            if ( !playerService.checkWeight( weight ) ){
                errorMsg = "Poids invalide.";
            }

            if ( errorMsg != null )
                req.setAttribute("UpdatePlayerError", errorMsg);
        }




        List<Player> players = playerService.getAllPlayer();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        req.setAttribute("players", players);

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e){
            throw new RuntimeException(e);
        }
    }

}
