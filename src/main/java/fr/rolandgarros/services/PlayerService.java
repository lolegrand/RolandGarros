package fr.rolandgarros.services;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PlayerDAO;
import fr.rolandgarros.model.dal.stub.PlayerDAOMock;

import java.sql.Date;
import java.util.List;

public class PlayerService {

    private static final PlayerDAO playerDAO = new PlayerDAOMock();



    // General functions

    public  void createPlayer(Player player) {
        playerDAO.createPlayer(player);
    }
    public  void deletePlayer(Player player) {
        playerDAO.deletePlayer(player);
    }
    public  void modifyPlayer(Player player) {
        playerDAO.updatePlayer(player);
    }



    // Ways to get a player

    public  Player getPlayerByName(String lastName, String firstName) {
        return playerDAO.getPlayerByName(firstName, lastName);
    }

    public List<Player> getAllPlayers() {
        return playerDAO.getAllPlayer();
    }

    public List<Player> getPlayersByGender(Gender gender) {
        return playerDAO.getPlayerByGender(gender);
    }

    public List<Player> getPlayersByRank(Integer rank) {
        return playerDAO.getPlayerByRank(rank);
    }

    public List<Player> getPlayersByNationality(String nationality) {
        return playerDAO.getPlayerByNationality(nationality);
    }

    public List<Player> getPlayersByHeight(Float height) {
        return playerDAO.getPlayerByHeight(height);
    }

    public List<Player> getPlayersByWeight(Float weight) {
        return playerDAO.getPlayerByWeight(weight);
    }

    public List<Player> getPlayersByStartCareer(Date startCareer) {
        return playerDAO.getPlayerByStartCareer(startCareer);
    }

    public List<Player> getPlayersByHand(Hand hand) {
        return playerDAO.getPlayerByHand(hand);
    }

    public List<Player> getPlayersByTrainer(Person trainer) {
        return playerDAO.getPlayerByTrainer(trainer);
    }



    // Check functions to submit forms

    public boolean checkGender( String gender ) {
        return gender.equals(Gender.MALE) || gender.equals(Gender.FEMALE);
    }

    public boolean checkBirthDate( Date birthdate ) {
        Date fifteenYearsAgo = new Date((System.currentTimeMillis()/1000/3600/24/365) - 15);
        return !birthdate.before(fifteenYearsAgo);
    }

    public boolean checkBirthPlace( String birthplace ) {
        return !birthplace.isEmpty();
    }

    public boolean checkRanking( Integer ranking ) {
        return ranking.compareTo(0) != -1 && ranking.compareTo(0) != 0;
    }

    public boolean checkBestRanking( Integer bestRanking ) {
        return bestRanking.compareTo(0) != -1 && bestRanking.compareTo(0) != 0;
    }

    public boolean checkNationality( String nationality ) {
        return !nationality.isEmpty();
    }

    public boolean checkHeight( Float height ) {
        return height.compareTo(150f) != -1 && height.compareTo(150f) != 0 ;
    }

    public boolean checkWeight( Float weight ) {
        return weight.compareTo(40f) != -1 && weight.compareTo(40f) != 0 ;
    }

    public boolean checkStartCareer( Integer startCareer ) {
        int currentYear = 2022;
        return startCareer.compareTo(currentYear+1) != 0
                && startCareer.compareTo(currentYear+1) != 1;
    }

    public boolean checkHand( Hand hand ) {
        return hand.equals(Hand.LEFT_HANDED)
                || hand.equals(Hand.RIGHT_HANDED)
                || hand.equals(Hand.AMBIDEXTROUS);
    }

    public boolean checkTrainer( Person trainer ) {
        return trainer != null;
    }
}
