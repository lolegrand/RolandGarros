package fr.rolandgarros.model;

import fr.rolandgarros.services.PersonService;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "player")
public class Player extends Person {
    @Column(name = "ranking", nullable = false)
    private Integer ranking;

    @Column(name = "bestRanking", nullable = false)
    private Integer bestRanking;

    @Column(name = "nationality", nullable = false)
    private  String nationality;

    @Column(name = "height", nullable = false)
    private Float height;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Column(name = "startCareer", nullable = false)
    private Integer startCareer;

    @Column(name = "hand", nullable = false)
    @Enumerated(EnumType.STRING)
    private  Hand hand;

    // @OneToOne
    @JoinColumn(name = "trainerId")
    // private  Person trainer;
    private Integer trainerId;

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
            Integer startCareer,
            Hand hand,
            // Person trainer,
            Integer trainerId,
            Gender gender) {
        super(lastname, firstname, birthDate, birthPlace,gender);
        this.ranking = ranking;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.startCareer = startCareer;
        this.hand = hand;
        // this.trainer = trainer;
        this.trainerId = trainerId;
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

    public Integer getStartCareer() {
        return startCareer;
    }
    public void setStartCareer(Integer startCareer) {
        this.startCareer = startCareer;
    }

    public Hand getHand() {
        return hand;
    }
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Person getTrainer() {
        PersonService personService = new PersonService();
        Person trainer = personService.getById(this.trainerId);
        return trainer;
    }
    /*

    public void setTrainer(Person trainer) {
        this.trainer = trainer;
    }

     */

    public Integer getBestRanking() {
        return bestRanking;
    }


}
