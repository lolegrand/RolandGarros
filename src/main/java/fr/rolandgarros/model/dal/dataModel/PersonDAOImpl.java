package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.PersistenceManager;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PersonDAO;
import fr.rolandgarros.services.PlayerService;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public void createPerson(Person person) {
        PersistenceManager.runInTransaction(entityManager -> {
                entityManager.merge(person);
                return null;
            });
    }
    @Override
    public void modifyPerson(Person person) {
        PersistenceManager.runInTransaction(entityManager -> {
                entityManager.merge(person);
                return null;
            });
    }
    @Override
    public void deletePerson(Person person) {

        PlayerService playerService = new PlayerService();
        List<Player> playersByTrainer = playerService.getPlayersByTrainer(person); // get all players by trainer then set trainer to null
        if (playersByTrainer.size() > 0) {
            for (Player player : playersByTrainer) {
                player.setTrainer(null);
                playerService.modifyPlayer(player);
            }
        }


        PersistenceManager.runInTransaction(entityManager -> {
                entityManager.remove(entityManager.merge(person));
                return null;
            });
    }
    @Override
    public Person getPersonByName(String lastName, String firstName) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery( "SELECT p FROM Person p WHERE p.firstname = :firstname AND p.lastname = :lastname", Person.class )
                    .setParameter("firstname",firstName)
                    .setParameter("lastname",lastName)
                    .getSingleResult());
    }
    @Override
    public List<Person> getAllPerson() { // get all trainers
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery( "SELECT p FROM Person p WHERE p NOT IN (FROM Player)", Person.class ).getResultList());
    }

    @Override
    public Person getPersonById(int personId) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.find(Person.class,personId));
    }

}
