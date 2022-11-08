package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.core.Utils;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PersonDAO;
import fr.rolandgarros.services.PlayerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.DateFormat;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private final DateFormat df = Utils.dateFormat;
    private  EntityManagerFactory entityManagerFactory = null;
    private  EntityManager entityManager = null;

    private final String persistenceUnitName = "RolandGarros";


    @Override
    public void createPerson(Person person) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            person = entityManager.merge(person);
            entityManager.persist(person);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

    @Override
    public void deletePerson(Person person) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            PlayerService playerService = new PlayerService();
            List<Player> playersByTrainer = playerService.getPlayersByTrainer(person); // get all players by trainer to remove them because a player must have a trainer and in our conception a trainer is a person maby we could create trainer class with inheritance from person

            if (playersByTrainer.size() > 0) {
                for (Player player : playersByTrainer) {
                    playerService.deletePlayer(player);
                }
            }else {
                person = entityManager.merge(person);
                entityManager.remove(person);
            }

            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

    @Override
    public void modifyPerson(Person person) {
        createPerson(person);
    }

    @Override
    public Person getPersonByName(String firstName, String lastName) {
        Person person;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            person = entityManager.createQuery( "SELECT p FROM Person p WHERE p.firstname = :f AND p.lastname = :l", Person.class )
                    .setParameter("f",firstName).setParameter("l",lastName).getSingleResult();


        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

        return person;
    }

    @Override
    public List<Person> getAllPerson() { // get all trainers
        List<Person> trainers;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            trainers = entityManager.createQuery( "FROM Person p WHERE p NOT IN (From Player)", Person.class )
                    .getResultList();
        }finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
        return trainers;
    }
}
