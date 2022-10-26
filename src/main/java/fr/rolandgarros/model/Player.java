package fr.rolandgarros.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "player")
public class Player extends Person {

    private Integer ranking;

    private Integer bestRanking;

    private  String nationality;

    private Float height;

    private Float weight;

    private  Date startCareer;
    @Enumerated(EnumType.STRING)
    private  Hand hand;

    @OneToOne
    @JoinColumn(name = "trainerId")
    private  Person trainer;


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

    public Player() {

    }









    public Integer getRanking() {
        return ranking;
    }
    public void setRanking(Integer newRanking) {
        this.ranking = newRanking;
        if (bestRanking < newRanking) {
            this.bestRanking = newRanking;
        }
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Float getHeight() {
        return height;
    }
    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Date getStartCareer() {
        return startCareer;
    }
    public void setStartCareer(Date startCareer) {
        this.startCareer = startCareer;
    }

    public Hand getHand() {
        return hand;
    }
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Person getTrainer() {
        return trainer;
    }
    public void setTrainer(Person trainer) {
        this.trainer = trainer;
    }

    public Integer getBestRanking() {
        return bestRanking;
    }


}
