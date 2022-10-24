package fr.rolandgarros.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "player")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String lastname;

    private  String firstname;

    private  Date birthDate;

    private  String birthPlace;



    public Person(String lastname, String firstname, Date birthDate, String birthPlace) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
    }

    public Person() {

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
