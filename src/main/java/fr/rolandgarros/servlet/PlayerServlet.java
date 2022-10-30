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
    final PersonService personService = new PersonService();

    Player player = null;
    Person trainer = null;
    String error = null;
    String success = null;

    String lastname = null;
    String firstname = null;
    Date birthdate = null;
    String birthplace = null;
    Gender gender = null;
    String nationality = null;
    Integer ranking = null;
    Integer bestRanking = null;
    Integer startCareer = null;
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

        if ( req.getParameter("birthdate") != null ) {
            birthdate = Date.valueOf(req.getParameter("birthdate"));
        }

        if ( req.getParameter("birthplace") != null ) {
            birthplace = req.getParameter("birthplace");
        }

        if ( req.getParameter("nationality") != null ) {
            nationality = req.getParameter("nationality");
        }

        if ( req.getParameter("ranking") != null ) {
            ranking = Integer.valueOf(req.getParameter("ranking"));
        }

        if ( req.getParameter("bestRanking") != null ) {
            bestRanking = Integer.valueOf(req.getParameter("bestRanking"));
        } else {
            bestRanking = ranking;
        }

        if ( req.getParameter("startCareer") != null ) {
            startCareer = Integer.parseInt(req.getParameter("startCareer"));
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

            req.setAttribute("formToCreatePlayer", "Nouveau Joueur");

            if ( !playerService.checkBirthDate( birthdate ) ){
                error = "Date de naissance invalide.";
                req.setAttribute("CreatePlayerError-BirthDate", error);
            }

            if ( !playerService.checkBirthPlace( birthplace ) ){
                error = "Lieu de naissance invalide.";
                req.setAttribute("CreatePlayerError-BirthPlace", error);
            }

            if ( !playerService.checkRanking( ranking ) ){
                error = "Classement invalide.";
                req.setAttribute("CreatePlayerError-Ranking", error);
            }

            if ( !playerService.checkBestRanking( bestRanking ) ){
                error = "Meilleur rang invalide.";
                req.setAttribute("CreatePlayerError-BestRanking", error);
            }

            if ( !playerService.checkNationality( nationality ) ){
                error = "Nationalité invalide.";
                req.setAttribute("CreatePlayerError-Nationality", error);
            }

            if ( !playerService.checkHeight( height ) ){
                error = "Taille invalide.";
                req.setAttribute("CreatePlayerError-Height", error);
            }

            if ( !playerService.checkWeight( weight ) ){
                error = "Poids invalide.";
                req.setAttribute("CreatePlayerError-Weight", error);
            }

            if ( !playerService.checkStartCareer( startCareer ) ){
                error = "Début de carrière invalide.";
                req.setAttribute("CreatePlayerError-StartCareer", error);
            }

            if ( !playerService.checkHand( hand ) ){
                error = "Main de jeu invalide.";
                req.setAttribute("CreatePlayerError-Hand", error);
            }

            if ( req.getParameter("selectTrainer") != null ) {
                String[] split = req.getParameter("selectTrainer").split(" ");
                trainer = personService.getPersonByName(split[1], split[0]);
            }

            if ( !playerService.checkTrainer( trainer ) ){
                error = "Entraineur invalide.";
                req.setAttribute("CreatePlayerError-Trainer", error);
            }

            if ( error != null ) {
                req.setAttribute("CreatePlayerError", error);
            }
            else {
                player = new Player(
                        lastname, firstname, birthdate, birthplace, ranking, bestRanking,
                        nationality, height, weight, startCareer, hand, trainer, gender);
                playerService.createPlayer(player);

                success = "Création réussie.";
                req.setAttribute("CreatePlayerSuccess", success);
            }
        }

        boolean formUpdatePlayer = req.getParameter("submitFormUpdatePlayer") != null;

        if ( formUpdatePlayer ){
            req.setAttribute("formToUpdatePlayer", "Modifier");

            /*
            if ( !playerService.checkRanking( ranking ) ){
                error = "Classement invalide.";
                req.setAttribute("UpdatePlayerError-Ranking", error);
            }*/

            if ( !playerService.checkWeight( weight ) ){
                error = "Poids invalide.";
                req.setAttribute("UpdatePlayerError-Weight", error);
            }

            if ( error != null ) {
                req.setAttribute("UpdatePlayerError", error);
            }
            else {
                player = playerService.getPlayerByName(lastname, firstname);

                player.setWeight( weight );
                player.setRanking( ranking );

                playerService.modifyPlayer(player);

                success = "Mise à jour réussie.";
                req.setAttribute("UpdatePlayerSuccess", success);
            }
        }


        boolean formDeletePlayer = req.getParameter("submitFormDeletePlayer") != null;

        if ( formDeletePlayer ){
            player = playerService.getPlayerByName(lastname, firstname);
            playerService.deletePlayer(player);

            success = "Suppression réussie.";
            req.setAttribute("DeletePlayerSuccess", success);
        }

        List<Person> trainers = personService.getAllPerson();
        req.setAttribute("trainers", trainers);

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
