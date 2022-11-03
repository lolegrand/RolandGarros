package fr.rolandgarros.model.dal.stub;

import fr.rolandgarros.core.Utils;
import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.dal.PersonDAO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOMock implements PersonDAO {
    private final DateFormat df = Utils.dateFormat;

    private final List<Person> persons = new ArrayList<Person>() {{
        try {
            add(new Person(
                    "Benhabiles",
                    "Arik ",
                    new Date(df.parse("05-02-1965 00:00").getTime()),
                    "Alger",
                    Gender.MALE
                    ));
            add(new Person(
                    "Béranger",
                    "Olivier ",
                    new Date(df.parse("25-07-1967 00:00").getTime()),
                    "Tour",
                    Gender.MALE
            ));
            add(new Person(
                    "Contet",
                    "Daniel ",
                    new Date(df.parse("03-11-1943 00:00").getTime()),
                    "Tour",
                    Gender.FEMALE
            ));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }};

    @Override
    public void createPerson(Person person) {
        this.persons.add(person);
    }

    @Override
    public void deletePerson(Person person) {
        this.persons.remove(person);
    }

    @Override
    public void modifyPerson(Person person) {
        this.persons.remove(person);
        this.persons.add(person);
    }

    @Override
    public Person getPersonByName(String lastName, String firstName) {
        for (Person person : persons) {
            if (person.getFirstname().equals(firstName) && person.getLastname().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person getById(Integer id) {
        for (Person person : persons) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> getAllPerson() {
        return persons;
    }

    @Override
    public Person getPersonById(int personId) {
        for (Person person: persons) {
            if (person.getId() == personId) {
                return person;
            }
        }
        return null;
    }
}
