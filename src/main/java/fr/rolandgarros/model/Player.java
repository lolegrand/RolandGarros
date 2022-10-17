package fr.rolandgarros.model;

import java.sql.Date;

public class Player extends Person {

    private Integer ranking;

    private String nationality;

    private Float height;

    private Float weight;

    private Date startCareer;

    private Hand hand;

    private Person trainer;

    public Player(
            String lastname,
            String firstname,
            Date birthDate,
            String birthPlace,
            Integer ranking,
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
}
