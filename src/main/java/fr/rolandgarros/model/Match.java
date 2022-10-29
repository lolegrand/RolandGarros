package fr.rolandgarros.model;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

public abstract class Match extends TimeEvent {

    private final String genre;
    private final String type;

    private List<Integer> scoreOne;

    private List<Integer> scoreTwo;

    private final Court court;

    public Match(String genre, Date startDate, String type, Court court) {
        super(startDate);
        this.genre = genre;
        this.type = type;
        this.court = court;
    }

    public void endMatch(Date endDate, List<Integer> scoreOne, List<Integer> scoreTwo) {
        super.endTimeEvent(endDate);
        this.scoreOne = scoreOne;
        this.scoreTwo = scoreTwo;
    }

    public String getGenre() {
        return genre;
    }
    public String getType() { return type; }

    public List<Integer> getScoreOne() {
        if (!isTimeEventPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }
        return Collections.unmodifiableList(scoreOne);
    }

    public List<Integer> getScoreTwo() {
        if (!isTimeEventPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }
        return Collections.unmodifiableList(scoreTwo);
    }

    public Court getCourt() {
        return court;
    }
}
