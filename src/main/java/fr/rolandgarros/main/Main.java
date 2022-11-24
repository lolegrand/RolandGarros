package fr.rolandgarros.main;


import fr.rolandgarros.model.*;
import fr.rolandgarros.services.*;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        PlayerService playerService = new PlayerService();
        PersonService personService = new PersonService();
        AccountService accountService = new AccountService();
        CourtService courtService = new CourtService();

        Date C1Birth = Date.valueOf("1970-01-01");
        Date C2Birth = Date.valueOf("1970-01-01");
        Date C3Birth = Date.valueOf("1970-01-01");
        Date P1Birth = Date.valueOf("2003-05-05");
        Date P2Birth = Date.valueOf("1986-06-03");
        Date P3Birth = Date.valueOf("1998-12-22");
        Date P4Birth = Date.valueOf("1996-02-11");

        Person P1Coach = new Person("FERRERO", "Juan Carlos", C1Birth,"France", Gender.MALE);
        Person P2Coach = new Person("MOYA", "Carlos", C2Birth,"Spain",Gender.MALE);
        Person P3Coach = new Person("RUUD", "Sarah", C3Birth,"Germany",Gender.FEMALE);
        Person P4Coach = new Person("MARTINEZ", "Claire", C3Birth,"Belgium",Gender.FEMALE);

        personService.createPerson(P1Coach);
        personService.createPerson(P2Coach);
        personService.createPerson(P3Coach);
        personService.createPerson(P4Coach);


        Player p1 = new Player("MARTINEZ", "Carlos", P1Birth, "ElPalmar, Murcia, Spain", 1, 1, "Spanish", 182f, 74f, Date.valueOf("2010-01-01"), Hand.RIGHT_HANDED,
                null,Gender.MALE);
        Player p2 = new Player("DELANO", "Rafael", P2Birth, "Manacor, Mallorca, Spain", 2, 1, "Spanish", 185f, 84f, Date.valueOf("2013-02-11"), Hand.LEFT_HANDED,
               null,Gender.MALE);
        Player p3 = new Player("POLANA", "Casper", P3Birth, "Oslo, Norway", 3, 2, "Norwegian", 182f, 77f, Date.valueOf("2015-02-11"), Hand.RIGHT_HANDED,
                null,Gender.MALE);
        Player p4 = new Player("KRANCHYIV", "Daniil", P4Birth, "Moscow, Russia", 4, 3, "Russian", 198f, 82f, Date.valueOf("2014-02-11"), Hand.RIGHT_HANDED,
                null,Gender.MALE);



        playerService.createPlayer(p1);
        playerService.createPlayer(p2);
        playerService.createPlayer(p3);
        playerService.createPlayer(p4);

        accountService.createAccount(new Account("admin","admin",Role.ADMINISTRATOR));
        accountService.createAccount(new Account("match","match",Role.MATCH_EDITOR));
        accountService.createAccount(new Account("player","player",Role.PLAYER_EDITOR));
        accountService.createAccount(new Account("trainer","trainer",Role.TRAINER));

        courtService.createCourt(new Court("Court 1"));
        courtService.createCourt(new Court("Court 2"));
        courtService.createCourt(new Court("Court 3"));
        courtService.createCourt(new Court("Court 4"));


    }



}
