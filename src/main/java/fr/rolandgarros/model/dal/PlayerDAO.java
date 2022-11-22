package fr.rolandgarros.model.dal;


import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;

import java.sql.Date;
import java.util.List;

public interface PlayerDAO {

    void createPlayer(Player player);
    void deletePlayer(Player player);

    void updatePlayer(Player player);

    Player getPlayerByName(String firstName, String lastName);
    Player getPlayerById(int id);
    List<Player> getPlayerByGender(Gender gender);

    List<Player> getPlayerByRank(Integer rank);

    List<Player> getPlayerByNationality(String nationality);

    List<Player> getPlayerByHeight(Float height);

    List<Player> getPlayerByWeight(Float weight);

    List<Player> getPlayerByStartCareer(Date startCareer);

    List<Player> getPlayerByHand(Hand hand);

    List<Player> getPlayerByTrainer(Person trainer);

    List<Player> getAllPlayer();

}
