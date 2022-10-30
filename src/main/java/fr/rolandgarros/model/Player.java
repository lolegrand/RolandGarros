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
    private Integer startCareer;

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
            Integer startCareer,
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
    public boolean equals(Object obj) {
        if (obj == null || this == null) {
            return false;
        }
        if (obj instanceof Person) {
            Player p = (Player) obj;
            return this.getLastname().equals(p.getLastname()) && this.getFirstname().equals(p.getFirstname()) && this.getBirthDate().equals(p.getBirthDate()) && this.getBirthPlace().equals(p.getBirthPlace()) && this.getGender().equals(p.getGender()) && this.getNationality().equals(p.getNationality()) && this.getRanking().equals(p.getRanking()) && this.getTrainer().equals(p.getTrainer()) && this.getHand().equals(p.getHand()) && this.getHeight().equals(p.getHeight()) && this.getWeight().equals(p.getWeight()) && this.getStartCareer().equals(p.getStartCareer());

        }

        return false;
    }

}
