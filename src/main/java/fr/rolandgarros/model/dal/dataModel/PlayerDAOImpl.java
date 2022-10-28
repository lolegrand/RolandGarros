package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PlayerDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO {

    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;



    @Override
    public void createPlayer(Player player) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(player);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

    @Override
    public void deletePlayer(Player player) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.remove(player);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

    }

    @Override
    public void modifyPlayer(Player player) {
        createPlayer(player);
    }

    @Override
    public Player getPlayerByName(String firstName, String lastName) {
        Player player;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            player = entityManager.createQuery( "FROM Player p WHERE p.firstname = :f AND  p.lastname = :l", Player.class )
                    .setParameter("f", firstName).setParameter("l",lastName).getSingleResult();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
        return player;
    }

    @Override
    public ArrayList<Player> getAllPlayers() {
        List<Player> players;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            players = entityManager.createQuery("FROM Player ", Player.class).getResultList();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
        return (ArrayList<Player>) players;
    }

    @Override
    public ArrayList<Player> getPlayersByGender(Gender gender) {
        List<Player> players;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            players = entityManager.createQuery("SELECT p FROM Player p WHERE p.gender = ?1 ", Player.class).
                    setParameter(1,gender).getResultList();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }


        return (ArrayList<Player>) players;
    }

    @Override
    public ArrayList<Player> getPlayersByRank(Integer rank) {

        List<Player> players;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            players = entityManager.createQuery("SELECT p FROM Player p WHERE p.ranking = :rank ", Player.class)
                    .setParameter("rank", rank).getResultList();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }


        return (ArrayList<Player>) players;
    }

    @Override
    public ArrayList<Player> getPlayersByNationality(String nationality) {

        List<Player> players;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            players = entityManager.createQuery("SELECT p FROM Player p WHERE p.nationality = :nationality", Player.class)
                    .setParameter("nationality", nationality).getResultList();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }


        return (ArrayList<Player>) players;
    }

    @Override
    public ArrayList<Player> getPlayersByHeight(Float height) {

        List<Player> players;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            players = entityManager.createQuery("SELECT p FROM Player p WHERE p.height = :height", Player.class)
                    .setParameter("height",height).getResultList();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }


        return (ArrayList<Player>) players;
    }

    @Override
    public ArrayList<Player> getPlayersByWeight(Float weight) {

        List<Player> players;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            players = entityManager.createQuery("SELECT p FROM Player p WHERE p.weight = :weight", Player.class)
                    .setParameter("weight",weight).getResultList();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }


        return (ArrayList<Player>) players;
    }

    @Override
    public ArrayList<Player> getPlayersByStartCareer(Date startCareer) {

        List<Player> players;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            players = entityManager.createQuery("SELECT p FROM Player p WHERE p.startCareer = :startCareer", Player.class)
                    .setParameter("startCareer",startCareer).getResultList();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }


        return (ArrayList<Player>) players;
    }

    @Override
    public ArrayList<Player> getPlayersByHand(Hand hand) {

        List<Player> players;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            players = entityManager.createQuery("SELECT p FROM Player p WHERE p.hand = ?1", Player.class)
                    .setParameter(1,hand).getResultList();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }


        return (ArrayList<Player>) players;
    }

    @Override
    public ArrayList<Player> getPlayersByTrainer(Person trainer) {

        List<Player> players;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            players = entityManager.createQuery("SELECT p FROM Player p WHERE p.trainer = ?1", Player.class).
            setParameter(1,trainer).getResultList();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }


        return (ArrayList<Player>) players;
    }
}
