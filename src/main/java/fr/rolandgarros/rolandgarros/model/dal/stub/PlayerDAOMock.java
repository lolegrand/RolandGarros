package fr.rolandgarros.rolandgarros.model.dal.stub;

import fr.rolandgarros.rolandgarros.model.Hand;
import fr.rolandgarros.rolandgarros.model.Person;
import fr.rolandgarros.rolandgarros.model.Player;
import fr.rolandgarros.rolandgarros.model.dal.PlayerDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOMock implements PlayerDAO {

    private final List<Player> players = new ArrayList<Player>()
    {{
        try {
            add(p1);
            add(p2);
            add(p3);
            add(p4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }};

    Date C1Birth = Date.valueOf("1970-01-01");
    Date C2Birth = Date.valueOf("1970-01-01");
    Date C3Birth = Date.valueOf("1970-01-01");
    Date C4Birth = Date.valueOf("1970-01-01");
    Date P1Birth = Date.valueOf("2003-05-05");
    Date P2Birth = Date.valueOf("1986-06-03");
    Date P3Birth = Date.valueOf("1998-12-22");
    Date P4Birth = Date.valueOf("1996-02-11");

    Person P1Coach = new Person("FERRERO", "Juan Carlos", C1Birth,"BOUYAH");
    Person P2Coach = new Person("MOYA", "Carlos", C2Birth,"BOUYAH");
    Person P3Coach = new Person("RUUD", "Christian", C3Birth,"BOUYAH");
    Person P4Coach = new Person("CERVARA", "Gilles", C4Birth,"BOUYAH");

    Player p1 = new Player("ALCARNAZ", "Carlos", "Male", P1Birth, "ElPalmar, Murcia, Spain", 1, 1, "Spanish", 182f, 74f, 2018, Hand.RIGHT_HANDED, P1Coach);
    Player p2 = new Player("NADAL", "Rafael", "Male", P2Birth, "Manacor, Mallorca, Spain", 2, 1, "Spanish", 185f, 84f, 2001, Hand.LEFT_HANDED, P2Coach);
    Player p3 = new Player("RUUD", "Casper", "Male", P3Birth, "Oslo, Norway", 3, 2, "Norwegian", 182f, 77f, 2015, Hand.RIGHT_HANDED, P3Coach);
    Player p4 = new Player("MEDVEDEV", "Daniil", "Male", P4Birth, "Moscow, Russia", 4, 3, "Russian", 198f, 82f, 2014, Hand.RIGHT_HANDED, P4Coach);


    @Override
    public void createPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public void deletePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void modifyPlayer(Player player) {
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
    public ArrayList<Player> getPlayerByGender(String gender) {

        ArrayList<Player> players = new ArrayList<>();

        for (Player player : players) {
            if (player.getGender().equals(gender)) {
                players.add(player);
            }
        }

        return players;
    }

    @Override
    public ArrayList<Player> getPlayerByRank(Integer rank) {

        ArrayList<Player> players = new ArrayList<>();

        for (Player player : players) {
            if (player.getRanking().equals(rank)) {
                players.add(player);
            }
        }

        return players;
    }

    @Override
    public ArrayList<Player> getPlayerByNationality(String nationality) {

        ArrayList<Player> players = new ArrayList<>();

        for (Player player : players) {
            if (player.getNationality().equals(nationality)) {
                players.add(player);
            }
        }

        return players;
    }

    @Override
    public ArrayList<Player> getPlayerByHeight(Float height) {

        ArrayList<Player> players = new ArrayList<>();

        for (Player player : players) {
            if (player.getHeight().equals(height)) {
                players.add(player);
            }
        }

        return players;
    }

    @Override
    public ArrayList<Player> getPlayerByWeight(Float weight) {

        ArrayList<Player> players = new ArrayList<>();

        for (Player player : players) {
            if (player.getWeight().equals(weight)) {
                players.add(player);
            }
        }

        return players;
    }

    @Override
    public ArrayList<Player> getPlayerByStartCareer(Integer startCareer) {

        ArrayList<Player> players = new ArrayList<>();

        for (Player player : players) {
            if (player.getStartCareer().equals(startCareer)) {
                players.add(player);
            }
        }

        return players;
    }

    @Override
    public ArrayList<Player> getPlayerByHand(Hand hand) {

        ArrayList<Player> players = new ArrayList<>();

        for (Player player : players) {
            if (player.getHand().equals(hand)) {
                players.add(player);
            }
        }

        return players;
    }

    @Override
    public ArrayList<Player> getPlayerByTrainer(Person trainer) {

        ArrayList<Player> players = new ArrayList<>();

        for (Player player : players) {
            if (player.getTrainer().equals(trainer)) {
                players.add(player);
            }
        }

        return players;
    }
}
