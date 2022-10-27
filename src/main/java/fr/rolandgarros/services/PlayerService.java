package fr.rolandgarros.services;

import fr.rolandgarros.model.dal.PlayerDAO;
import fr.rolandgarros.model.dal.stub.PlayerDAOMock;

public class PlayerService {

        private final PlayerDAO playerDAO = new PlayerDAOMock();

}
