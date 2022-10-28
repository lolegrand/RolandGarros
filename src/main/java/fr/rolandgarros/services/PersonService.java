package fr.rolandgarros.services;

import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.dal.PersonDAO;
import fr.rolandgarros.model.dal.stub.PersonDAOMock;

import java.util.List;

public class PersonService {

    private final PersonDAO personDAO = new PersonDAOMock();

    public Person getPersonByName(String lastName, String firstName) {
        return personDAO.getPersonByName(firstName, lastName);
    }
}