package fr.rolandgarros.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table( name = "trainingGame" )
public class Training extends TimeEvent {

    @OneToOne(
            targetEntity = Person.class,
            cascade = {CascadeType.REMOVE}
    )
    @JoinColumn(name = "bookerId")
    private Person booker;

    @OneToOne (
            targetEntity = Court.class,
            cascade = {CascadeType.REMOVE}
    )
    @JoinColumn(name = "courtId")
    private Court court;

    @Column(name = "isValidated")
    private Boolean isValidated = null;

    public Training(Timestamp startDate, Person booker, Court court) {
        super(startDate);
        this.booker = booker;
        this.court = court;
    }

    public Training() {}

    public Person getBooker() {
        return booker;
    }

    public Court getCourt() {
        return court;
    }

    public Boolean getValidated() {
        return isValidated;
    }

    public void setValidated(Boolean validated) {
        isValidated = validated;
    }

}
