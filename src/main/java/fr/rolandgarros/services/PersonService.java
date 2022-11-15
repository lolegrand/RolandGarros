package fr.rolandgarros.services;

import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.dal.PersonDAO;
import fr.rolandgarros.model.dal.dataModel.PersonDAOImpl;
import fr.rolandgarros.model.dal.stub.PersonDAOMock;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    //private static final PersonDAO personDAO = new PersonDAOMock();
    private static final PersonDAO personDAO = new PersonDAOImpl();

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


    public boolean checkPersonExsist(Person person){
        List<Person> allPerson = getAllPerson();
        for (Person p : allPerson) {
            if (person.equals(p)){
                return true;
            }
        }
        return false;
    }
}