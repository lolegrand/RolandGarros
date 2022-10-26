package fr.rolandgarros.services;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PlayerDAO;
import fr.rolandgarros.model.dal.stub.PlayerDAOMock;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class PlayerService {

        private final PlayerDAO playerDAO = new PlayerDAOMock();

        public Player getPlayerByName(String lastName, String firstName) {
                return playerDAO.getPlayerByName(firstName, lastName);
        }

        public List<Player> getAllPlayer() {
                return playerDAO.getAllPlayer();
        }


        public void create(Player player){ playerDAO.createPlayer( player ); }

        public void update(Player player){ playerDAO.updatePlayer( player );}

        public void delete(Player player){ playerDAO.deletePlayer( player ); }


        public boolean checkGender( String gender ){
                return gender.equals("Male") || gender.equals("Female");
        }

        public boolean checkBirthDate( Date birthdate ){
                Date fifteenYearsAgo = new Date((System.currentTimeMillis()/1000/3600/24/365) - 15);
                return !birthdate.before(fifteenYearsAgo);
        }

        public boolean checkBirthPlace( String birthplace ){
                return !birthplace.isEmpty();
        }

        public boolean checkRanking( Integer ranking ){
                return ranking.compareTo(0) != -1 && ranking.compareTo(0) != 0;
        }

        public boolean checkBestRanking( Integer bestRanking ){
                return bestRanking.compareTo(0) != -1 && bestRanking.compareTo(0) != 0;
        }

        public boolean checkNationality( String nationality ){
                return !nationality.isEmpty();
        }

        public boolean checkHeight( Float height ){
                return height.compareTo(150f) != -1 && height.compareTo(150f) != 0 ;
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
