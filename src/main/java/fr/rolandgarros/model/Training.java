package fr.rolandgarros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "trainingGame")
public class Training extends TimeEvent{
    @OneToOne
    @JoinColumn(name = "bookerId")
    private Person booker;

    public Training(Timestamp startDate, Person booker) {
        super(startDate);
        this.booker = booker;
    }

    public Training() {}

    public Person getBooker() {
        return booker;
    }
    public void setBooker(Person booker) {
        this.booker = booker;
    }
}
