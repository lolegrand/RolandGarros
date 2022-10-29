package fr.rolandgarros.main;


import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.services.PersonService;
import fr.rolandgarros.services.PlayerService;

import java.sql.Date;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {


        Date C1Birth = Date.valueOf("1970-01-01");
        Date C2Birth = Date.valueOf("1970-01-01");
        Date C3Birth = Date.valueOf("1970-01-01");
        Date C4Birth = Date.valueOf("1970-01-01");
        Date P1Birth = Date.valueOf("2003-05-05");
        Date P2Birth = Date.valueOf("1986-06-03");
        Date P3Birth = Date.valueOf("1998-12-22");
        Date P4Birth = Date.valueOf("1996-02-11");

        Person P1Coach = new Person("FERRERO", "Juan Carlos", C1Birth,"BOUYAH", Gender.MALE);
        Person P2Coach = new Person("MOYA", "Carlos", C2Birth,"BOUYAH",Gender.MALE);
        Person P3Coach = new Person("RUUD", "Christian", C3Birth,"BOUYAH",Gender.MALE);
        Person P4Coach = new Person("CERVARA", "Gilles", C4Birth,"BOUYAH",Gender.MALE);

        Player p1 = new Player("ALCARNAZ", "Carlos", P1Birth, "ElPalmar, Murcia, Spain", 1, 1, "Spanish", 182f, 74f, Date.valueOf("2010-01-01"), Hand.RIGHT_HANDED, P1Coach,Gender.MALE);
        Player p2 = new Player("NADAL", "Rafael", P2Birth, "Manacor, Mallorca, Spain", 2, 1, "Spanish", 185f, 84f, Date.valueOf("2013-02-11"), Hand.LEFT_HANDED, P2Coach,Gender.MALE);
        Player p3 = new Player("RUUD", "Casper", P3Birth, "Oslo, Norway", 3, 2, "Norwegian", 182f, 77f, Date.valueOf("2015-02-11"), Hand.RIGHT_HANDED, P3Coach,Gender.MALE);
        Player p4 = new Player("MEDVEDEV", "Daniil", P4Birth, "Moscow, Russia", 4, 3, "Russian", 198f, 82f, Date.valueOf("2014-02-11"), Hand.RIGHT_HANDED, P4Coach,Gender.MALE);

        PersonService.createPerson(P1Coach);
        PersonService.createPerson(P2Coach);
        PersonService.createPerson(P3Coach);
        PersonService.createPerson(P4Coach);

        PlayerService.createPlayer(p1);
        PlayerService.createPlayer(p2);
        PlayerService.createPlayer(p3);
        PlayerService.createPlayer(p4);


        ArrayList<Person> players = PersonService.getAllTrainers();
        for (Person player : players) {
            System.out.println( "Player : Name :  " + player.getLastname()
                     + ", " + player.getFirstname() + "\n");
        }



    }
}
