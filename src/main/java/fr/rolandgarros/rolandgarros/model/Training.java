package fr.rolandgarros.rolandgarros.model;

import java.sql.Date;

public class Training extends TimeEvent{

    private Person booker;

    public Training(Date startDate, Person booker) {
        super(startDate);
        this.booker = booker;
    }

    public Person getBooker() {
        return booker;
    }
}
