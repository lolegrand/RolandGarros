package fr.rolandgarros.model;

import java.sql.Timestamp;

public class Training extends TimeEvent {

    private Person booker;

    private Court court;

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
