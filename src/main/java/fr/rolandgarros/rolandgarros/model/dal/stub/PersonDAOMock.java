package fr.rolandgarros.rolandgarros.model.dal.stub;

import fr.rolandgarros.rolandgarros.core.Utils;
import fr.rolandgarros.rolandgarros.model.Person;
import fr.rolandgarros.rolandgarros.model.dal.PersonDAO;

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
                    "Alger"));
            add(new Person(
                    "Béranger",
                    "Olivier ",
                    new Date(df.parse("25-07-1967 00:00").getTime()),
                    "Tour"));
            add(new Person(
                    "Contet",
                    "Daniel ",
                    new Date(df.parse("03-11-1943 00:00").getTime()),
                    "Tour"));
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
    public Person getPersonByName(String firstName, String lastName) {
        for (Person person : persons) {
            if (person.getFirstname().equals(firstName) && person.getLastname().equals(lastName)) {
                return person;
            }
        }
        return null;
    }
}
