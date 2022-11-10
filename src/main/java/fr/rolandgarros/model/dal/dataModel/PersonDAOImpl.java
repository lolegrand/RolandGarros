package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.JPAService;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PersonDAO;
import fr.rolandgarros.services.PlayerService;


import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public void createPerson(Person person) {

        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(person);
                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void modifyPerson(Person person) {
        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(entityManager.merge(person));
                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void deletePerson(Person person) {
        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                PlayerService playerService = new PlayerService();
                List<Player> playersByTrainer = playerService.getPlayersByTrainer(person); //FIXME get all players by trainer to remove them because a player must have a trainer and in our conception a trainer is a person maby we could create trainer class with inheritance from person

                if (playersByTrainer.size() > 0) {
                    for (Player player : playersByTrainer) {
                        playerService.deletePlayer(player);
                    }
                }else {
                    entityManager.remove(entityManager.merge(person));
                }

                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public Person getPersonByName(String firstName, String lastName) {

        JPAService jpaService = JPAService.getInstance();

        Person person;
        try {

            person =  jpaService.runInTransaction(entityManager -> entityManager.createQuery( "SELECT p FROM Person p WHERE p.firstname = :firstname AND p.lastname = :lastname", Person.class )
                    .setParameter("firstname",firstName)
                    .setParameter("lastname",lastName)
                    .getSingleResult());

        } finally {
            jpaService.shutdown();
        }
        return person;
    }

    @Override
    public List<Person> getAllPerson() { // get all trainers

        JPAService jpaService = JPAService.getInstance();

        List<Person> trainers;
        try {

            trainers =  jpaService.runInTransaction(entityManager -> entityManager.createQuery( "FROM Person", Person.class ).getResultList());

        } finally {
            jpaService.shutdown();
        }
        return trainers;
    }
}
