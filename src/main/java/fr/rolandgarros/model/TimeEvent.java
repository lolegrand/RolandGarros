package fr.rolandgarros.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TimeEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE , generator = "timeEventId")
    @TableGenerator(table = "sequences", name = "timeEventId" ,allocationSize = 1)
    private Integer idT;

    @Column(name = "startDate", nullable = false)
    protected  Timestamp startDate;

    @Column(name = "endDate")
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
        return endDate != null;
    }

    public Timestamp getEndDate() {
        if (!isTimeEventPassed()) {
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