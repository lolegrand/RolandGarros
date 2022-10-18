package fr.rolandgarros.rolandgarros.services;

import fr.rolandgarros.rolandgarros.model.Player;
import fr.rolandgarros.rolandgarros.model.dal.PlayerDAO;
import fr.rolandgarros.rolandgarros.model.dal.stub.PlayerDAOMock;

public class PlayerService {

    private final PlayerDAO playerDAO = new PlayerDAOMock();

    public Player getPlayerByName(String lastName, String firstName){
        return playerDAO.getPlayerByName(lastName, firstName);
    }
}
