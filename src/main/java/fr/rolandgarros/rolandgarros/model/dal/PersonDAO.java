package fr.rolandgarros.rolandgarros.model.dal;

import fr.rolandgarros.rolandgarros.model.Person;

public interface PersonDAO {

    void createPerson(Person person);

    void deletePerson(Person person);

    void modifyPerson(Person person);

    Person getPersonByName(String firstName, String lastName);
}
