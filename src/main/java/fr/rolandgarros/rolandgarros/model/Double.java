package fr.rolandgarros.rolandgarros.model;

import java.sql.Date;

public class Double extends Match {

    private Player teamOnePlayerOne;

    private Player teamOnePlayerTwo;

    private Player teamTwoPlayerOne;

    private Player teamTwoPlayerTwo;

    public Double(String genre,
                  Date startDate,
                  Player teamOnePlayerOne,
                  Player teamOnePlayerTwo,
                  Player teamTwoPlayerOne,
                  Player teamTwoPlayerTwo) {
        super(genre, startDate);
        this.teamOnePlayerOne = teamOnePlayerOne;
        this.teamOnePlayerTwo = teamOnePlayerTwo;
        this.teamTwoPlayerOne = teamTwoPlayerOne;
        this.teamTwoPlayerTwo = teamTwoPlayerTwo;
    }

    public Player getTeamOnePlayerOne() {
        return teamOnePlayerOne;
    }

    public Player getTeamOnePlayerTwo() {
        return teamOnePlayerTwo;
    }

    public Player getTeamTwoPlayerOne() {
        return teamTwoPlayerOne;
    }

    public Player getTeamTwoPlayerTwo() {
        return teamTwoPlayerTwo;
    }
}
