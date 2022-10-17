package fr.rolandgarros.model;

import java.sql.Date;

public class Person {

    private String lastname;

    private String firstname;

    private Date birthDate;

    private String birthPlace;

    public Person(String lastname, String firstname, Date birthDate, String birthPlace) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
    }
}
