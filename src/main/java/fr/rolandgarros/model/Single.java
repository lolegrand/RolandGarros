package fr.rolandgarros.model;


import java.sql.Date;

public class Single extends Match {

    private Player playerOne;

    private Player playerTwo;

    public Single(String genre, String type, Date startDate, Court court, Player playerOne, Player playerTwo) {
        super(genre, startDate, type, court);
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
