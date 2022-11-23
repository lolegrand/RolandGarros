package fr.rolandgarros.main;


import fr.rolandgarros.model.*;
import fr.rolandgarros.services.*;

public class Main {

    public static void main(String[] args) {

//        PlayerService playerService = new PlayerService();
//        PersonService personService = new PersonService();
//        MatchService matchService = new MatchService();
//        AccountService accountService = new AccountService();
        CourtService courtService = new CourtService();

//        Date C1Birth = Date.valueOf("1970-01-01");
//        Date C2Birth = Date.valueOf("1970-01-01");
//        Date C3Birth = Date.valueOf("1970-01-01");
//        Date P1Birth = Date.valueOf("2003-05-05");
//        Date P2Birth = Date.valueOf("1986-06-03");
//        Date P3Birth = Date.valueOf("1998-12-22");
//        Date P4Birth = Date.valueOf("1996-02-11");
//
//        Person P1Coach = new Person("FERRERO", "Juan Carlos", C1Birth,"BOUYAH", Gender.MALE);
//        Person P2Coach = new Person("MOYA", "Carlos", C2Birth,"BOUYAH",Gender.MALE);
//        Person P3Coach = new Person("RUUD", "Christian", C3Birth,"BOUYAH",Gender.MALE);
//        Person P4Coach = new Person("MARTINEZ", "David", C3Birth,"BOUYAH",Gender.MALE);
//
//        personService.createPerson(P1Coach);
//        personService.createPerson(P2Coach);
//        personService.createPerson(P3Coach);
//        personService.createPerson(P4Coach);
//
//
//        Player p1 = new Player("j1", "Carlos", P1Birth, "ElPalmar, Murcia, Spain", 1, 1, "Spanish", 182f, 74f, Date.valueOf("2010-01-01"), Hand.RIGHT_HANDED,
//                null,Gender.MALE);
//        Player p2 = new Player("j2", "Rafael", P2Birth, "Manacor, Mallorca, Spain", 2, 1, "Spanish", 185f, 84f, Date.valueOf("2013-02-11"), Hand.LEFT_HANDED,
//               null,Gender.MALE);
//        Player p3 = new Player("j3", "Casper", P3Birth, "Oslo, Norway", 3, 2, "Norwegian", 182f, 77f, Date.valueOf("2015-02-11"), Hand.RIGHT_HANDED,
//                null,Gender.MALE);
//        Player p4 = new Player("j4", "Daniil", P4Birth, "Moscow, Russia", 4, 3, "Russian", 198f, 82f, Date.valueOf("2014-02-11"), Hand.RIGHT_HANDED,
//                null,Gender.MALE);
//
//
//
//        playerService.createPlayer(p1);
//        playerService.createPlayer(p2);
//        playerService.createPlayer(p3);
//        playerService.createPlayer(p4);
//
//        accountService.createAccount(new Account("fefe","fefe",Role.ADMINISTRATOR));
//
//        courtService.createCourt(new Court("C1"));
//        courtService.createCourt(new Court("C2"));
//        courtService.createCourt(new Court("C3"));
//        courtService.createCourt(new Court("C4"));
//
//       Single ms = new Single(Gender.FEMALE, Timestamp.valueOf("2019-05-16 10:00:00"),courtService.getCourtById(1),playerService.getPlayerByName("j1","Carlos"),playerService.getPlayerByName("j2","Rafael"));
//       matchService.createMatch(ms);
//       Double md = new Double(Gender.MALE, Timestamp.valueOf("2017-05-16 10:00:00"),courtService.getCourtById(1),
//               playerService.getPlayerByName("j1","Carlos"),playerService.getPlayerByName("j2","Rafael"),
//               playerService.getPlayerByName("j3","Casper"),playerService.getPlayerByName("j4","Daniil"));
//       matchService.createMatch(md);
//        Match match = matchService.getMatch(courtService.getCourtById(1),Timestamp.valueOf("2016-05-16 10:00:00"));
//        List<Match> matchs = matchService.getAllMatches();
//        match.setEndDate(Timestamp.valueOf("2016-05-16 11:00:00"));
//        matchService.modifyMatch(match);
//        List<Player> players = playerService.getPlayersByGender(Gender.FEMALE);

//       matchService.deleteMatch(match);
//       playerService.getAllPlayers().forEach(System.out::println);
//       playerService.getPlayersByTrainer(personService.getPersonByName("FERRERO","Juan Carlos")).forEach(System.out::println);

//        Court c = courtService.getCourtById(1);
//        Court c1 =courtService.getCourtById(2);
//        courtService.getAllCourt().forEach(System.out::println);
    }



}
