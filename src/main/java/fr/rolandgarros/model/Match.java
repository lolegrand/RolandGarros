package fr.rolandgarros.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Match extends TimeEvent {

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private  Gender gender;

    @Column(name = "scoreOne")
    private String scoreOne;

    @Column(name = "scoreTwo")
    private String scoreTwo;

    @OneToOne (
            targetEntity = Court.class,
            cascade = {CascadeType.REMOVE}
    )
    @JoinColumn(name = "courtId")
    private  Court court;

    public Match(Gender gender, Timestamp startDate, Court court) {
        super(startDate);
        this.gender = gender;
        this.court = court;
    }

    public Match() {
    }

    public void endMatch(Timestamp endDate, List<Integer> scoreOne, List<Integer> scoreTwo) {
        super.endTimeEvent(endDate);
        this.setScoreOne(scoreOne);
        this.setScoreTwo(scoreTwo);
    }

    public Gender getGender() {
        return gender;
    }

    public List<Integer> getScoreOne() {
        if (!isTimeEventPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }

        ArrayList<Integer> scoreOne = new ArrayList<>();
        for (String s : this.scoreOne.replace("[","").replace("]","").split(",")) {
            scoreOne.add(Integer.parseInt(s));
        }
        return scoreOne;
    }
    public void setScoreOne(List<Integer> scoreOne) {
        this.scoreOne = scoreOne.toString();
    }

    public List<Integer> getScoreTwo() {
        if (!isTimeEventPassed()) {
            throw new RuntimeException("Match has not been passed yet");
        }
        ArrayList<Integer> scoreTwo = new ArrayList<>();
        for (String s : this.scoreTwo.replace("[","").replace("]","").split(",")) {
            scoreTwo.add(Integer.parseInt(s));
        }
        return scoreTwo;
    }
    public void setScoreTwo(List<Integer> scoreTwo) {
        this.scoreTwo = scoreTwo.toString();
    }

    public Court getCourt() {
        return court;
    }
}
