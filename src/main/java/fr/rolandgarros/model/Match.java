package fr.rolandgarros.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Match extends TimeEvent {

    private  String genre;

    private String scoreOne;

    private String scoreTwo;

    @OneToOne
    @JoinColumn(name = "courtId")
    private  Court court;

    public Match(String genre, Timestamp startDate, Court court) {
        super(startDate);
        this.genre = genre;
        this.court = court;
    }

    public Match() {

    }

    public void endMatch(Timestamp endDate, String scoreOne, String scoreTwo) {
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
        //parse scoreOne and return it as list of integers
        List<Integer> scoreOne = Collections.emptyList();
        for (String s : this.scoreOne.split(",")) {
            scoreOne.add(Integer.parseInt(s));
        }
        return scoreOne;
    }

    public List<Integer> getScoreTwo() {
        if (!isTimeEventPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }
        //parse scoreOne and return it as list of integers
        List<Integer> scoreTwo = Collections.emptyList();
        for (String s : this.scoreTwo.split(",")) {
            scoreTwo.add(Integer.parseInt(s));
        }
        return scoreTwo;

    }

    public Court getCourt() {
        return court;
    }
}
