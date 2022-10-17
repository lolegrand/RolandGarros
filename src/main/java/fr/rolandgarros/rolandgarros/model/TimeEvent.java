package fr.rolandgarros.rolandgarros.model;

import java.sql.Date;

public abstract class TimeEvent {

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
}
