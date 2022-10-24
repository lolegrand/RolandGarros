package fr.rolandgarros.rolandgarros.main;

import fr.rolandgarros.rolandgarros.model.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

        public static void main(String[] args) {
            EntityManagerFactory entityManagerFactory = null;
            EntityManager entityManager = null;

            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");

                entityManager = entityManagerFactory.createEntityManager();

                System.out.println( "*********************Getting all players****************" );

                List<Player> players = entityManager.createQuery( "from Player", Player.class ).getResultList();
                for (Player player : players) {
                    System.out.println( "Player : Name :  " + player.getLastname()
                            + ", " +  player.getFirstname() + ", Date de naissance : "+ player.getBirthDate() + " \n Trainer : Name : " + player.getTrainer().getLastname() + ", " + player.getTrainer().getFirstname() + ", Date de naissance : " + player.getTrainer().getBirthDate() + "\n" );
                }


            }		catch (Exception e){
                e.printStackTrace();

            } finally {
                if ( entityManager != null ) entityManager.close();
                if ( entityManagerFactory != null ) entityManagerFactory.close();
            }
        }

}
