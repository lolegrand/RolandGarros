package fr.rolandgarros.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
