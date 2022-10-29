package fr.rolandgarros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.Random;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TimeEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE , generator = "timeEventId")
    @TableGenerator(table = "sequences", name = "timeEventId" ,allocationSize = 1)
    private Integer idT;

    protected  Timestamp startDate;

    protected Timestamp endDate;

    public TimeEvent(Timestamp startDate) {
        this.startDate = startDate;
    }

    public TimeEvent() {}

    public void endTimeEvent(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getStartDate() {
        return this.startDate;
    }
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Boolean isTimeEventPassed() {
        return endDate == null;
    }

    public Timestamp getEndDate() {
        if (!isTimeEventPassed()) { //TODO: check if this is correct to make changes in data base
            throw new RuntimeException("Match has not been passed yet");
        }
        return endDate;
    }
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Integer getIdT() {
        return idT;
    }
}