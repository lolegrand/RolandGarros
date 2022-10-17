package fr.rolandgarros.rolandgarros.model;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

public abstract class Match {

    private String genre;

    private Date startDate;

    private Date endDate;

    private List<Integer> scoreOne;

    private List<Integer> scoreTwo;

    public Match(String genre, Date startDate) {
        this.genre = genre;
        this.startDate = startDate;
    }

    public void endMatch(Date endDate, List<Integer> scoreOne, List<Integer> scoreTwo) {
        this.endDate = endDate;
        this.scoreOne = scoreOne;
        this.scoreTwo = scoreTwo;
    }

    public Boolean isMatchPassed() {
        return endDate == null;
    }

    public String getGenre() {
        return genre;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        if (!isMatchPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }
        return endDate;
    }

    public List<Integer> getScoreOne() {
        if (!isMatchPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }
        return Collections.unmodifiableList(scoreOne);
    }

    public List<Integer> getScoreTwo() {
        if (!isMatchPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }
        return Collections.unmodifiableList(scoreTwo);
    }
}
