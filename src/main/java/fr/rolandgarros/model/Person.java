package fr.rolandgarros.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

import java.sql.Date;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE , generator = "player_person_id")
    @TableGenerator(table = "sequences", name = "player_person_id",allocationSize = 1)
    @Column(name = "idP")
    private Integer id = 0;


    @Column(name = "lastname", nullable = false)
    private  String lastname;

    @Column(name = "firstname", nullable = false)
    private  String firstname;

    @Column(name = "birthdate", nullable = false)
    private  Date birthDate;

    @Column(name = "birthPlace", nullable = false)
    private  String birthPlace;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;



    public Person(String lastname, String firstname, Date birthDate, String birthPlace,Gender gender) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this == null) {
            return false;
        }
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return this.firstname.equals(person.getFirstname()) && this.lastname.equals(person.getLastname()) && this.birthDate.equals(person.getBirthDate()) && this.birthPlace.equals(person.getBirthPlace())
                    && this.gender.equals(person.getGender()) && this.id.equals(person.getId());
        }

        return false;
    };

}
