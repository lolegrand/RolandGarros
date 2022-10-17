package fr.rolandgarros.model;

import java.sql.Date;

public class Person {

    private final String lastname;

    private final String firstname;

    private final Date birthDate;

    private final String birthPlace;

    public Person(String lastname, String firstname, Date birthDate, String birthPlace) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }
}
