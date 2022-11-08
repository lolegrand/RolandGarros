package fr.rolandgarros.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.sql.Timestamp;

public class Training extends TimeEvent {

    @OneToOne(
            targetEntity = Person.class,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    @JoinColumn(name = "bookerId")
    private Person booker;

    @OneToOne (
            targetEntity = Court.class,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
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
