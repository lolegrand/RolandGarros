package fr.rolandgarros.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "singleGame")
public class Single extends Match {

    @OneToOne
    @JoinColumn(name = "playerOneId")
    private Player playerOne;

    @OneToOne
    @JoinColumn(name = "playerTwoId")
    private Player playerTwo;

    public Single(String genre, String type, Date startDate, Court court, Player playerOne, Player playerTwo) {
        super(genre, startDate, type, court);
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