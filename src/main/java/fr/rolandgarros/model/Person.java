package fr.rolandgarros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {//@Todo: faut trouver un moyen d'avoir une contrainte unique composé pour rentre unique des joueurs
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE , generator = "player_person_id")
    @TableGenerator(table = "sequences", name = "player_person_id",allocationSize = 1)
    @Column(name = "idP")
    private Integer id;


    private  String lastname;

    private  String firstname;

    private  Date birthDate;

    private  String birthPlace;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Person(String lastname, String firstname, Date birthDate, String birthPlace) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
    }

    public Person() {

    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }
}
