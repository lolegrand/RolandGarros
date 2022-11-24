package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.PersistenceManager;
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
            PersistenceManager.runInTransaction(entityManager -> {
                entityManager.persist(entityManager.merge(player));
                return null;
            });
    }
    @Override
    public void deletePlayer(Player player) {
            PersistenceManager.runInTransaction(entityManager -> {
                entityManager.remove(entityManager.merge(player));
                return null;
            });
    }
    @Override
    public void updatePlayer(Player player) {
            PersistenceManager.runInTransaction(entityManager -> {
                entityManager.merge(player);
                return null;
            });
    }
    @Override
    public Player getPlayerByName(String firstName, String lastName) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.firstname = :firstName AND p.lastname = :lastName", Player.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .getSingleResult());
    }
    @Override
    public Player getPlayerById(int id) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.find(Player.class, id));
    }
    @Override
    public List<Player> getAllPlayer() {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Player", Player.class).getResultList());
    }
    @Override
    public List<Player> getPlayerByGender(Gender gender) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.gender = ?1 ", Player.class).
                setParameter(1,gender).getResultList());
    }
    @Override
    public List<Player> getPlayerByRank(Integer rank) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.ranking = :rank ", Player.class)
                .setParameter("rank", rank).getResultList());
    }
    @Override
    public List<Player> getPlayerByNationality(String nationality) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.nationality = :nationality", Player.class)
                    .setParameter("nationality", nationality).getResultList());
    }
    @Override
    public List<Player> getPlayerByHeight(Float height) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.height = :height", Player.class)
                    .setParameter("height",height).getResultList());
    }
    @Override
    public List<Player> getPlayerByWeight(Float weight) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.weight = :weight", Player.class)
                    .setParameter("weight",weight).getResultList());
    }
    @Override
    public List<Player> getPlayerByStartCareer(Date startCareer) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.startCareer = :startCareer", Player.class)
                    .setParameter("startCareer",startCareer).getResultList());
    }
    @Override
    public List<Player> getPlayerByHand(Hand hand) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.hand = ?1", Player.class)
                    .setParameter(1,hand).getResultList());
    }
    @Override
    public List<Player> getPlayerByTrainer(Person trainer) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT p FROM Player p WHERE p.trainer = ?1", Player.class).
                    setParameter(1,trainer).getResultList());
    }
}
