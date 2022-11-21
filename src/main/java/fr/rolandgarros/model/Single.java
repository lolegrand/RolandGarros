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

    public Single(Gender gender, Timestamp startDate, Court court, Player playerOne, Player playerTwo) {
        super(gender, startDate, court);
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

}