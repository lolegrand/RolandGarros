package fr.rolandgarros.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "singleGame")
public class Single extends Match {

    @OneToOne (
            targetEntity = Player.class
    )
    @JoinColumn(name = "playerOneId")
    private Player playerOne;

    @OneToOne (
            targetEntity = Player.class
    )
    @JoinColumn(name = "playerTwoId")
    private Player playerTwo;

    public Single( Timestamp startDate,Gender gender, Court court, Player playerOne, Player playerTwo) {
        //if the two players are'nt the same we create the match
        super(gender, startDate, court);

        if (playerOne == playerTwo || playerOne == null || playerTwo == null) {
            throw new IllegalArgumentException("The two players can't be the same");
        }

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Single() {}

    public Player getPlayerOne() {
        return playerOne;
    }
    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }
    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Player getWinner() {
        int scoreOne;
        int scoreTwo;
        try {
            scoreOne = getScoreOne().stream().mapToInt(Integer::intValue).sum();
            scoreTwo = getScoreTwo().stream().mapToInt(Integer::intValue).sum();
        } catch (RuntimeException exception) {
            return null;
        }

        if (scoreOne > scoreTwo) {
            return playerOne;
        }

        if (scoreOne < scoreTwo) {
            return playerTwo;
        }

        return null;
    }

}