package fr.rolandgarros.rolandgarros.model;

import java.sql.Date;

public class Double extends Match {

    private final Player teamOnePlayerOne;

    private final Player teamOnePlayerTwo;

    private final Player teamTwoPlayerOne;

    private final Player teamTwoPlayerTwo;

    public Double(String genre,
                  Date startDate,
                  Court court,
                  Player teamOnePlayerOne,
                  Player teamOnePlayerTwo,
                  Player teamTwoPlayerOne,
                  Player teamTwoPlayerTwo
    ) {
        super(genre, startDate, court);
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
