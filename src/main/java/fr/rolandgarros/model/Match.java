package fr.rolandgarros.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Match extends TimeEvent {

    @Column(name = "gender", nullable = false)
    private  Gender gender;

    @Column(name = "scoreOne")
    private String scoreOne;

    @Column(name = "scoreTwo")
    private String scoreTwo;

    @OneToOne
    @JoinColumn(name = "courtId")
    private  Court court;

    public Match(Gender gender, Timestamp startDate, Court court) {
        super(startDate);
        this.gender = gender;
        this.court = court;
    }

    public Match() {

    }

    public void endMatch(Timestamp endDate, String scoreOne, String scoreTwo) {
        super.endTimeEvent(endDate);
        this.scoreOne = scoreOne;
        this.scoreTwo = scoreTwo;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Integer> getScoreOne() {
        if (!isTimeEventPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }
        //parse scoreOne AND return it as list of integers
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
        //parse scoreOne AND return it as list of integers
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
