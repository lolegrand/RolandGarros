package fr.rolandgarros.rolandgarros.model;


import java.sql.Date;

public class Single extends Match {

    private Player playerOne;

    private Player playerTwo;

    public Single(String genre, Date startDate, Courses courses, Player playerOne, Player playerTwo) {
        super(genre, startDate, courses);
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }
}
