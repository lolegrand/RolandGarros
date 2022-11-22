package fr.rolandgarros.model.dal.stub;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.dal.PlayerDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOMock implements PlayerDAO {

    private final List<Player> players = new ArrayList<>();

    Date C1Birth = Date.valueOf("1970-01-01");
    Date C2Birth = Date.valueOf("1970-01-01");
    Date C3Birth = Date.valueOf("1970-01-01");
    Date C4Birth = Date.valueOf("1970-01-01");
    Date P1Birth = Date.valueOf("2003-05-05");
    Date P2Birth = Date.valueOf("1986-06-03");
    Date P3Birth = Date.valueOf("1998-12-22");
    Date P4Birth = Date.valueOf("1996-02-11");

    Person P1Coach = new Person("FERRERO", "Juan Carlos", C1Birth,"BOUYAH", Gender.MALE);
    Person P2Coach = new Person("MOYA", "Carlos", C2Birth,"BOUYAH", Gender.FEMALE);
    Person P3Coach = new Person("RUUD", "Christian", C3Birth,"BOUYAH", Gender.MALE);
    Person P4Coach = new Person("CERVARA", "Gilles", C4Birth,"BOUYAH", Gender.FEMALE);

    Player p1 = new Player(
            "ALCARNAZ",
            "Carlos",
            P1Birth,
            "ElPalmar, Murcia, Spain",
            1,
            1,
            "Spanish",
            182f,
            74f,
            Date.valueOf("2018-01-01"),
            Hand.RIGHT_HANDED,
            P1Coach,
            Gender.MALE
            );
    Player p2 = new Player(
            "NADAL",
            "Rafael",

            P2Birth,
            "Manacor, Mallorca, Spain",
            2,
            1,
            "Spanish",
            185f,
            84f,
            Date.valueOf("2001-01-01"),
            Hand.LEFT_HANDED,
            P2Coach,
            Gender.MALE
            );
    Player p3 = new Player(
            "RUUD",
            "Casper",
            P3Birth,
            "Oslo, Norway",
            3,
            2,
            "Norwegian",
            182f,
            77f,
            Date.valueOf("2015-01-01"),
            Hand.RIGHT_HANDED,
            P3Coach,
            Gender.MALE
    );
    Player p4 = new Player(
            "MEDVEDEV",
            "Daniil",
            P4Birth,
            "Moscow, Russia",
            4,
            3,
            "Russian",
            198f,
            82f,
            Date.valueOf("2014-01-01"),
            Hand.RIGHT_HANDED,
            P4Coach,
            Gender.MALE
    );

    public PlayerDAOMock() {
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
    }

    @Override
    public void createPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public void deletePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void updatePlayer(Player player) {
        this.players.remove(player);
        this.players.add(player);
    }

    @Override
    public Player getPlayerByName(String firstName, String lastName) {
        for (Player player : players) {
            if (player.getFirstname().equals(firstName) && player.getLastname().equals(lastName)) {
                return player;
            }
        }
        return null;

    }

    @Override
    public Player getPlayerById(int id) {
        return null;
    }

    @Override
    public ArrayList<Player> getPlayerByGender(Gender gender) {

        ArrayList<Player> playersRet = new ArrayList<>();

        for (Player player : players) {
            if (player.getGender().equals(gender)) {
                playersRet.add(player);
            }
        }

        return playersRet;
    }

    @Override
    public ArrayList<Player> getPlayerByRank(Integer rank) {

        ArrayList<Player> playersRet = new ArrayList<>();

        for (Player player : players) {
            if (player.getRanking().equals(rank)) {
                playersRet.add(player);
            }
        }

        return playersRet;
    }

    @Override
    public ArrayList<Player> getPlayerByNationality(String nationality) {

        ArrayList<Player> playersRet = new ArrayList<>();

        for (Player player : players) {
            if (player.getNationality().equals(nationality)) {
                playersRet.add(player);
            }
        }

        return playersRet;
    }

    @Override
    public ArrayList<Player> getPlayerByHeight(Float height) {

        ArrayList<Player> playersRet = new ArrayList<>();

        for (Player player : players) {
            if (player.getHeight().equals(height)) {
                playersRet.add(player);
            }
        }

        return playersRet;
    }

    @Override
    public ArrayList<Player> getPlayerByWeight(Float weight) {

        ArrayList<Player> playersRet = new ArrayList<>();

        for (Player player : players) {
            if (player.getWeight().equals(weight)) {
                playersRet.add(player);
            }
        }

        return playersRet;
    }

    @Override
    public ArrayList<Player> getPlayerByStartCareer(Date startCareer) {

        ArrayList<Player> playersRet = new ArrayList<>();

        for (Player player : players) {
            if (player.getStartCareer().equals(startCareer)) {
                playersRet.add(player);
            }
        }

        return playersRet;
    }

    @Override
    public ArrayList<Player> getPlayerByHand(Hand hand) {

        ArrayList<Player> playersRet = new ArrayList<>();

        for (Player player : players) {
            if (player.getHand().equals(hand)) {
                playersRet.add(player);
            }
        }

        return playersRet;
    }

    @Override
    public ArrayList<Player> getPlayerByTrainer(Person trainer) {

        ArrayList<Player> playersRet = new ArrayList<>();

        for (Player player : players) {
            if (player.getTrainer().equals(trainer)) {
                playersRet.add(player);
            }
        }

        return playersRet;
    }

    @Override
    public List<Player> getAllPlayer() {
        return players;
    }
}
