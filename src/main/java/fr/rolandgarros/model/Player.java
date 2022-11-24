package fr.rolandgarros.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Locale;

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
    private Date startCareer;

    @Column(name = "hand", nullable = false)
    @Enumerated(EnumType.STRING)
    private  Hand hand;

    @OneToOne (
            targetEntity = Person.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE}
    )
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
            Person trainer,
            Gender gender) {
        super(lastname, firstname, birthDate, birthPlace,gender);
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

    @Override
    public String toString() {
        return this.getFirstname() + " " + this.getLastname().toUpperCase(Locale.FRANCE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return this.getId().equals(player.getId());
    }
}
