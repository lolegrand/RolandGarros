package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.JPAService;
import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PlayerDAO;


import java.sql.Date;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO {

    @Override
    public void createPlayer(Player player) {
        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(player);
                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void deletePlayer(Player player) {
        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.remove(entityManager.merge(player));
                return null;
            });

        } finally {
            jpaService.shutdown();
        }

    }

    @Override
    public void updatePlayer(Player player) {
        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(entityManager.merge(player));
                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public Player getPlayerByName(String firstName, String lastName) {
        JPAService jpaService = JPAService.getInstance();

        Player player;
        try {

           player =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.firstname = :firstName AND p.lastname = :lastName", Player.class)
                   .setParameter("firstName", firstName)
                   .setParameter("lastName", lastName)
                   .getSingleResult());

        } finally {
            jpaService.shutdown();
        }
        return player;
    }

    @Override
    public List<Player> getAllPlayer() {
        JPAService jpaService = JPAService.getInstance();

        List<Player> players;
        try {

            players =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Player", Player.class).getResultList());


        } finally {
            jpaService.shutdown();
        }

        return players;
    }

    @Override
    public List<Player> getPlayerByGender(Gender gender) {
        JPAService jpaService = JPAService.getInstance();

        List<Player> players;
        try {

            players =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.gender = ?1 ", Player.class).
                    setParameter(1,gender).getResultList());


        } finally {
            jpaService.shutdown();
        }

        return players;
    }

    @Override
    public List<Player> getPlayerByRank(Integer rank) {
        JPAService jpaService = JPAService.getInstance();

        List<Player> players;
        try {

            players =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.ranking = :rank ", Player.class)
                    .setParameter("rank", rank).getResultList());


        } finally {
            jpaService.shutdown();
        }

        return players;
    }

    @Override
    public List<Player> getPlayerByNationality(String nationality) {

        JPAService jpaService = JPAService.getInstance();
        List<Player> players;
        try {

            players =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.nationality = :nationality", Player.class)
                    .setParameter("nationality", nationality).getResultList());

        } finally {
            jpaService.shutdown();
        }

        return players;
    }

    @Override
    public List<Player> getPlayerByHeight(Float height) {

        JPAService jpaService = JPAService.getInstance();

        List<Player> players;
        try {

            players =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.height = :height", Player.class)
                    .setParameter("height",height).getResultList());


        } finally {
            jpaService.shutdown();
        }

        return players;
    }

    @Override
    public List<Player> getPlayerByWeight(Float weight) {

        JPAService jpaService = JPAService.getInstance();

        List<Player> players;
        try {

            players =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.weight = :weight", Player.class)
                    .setParameter("weight",weight).getResultList());


        } finally {
            jpaService.shutdown();
        }

        return players;
    }

    @Override
    public List<Player> getPlayerByStartCareer(Date startCareer) {

        JPAService jpaService = JPAService.getInstance();

        List<Player> players;
        try {

            players =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.startCareer = :startCareer", Player.class)
                    .setParameter("startCareer",startCareer).getResultList());


        } finally {
            jpaService.shutdown();
        }

        return players;
    }

    @Override
    public List<Player> getPlayerByHand(Hand hand) {

        JPAService jpaService = JPAService.getInstance();

        List<Player> players;
        try {

            players =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.hand = ?1", Player.class)
                    .setParameter(1,hand).getResultList());


        } finally {
            jpaService.shutdown();
        }

        return players;
    }

    @Override
    public List<Player> getPlayerByTrainer(Person trainer) {
        JPAService jpaService = JPAService.getInstance();

        List<Player> players;
        try {

            players =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.trainer = ?1", Player.class).
                    setParameter(1,trainer).getResultList());


        } finally {
            jpaService.shutdown();
        }

        return players;
    }
}
