package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.core.Utils;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.dal.PersonDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private final DateFormat df = Utils.dateFormat;
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;


    @Override
    public void createPerson(Person person) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
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
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.remove(person);
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
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            person = entityManager.createQuery( "SELECT p FROM Person p WHERE p.firstname = :f AND p.lastname = :l", Person.class )
                    .setParameter("f","trainer").setParameter("l","fefe").getSingleResult();


        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

     return person;
    }

    @Override
    public Person getById(Integer id) {
        throw new NotImplementedException();
    }

    @Override
    public List<Person> getAllPerson() {
        ArrayList<Person> trainers = new ArrayList<Person>();
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            trainers = (ArrayList<Person>) entityManager.createQuery( "FROM Person p WHERE p NOT IN (From Player)", Person.class )
                    .getResultList();
    }finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
        return trainers;
    }

    @Override
    public Person getPersonById(int personId) {
        throw new NotImplementedException(); // TODO
    }
}
