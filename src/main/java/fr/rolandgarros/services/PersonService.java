package fr.rolandgarros.services;

import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.dal.PersonDAO;
import fr.rolandgarros.model.dal.stub.PersonDAOMock;

public class PersonService {

    private static final PersonDAO PersonDAO = new PersonDAOMock();

    public void createPerson(Person person){
        PersonDAO.createPerson(person);
    }

    public void deletePerson(Person person){
        PersonDAO.deletePerson(person);
    }

    public void modifyPerson(Person person){
        PersonDAO.modifyPerson(person);
    }

    public Person getPersonByName(String lastName, String firstName){
        return PersonDAO.getPersonByName(lastName, firstName);
    }

    public Person getPersonByName(String lastName, String firstName) {
        return personDAO.getPersonByName(firstName, lastName);
    }

}