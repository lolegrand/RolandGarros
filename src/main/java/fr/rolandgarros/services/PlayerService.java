package fr.rolandgarros.services;

import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PlayerDAO;
import fr.rolandgarros.model.dal.stub.PlayerDAOMock;

import java.sql.Date;
import java.util.List;

public class PlayerService {

        private final PlayerDAO playerDAO = new PlayerDAOMock();

        public Player getPlayerByName(String lastName, String firstName) {
                return playerDAO.getPlayerByName(firstName, lastName);
        }

        public List<Player> getAllPlayer() {
                return playerDAO.getAllPlayer();
        }


        void create(Player player){ playerDAO.createPlayer( player ); }

        void update(Player player){ playerDAO.updatePlayer( player );}

        void delete(Player player){ playerDAO.deletePlayer( player ); }


        public boolean checkGender( String gender ){
                boolean checked = false;

                if ( gender != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkBirthDate( Date birthdate ){
                boolean checked = false;

                if ( birthdate != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkBirthPlace( String birthplace ){
                boolean checked = false;

                if ( birthplace != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkRanking( Integer ranking ){
                boolean checked = false;

                if ( ranking != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkBestRanking( Integer bestRanking ){
                boolean checked = false;

                if ( bestRanking != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkNationality( String nationality ){
                boolean checked = false;

                if ( nationality != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkHeight( Float height ){
                boolean checked = false;

                if ( height != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkWeight( Float weight ){
                boolean checked = false;

                if ( weight != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkStartCareer( Integer startCareer ){
                boolean checked = false;

                if ( startCareer != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkHand( Hand hand ){
                boolean checked = false;

                if ( hand != null ){
                        checked = true;
                }

                return checked;
        }

        public boolean checkTrainer( Person trainer ){
                boolean checked = false;

                if ( trainer != null ){
                        checked = true;
                }

                return checked;
        }
}
