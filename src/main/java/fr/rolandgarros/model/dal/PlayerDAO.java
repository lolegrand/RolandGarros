package fr.rolandgarros.model.dal;

import fr.rolandgarros.rolandgarros.model.Hand;
import fr.rolandgarros.rolandgarros.model.Person;
import fr.rolandgarros.rolandgarros.model.Player;
import fr.rolandgarros.model.Player;

import java.util.ArrayList;

public interface PlayerDAO {

    void createPlayer(Player player);

    void deletePlayer(Player player);

    void modifyPlayer(Player player);

    Player getPlayerByName(String firstName, String lastName);

    ArrayList<Player> getPlayerByGender(String gender);

    ArrayList<Player> getPlayerByRank(Integer rank);

    ArrayList<Player> getPlayerByNationality(String nationality);

    ArrayList<Player> getPlayerByHeight(Float height);

    ArrayList<Player> getPlayerByWeight(Float weight);

    ArrayList<Player> getPlayerByStartCareer(Integer startCareer);

    ArrayList<Player> getPlayerByHand(Hand hand);

    ArrayList<Player> getPlayerByTrainer(Person trainer);


}
