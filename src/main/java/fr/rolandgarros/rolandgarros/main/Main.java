package fr.rolandgarros.rolandgarros.main;

import fr.rolandgarros.rolandgarros.model.Player;
import fr.rolandgarros.rolandgarros.model.Single;
import fr.rolandgarros.rolandgarros.model.Training;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    public static void main(String[] args) {
        //Get all players from bd with JPA entity manager

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("test");
            entityManager = entityManagerFactory.createEntityManager();
//
//
//            System.out.println( "- Insertion d'un nouvel joueur ----------" );
//
//            EntityTransaction trans = entityManager.getTransaction();
//            trans.begin();
//
//            Person trainer = new Person("Trainer fefe from java", "SAIDOUN", Date.valueOf("2000-12-11"), "Tamanrasset");
//            entityManager.persist(trainer);
//
//            Player fefewithjava = new Player("fefewithjava", "SAIDOUN Player",Date.valueOf("2000-12-11"), "Tamanrasset", 1, 1, "Algerian", 1.80f, 80f, Date.valueOf("2015-12-11"), Hand.RIGHT_HANDED, trainer);
//            entityManager.persist( fefewithjava );
//
//            Player fefewithjavap2 = new Player("player2", "type Player",Date.valueOf("2001-12-11"), "Alger", 1, 1, "Algerian", 1.80f, 80f, Date.valueOf("2014-12-11"), Hand.LEFT_HANDED, trainer);
//            entityManager.persist( fefewithjavap2 );
//
//            Training entrainemnt = new Training(Timestamp.valueOf("2017-11-15 15:00:00"), trainer);
//            entityManager.persist(entrainemnt);
//
//            Person trainer2 = new Person("Trainer lamda from java", "xxxx", Date.valueOf("2000-12-11"), "Alger");
//            entityManager.persist(trainer2);
//
//            Training entrainemnt2 = new Training(Timestamp.valueOf("2017-11-16 15:30:00"), trainer2);
//            entityManager.persist(entrainemnt2);
//
//            Person trainer3 = new Person("Trainer lamda 2 from java", "xxxx", Date.valueOf("2000-12-11"), "Alger");
//            entityManager.persist(trainer3);
//
//            Training entrainemnt3 = new Training(Timestamp.valueOf("2017-11-17 15:30:00"), trainer3);
//            entityManager.persist(entrainemnt3);
//
//            Court court1 = new Court("terrain1");
//            entityManager.persist(court1);
//
//            Single matchSimple = new Single("Homme",Timestamp.valueOf("2017-11-15 15:00:00"),court1,fefewithjava,fefewithjavap2);
//            entityManager.persist(matchSimple);
//
//            trans.commit();

            System.out.println( "------------------ Lecture de tous les joueurs ----------- \n" );

            List<Player> playerrs = entityManager.createQuery( "from Player", Player.class ).getResultList();
            for (Player player : playerrs) {
                System.out.println( "Player : Name :  " + player.getLastname()
                        + ", " +  player.getFirstname() + ", Date de naissance : "+ player.getBirthDate()+" Hand : " +player.getHand() + "\nTrainer : Name : " + player.getTrainer().getLastname() + ", " + player.getTrainer().getFirstname() + ", Date de naissance : " + player.getTrainer().getBirthDate() + "\n" );
            }
            System.out.println( "------------------ Lecture de tous les training ----------- \n" );

            List<Training> trainings = entityManager.createQuery( "from Training ", Training.class ).getResultList();
            for (Training  t : trainings) {
                System.out.println( "Training : dateDebut : "+ t.getStartDate() + " \nBooker :" +  t.getBooker().getLastname() + ", " + t.getBooker().getFirstname() + ", Date de naissance : " + t.getBooker().getBirthDate() + "\n" );
            }

            System.out.println( "------------------ Lecture de tous les matches simples ----------- \n" );

            List<Single> games = entityManager.createQuery( "from Single ", Single.class ).getResultList();
            for (Single game : games) {
                System.out.println( "Game : genre :  " + game.getGenre()
                        + ", " +  game.getStartDate() + ", Court : "+ game.getCourt().getName()+" Player 1 : " +game.getPlayerOne().getFirstname() + "\nPlayer 2 : " + game.getPlayerTwo().getFirstname() + "\n" );
            }


        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();

        }
    }
}
