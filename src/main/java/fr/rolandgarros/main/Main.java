package fr.rolandgarros.main;


import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.services.PersonService;
import fr.rolandgarros.services.PlayerService;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {




        //PersonService.createPerson(new Person("fefe", "trainer", Date.valueOf("2000-12-11"), "Alger",Gender.MALE));

        Person person = PersonService.getPersonByName("fefe", "trainer");

        //Player player1 = new Player("fefe", "trainer", Date.valueOf("1980-12-11"), "Tamanrasset", 1, 1, "Bangladech", 1.80f, 80f, Date.valueOf("2015-12-11"), Hand.RIGHT_HANDED, person, Gender.MALE);

        //PlayerService.createPlayer(player1);

        ArrayList<Player> players = PlayerService.getPlayersByTrainer(person);
        for (Person player : players) {
            System.out.println( "Player : Name :  " + player.getLastname()
                     + ", " + player.getFirstname() + "\n");
        }



    }
}
