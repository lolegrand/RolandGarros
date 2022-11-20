package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Gender;
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
import java.sql.Date;
import java.util.List;

public class PlayerServlet extends HttpServlet {

    final PlayerService playerService = new PlayerService();

    Player player = null;
    Person trainer = null;
    String errorMsg = null;
    String successMsg = null;

    String lastname = null;
    String firstname = null;
    Date birthdate = null;
    String birthplace = null;
    Gender gender = null;
    String nationality = null;
    Integer ranking = null;
    Integer bestRanking = null;
    Date startCareer = null;
    Float height = null;
    Float weight = null;
    Hand hand = null;



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

        if ( req.getParameter("playerLastname") != null ) {
            lastname = req.getParameter("playerLastname");
        }

        if ( req.getParameter("playerFirstname") != null ) {
            firstname = req.getParameter("playerFirstname");
        }

        if ( req.getParameter("gender") != null ) {
            String genderStr = req.getParameter("gender");
            if (genderStr.equals("Male")) {
                gender = Gender.MALE;
            } else {
                gender = Gender.FEMALE;
            }

        }

        if ( req.getParameter("nationality") != null ) {
            nationality = req.getParameter("nationality");
        }

        if ( req.getParameter("ranking") != null ) {
            ranking = Integer.valueOf(req.getParameter("ranking"));
        }

        if ( req.getParameter("bestRanking") != null ) {
            bestRanking = Integer.valueOf(req.getParameter("bestRanking"));
        }

        if ( req.getParameter("startCareer") != null ) {
            int startCareerInt = Integer.parseInt(req.getParameter("startCareer"));
            startCareer = new Date(startCareerInt);
        }

        if ( req.getParameter("height") != null ) {
            height = Float.valueOf(req.getParameter("height"));
        }

        if ( req.getParameter("weight") != null ) {
            weight = Float.valueOf(req.getParameter("weight"));
        }

        if ( req.getParameter("hand") != null ) {
            hand = Hand.valueOf(req.getParameter("hand"));
        }


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
         * If there is a request for validation of a form: do check parameters
         * If is not verified, set an error message
         * Else, set a success message and do the corresponding function call (create for formCreate, ...)
         */

        boolean formCreatePlayer = req.getParameter("submitFormCreatePlayer") != null;

        if ( formCreatePlayer ){
/*
            if ( !playerService.checkBirthDate( birthdate ) ){
                errorMsg = "Date de naissance invalide.";
            }

            if ( !playerService.checkBirthPlace( birthplace ) ){
                errorMsg = "Lieu de naissance invalide.";
            }

            if ( !playerService.checkGender( gender ) ){
                errorMsg = "Genre invalide.";
            }

            if ( !playerService.checkRanking( ranking ) ){
                errorMsg = "Classement invalide.";
            }
*/
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

            if ( !playerService.checkStartCareer( birthdate, startCareer ) ){
                errorMsg = "Début de carrière invalide.";
            }

            if ( !playerService.checkHand( hand ) ){
                errorMsg = "Main de jeu invalide.";
            }

            if ( !playerService.checkTrainer( trainer ) ){
                errorMsg = "Entraineur invalide.";
            }

            if ( errorMsg != null ) {
                req.setAttribute("CreatePlayerError", errorMsg);
            }
            else {
                player = new Player(
                        lastname, firstname, birthdate, birthplace, ranking, bestRanking,
                        nationality, height, weight, startCareer, hand, trainer, gender);

                if (!playerService.checkPlayerExsist(player)){ //FIXME: check if player already exist
                    playerService.createPlayer(player);
                    successMsg = "Création réussie.";
                    req.setAttribute("CreatePlayerSuccess", successMsg);
                }
                else {
                    errorMsg = "Ce joueur existe déjà.";
                    req.setAttribute("CreatePlayerError", errorMsg);
                }
            }
        }

        boolean formUpdatePlayer = req.getParameter("submitFormUpdatePlayer") != null;

        if ( formUpdatePlayer ){
/*
            if ( !playerService.checkRanking( ranking ) ){
                errorMsg = "Classement invalide.";
            }
*/
            if ( !playerService.checkWeight( weight ) ){
                errorMsg = "Poids invalide.";
            }

            if ( errorMsg != null ) {
                req.setAttribute("UpdatePlayerError", errorMsg);
            }
            else {
                player = playerService.getPlayerByName(lastname, firstname);

                player.setWeight( weight );
                player.setRanking( ranking );

                playerService.modifyPlayer(player);

                successMsg = "Mise à jour réussie.";
                req.setAttribute("UpdatePlayerSuccess", successMsg);
            }
        }


        boolean formDeletePlayer = req.getParameter("submitFormDeletePlayer") != null;

        if ( formDeletePlayer ){
            player = playerService.getPlayerByName(lastname, firstname);
            playerService.deletePlayer(player);

            successMsg = "Suppression réussie.";
            req.setAttribute("DeletePlayerSuccess", successMsg);
        }


        List<Player> players = playerService.getAllPlayers();
        req.setAttribute("players", players);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e){
            throw new RuntimeException(e);
        }
    }

}
