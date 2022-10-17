package fr.rolandgarros.model;

import java.sql.Date;

public class Player extends Person {

    private Integer ranking;

    private Integer bestRanking;

    private final String nationality;

    private Float height;

    private Float weight;

    private final Date startCareer;

    private final Hand hand;

    private final Person trainer;

    public Player(
            String lastname,
            String firstname,
            Date birthDate,
            String birthPlace,
            Integer ranking,
            Integer bestRanking,
            String nationality,
            Float height,
            Float weight,
            Date startCareer,
            Hand hand,
            Person trainer) {
        super(lastname, firstname, birthDate, birthPlace);
        this.ranking = ranking;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.startCareer = startCareer;
        this.hand = hand;
        this.trainer = trainer;
        this.bestRanking = bestRanking;
    }

    public Integer getRanking() {
        return ranking;
    }

    public String getNationality() {
        return nationality;
    }

    public Float getHeight() {
        return height;
    }

    public Float getWeight() {
        return weight;
    }

    public Date getStartCareer() {
        return startCareer;
    }

    public Hand getHand() {
        return hand;
    }

    public Person getTrainer() {
        return trainer;
    }

    public Integer getBestRanking() {
        return bestRanking;
    }

    public void setRanking(Integer newRanking) {
        this.ranking = newRanking;
        if (bestRanking < newRanking) {
            this.bestRanking = newRanking;
        }
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
