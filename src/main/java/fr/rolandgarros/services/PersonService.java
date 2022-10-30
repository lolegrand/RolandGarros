package fr.rolandgarros.services;

import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.dal.PersonDAO;
import fr.rolandgarros.model.dal.stub.PersonDAOMock;

import java.util.List;

public class PersonService {

    private static final PersonDAO personDAO = new PersonDAOMock();

    public void createPerson(Person person){
        personDAO.createPerson(person);
    }

    public void deletePerson(Person person){
        personDAO.deletePerson(person);
    }

    public void modifyPerson(Person person){
        personDAO.modifyPerson(person);
    }

    public Person getPersonByName(String lastName, String firstName){
        return personDAO.getPersonByName(lastName, firstName);
    }

    public List<Person> getAllPerson(){
        return personDAO.getAllPerson();
    }
}