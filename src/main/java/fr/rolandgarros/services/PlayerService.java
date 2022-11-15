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


}
