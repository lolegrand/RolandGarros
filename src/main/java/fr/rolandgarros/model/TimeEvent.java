package fr.rolandgarros.model;

import java.sql.Date;
import java.util.Random;

public abstract class TimeEvent {

    private Integer idT = new Random().nextInt();

    protected final Date startDate;

    protected Date endDate;

    public TimeEvent(Date startDate) {
        this.startDate = startDate;
    }

    public void endTimeEvent(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Boolean isTimeEventPassed() {
        return endDate == null;
    }

    public Date getEndDate() {
        if (!isTimeEventPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }
        return endDate;
    }

    public Integer getIdT() {
        return idT;
    }
}
