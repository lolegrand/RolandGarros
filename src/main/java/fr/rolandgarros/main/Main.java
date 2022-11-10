package fr.rolandgarros.main;


import fr.rolandgarros.di.JPAService;
import fr.rolandgarros.model.*;
import fr.rolandgarros.services.PersonService;
import fr.rolandgarros.services.PlayerService;
import fr.rolandgarros.services.AccountService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final JPAService jpaService = JPAService.getInstance();

    public static void main(String[] args) {
        /*
        PlayerService playerService = new PlayerService();
        PersonService personService = new PersonService();
        AccountService accountService = new AccountService();
//        Date C1Birth = Date.valueOf("1970-01-01");
//        Date C2Birth = Date.valueOf("1970-01-01");
//        Date C3Birth = Date.valueOf("1970-01-01");
//        Date C4Birth = Date.valueOf("1970-01-01");
//        Date P1Birth = Date.valueOf("2003-05-05");
//        Date P2Birth = Date.valueOf("1986-06-03");
//        Date P3Birth = Date.valueOf("1998-12-22");
//        Date P4Birth = Date.valueOf("1996-02-11");
//
//        Person P1Coach = new Person("FERRERO", "Juan Carlos", C1Birth,"BOUYAH", Gender.MALE);
//        Person P2Coach = new Person("MOYA", "Carlos", C2Birth,"BOUYAH",Gender.MALE);
//        Person P3Coach = new Person("RUUD", "Christian", C3Birth,"BOUYAH",Gender.MALE);
//        Person P4Coach = new Person("CERVARA", "Gilles", C4Birth,"BOUYAH",Gender.MALE);
//
//        Player p1 = new Player("ALCARNAZ", "Carlos", P1Birth, "ElPalmar, Murcia, Spain", 1, 1, "Spanish", 182f, 74f, Date.valueOf("2010-01-01"), Hand.RIGHT_HANDED, P1Coach,Gender.MALE);
//        Player p2 = new Player("NADAL", "Rafael", P2Birth, "Manacor, Mallorca, Spain", 2, 1, "Spanish", 185f, 84f, Date.valueOf("2013-02-11"), Hand.LEFT_HANDED, P2Coach,Gender.MALE);
//        Player p3 = new Player("RUUD", "Casper", P3Birth, "Oslo, Norway", 3, 2, "Norwegian", 182f, 77f, Date.valueOf("2015-02-11"), Hand.RIGHT_HANDED, P3Coach,Gender.MALE);
//        Player p4 = new Player("MEDVEDEV", "Daniil", P4Birth, "Moscow, Russia", 4, 3, "Russian", 198f, 82f, Date.valueOf("2014-02-11"), Hand.RIGHT_HANDED, P4Coach,Gender.MALE);

//        personService.createPerson(P1Coach);
//        personService.createPerson(P2Coach);
//        personService.createPerson(P3Coach);
//        personService.createPerson(P4Coach);

//        playerService.createPlayer(p1);
//        playerService.createPlayer(p2);
//        playerService.createPlayer(p3);
//        playerService.createPlayer(p4);
//        accountService.createAccount(new Account("fefe","fefe",Role.ADMINISTRATOR));

//        List<Player> players = playerService.getAllPlayers();
//        for (Person player : players) {
//            System.out.println( "Player : Name :  " + player.getLastname()
//                     + ", " + player.getFirstname() + "\n");
//        }
*/
        PlayerService playerService = new PlayerService();
        playerService.getAllPlayers().forEach(System.out::println);

    }

    private static void createTest() {
        Date C1Birth = Date.valueOf("1970-01-01");
        Date P1Birth = Date.valueOf("2003-05-05");


        Person P1Coach = new Person("test", "Traner", C1Birth,"BOUYAH", Gender.MALE);

        Player p1 = new Player("Ferhat", "sn", P1Birth, "ElPalmar, Murcia, Spain", 1, 1, "Spanish", 182f, 74f, Date.valueOf("2010-01-01"), Hand.RIGHT_HANDED, P1Coach,Gender.MALE);

        jpaService.runInTransaction(entityManager -> {
            entityManager.persist(p1);
            return null;
        });
    }
    private static void printPlayers() {

        jpaService.runInTransaction(entityManager -> {
            entityManager.createQuery("FROM Player", Player.class)
                    .getResultList()
                    .forEach(System.out::println);
            return null;
        });
    }
}
