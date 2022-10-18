package fr.rolandgarros.rolandgarros.model.dal;

import fr.rolandgarros.rolandgarros.model.Player;

public interface PlayerDAO {

    void createPlayer(Player player);

    void deletePlayer(Player player);

    void modifyPlayer(Player player);

    Player getPlayerByName(String firstName, String lastName);
}
