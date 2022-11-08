package fr.rolandgarros.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "doubleGame")
public class Double extends Match {


    @OneToOne (targetEntity = Player.class,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    @JoinColumn(name = "teamOnePlayerOneId")
    private  Player teamOnePlayerOne;

    @OneToOne (targetEntity = Player.class,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    @JoinColumn(name = "teamOnePlayerTwoId")
    private  Player teamOnePlayerTwo;

    @OneToOne (targetEntity = Player.class,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    @JoinColumn(name = "teamTwoPlayerOneId")
    private  Player teamTwoPlayerOne;

    @OneToOne (targetEntity = Player.class,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    @JoinColumn(name = "teamTwoPlayerTwoId")
    private  Player teamTwoPlayerTwo;


    public Double(Gender gender,
                  Timestamp startDate,
                  Court court,
                  Player teamOnePlayerOne,
                  Player teamOnePlayerTwo,
                  Player teamTwoPlayerOne,
                  Player teamTwoPlayerTwo
    ) {
        super(gender, startDate, court);
        this.teamOnePlayerOne = teamOnePlayerOne;
        this.teamOnePlayerTwo = teamOnePlayerTwo;
        this.teamTwoPlayerOne = teamTwoPlayerOne;
        this.teamTwoPlayerTwo = teamTwoPlayerTwo;
    }

    public Double() {}

    public Player getTeamOnePlayerOne() {
        return teamOnePlayerOne;
    }
    public void setTeamOnePlayerOne(Player teamOnePlayerOne) {
        this.teamOnePlayerOne = teamOnePlayerOne;
    }
    public Player getTeamOnePlayerTwo() {
        return teamOnePlayerTwo;
    }
    public void setTeamOnePlayerTwo(Player teamOnePlayerTwo) {
        this.teamOnePlayerTwo = teamOnePlayerTwo;
    }
    public Player getTeamTwoPlayerOne() {
        return teamTwoPlayerOne;
    }
    public void setTeamTwoPlayerOne(Player teamTwoPlayerOne) {
        this.teamTwoPlayerOne = teamTwoPlayerOne;
    }
    public Player getTeamTwoPlayerTwo() {
        return teamTwoPlayerTwo;
    }
    public void setTeamTwoPlayerTwo(Player teamTwoPlayerTwo) {
        this.teamTwoPlayerTwo = teamTwoPlayerTwo;
    }
}
