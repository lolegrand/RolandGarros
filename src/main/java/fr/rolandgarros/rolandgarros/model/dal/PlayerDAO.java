package fr.rolandgarros.rolandgarros.model.dal;

import fr.rolandgarros.rolandgarros.model.Player;

public interface PlayerDAO {

    void createPlayer(Player player);

    void deletePlayer(Player player);

    void modifyPlayer(Player player);

    void getPlayerByName(String firstName, String lastName);
}
