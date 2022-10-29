package fr.rolandgarros.services;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PlayerDAO;
import fr.rolandgarros.model.dal.dataModel.PlayerDAOImpl;
import fr.rolandgarros.model.dal.stub.PlayerDAOMock;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class PlayerService {

        private final PlayerDAO playerDAO = new PlayerDAOMock();

    public static  void createPlayer(Player player){
        playerDAO.createPlayer(player);
    }
    public static  void deletePlayer(Player player){
        playerDAO.deletePlayer(player);
    }
    public static  void modifyPlayer(Player player){
        playerDAO.modifyPlayer(player);
    }
    public static  Player getPlayerByName(String lastName, String firstName){
        return playerDAO.getPlayerByName(lastName, firstName);
    }
    public static ArrayList<Player> getALLPlayers(){
        return playerDAO.getAllPlayers();
    }
    public static ArrayList<Player> getPlayersByGender(Gender gender) {
        return playerDAO.getPlayersByGender(gender);
    }
    public static ArrayList<Player> getPlayersByRank(Integer rank) {
       return playerDAO.getPlayersByRank(rank);
    }
    public static ArrayList<Player> getPlayersByNationality(String nationality) {
        return playerDAO.getPlayersByNationality(nationality);
    }
    public static ArrayList<Player> getPlayersByHeight(Float height) {

      return playerDAO.getPlayersByHeight(height);
    }
    public static ArrayList<Player> getPlayersByWeight(Float weight) {

      return playerDAO.getPlayersByWeight(weight);
    }
    public static ArrayList<Player> getPlayersByStartCareer(Date startCareer) {
        public boolean checkBestRanking( Integer bestRanking ){
                return bestRanking.compareTo(0) != -1 && bestRanking.compareTo(0) != 0;
        }

        public boolean checkNationality( String nationality ){
                return !nationality.isEmpty();
        }

        public boolean checkHeight( Float height ){
                return height.compareTo(150f) != -1 && height.compareTo(150f) != 0 ;
        }

       return playerDAO.getPlayersByStartCareer(startCareer);
    }
    public static ArrayList<Player> getPlayersByHand(Hand hand) {
         return playerDAO.getPlayersByHand(hand);
    }
    public static ArrayList<Player> getPlayersByTrainer(Person trainer) {
       return playerDAO.getPlayersByTrainer(trainer);
    }
        public boolean checkWeight( Float weight ){
                return weight.compareTo(40f) != -1 && weight.compareTo(40f) != 0 ;
        }

        public boolean checkStartCareer( Date birthdate, Integer startCareer ){
                Date sc = new Date(startCareer);
                return birthdate.compareTo(sc) != 0 && birthdate.compareTo(sc) != 1;
        }

        public boolean checkHand( Hand hand ){
                return hand.equals(Hand.LEFT_HANDED)
                        || hand.equals(Hand.RIGHT_HANDED)
                        || hand.equals(Hand.AMBIDEXTROUS);
        }

        public boolean checkTrainer( Person trainer ){
                return trainer != null;
        }
}
