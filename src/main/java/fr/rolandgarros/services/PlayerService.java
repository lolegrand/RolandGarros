package fr.rolandgarros.services;

import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PlayerDAO;
import fr.rolandgarros.model.dal.stub.PlayerDAOMock;

import java.util.List;

public class PlayerService {

        private final PlayerDAO playerDAO = new PlayerDAOMock();

        public Player getPlayerByName(String lastName, String firstName) {
                return playerDAO.getPlayerByName(lastName, firstName);
        }

        public List<Player> getAllPlayer() {
                return playerDAO.getAllPlayer();
        }
}
