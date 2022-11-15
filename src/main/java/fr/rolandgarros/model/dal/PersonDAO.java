package fr.rolandgarros.model.dal;

import fr.rolandgarros.model.Person;

import java.util.List;

public interface PersonDAO {

    void createPerson(Person person);

    void deletePerson(Person person);

    void modifyPerson(Person person);

    Person getPersonByName(String lastName, String firstName);
    Person getById(Integer id);

    List<Person> getAllPerson();
}
