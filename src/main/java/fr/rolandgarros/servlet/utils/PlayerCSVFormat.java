package fr.rolandgarros.servlet.utils;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.services.PersonService;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PlayerCSVFormat {
    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private static PersonService personService = new PersonService();

    public static Player convertCSVStringToPlayer(String str) throws ParseException {
        String[] playerPart = str.split(",");
        String firstName = playerPart[0];
        String lastName = playerPart[1];
        Date birthDate = new Date(dateFormat.parse(playerPart[2]).getTime());
        String birthPlace = playerPart[3];
        int ranking = Integer.parseInt(playerPart[4]);
        int bestRanking = Integer.parseInt(playerPart[5]);
        String nationality = playerPart[6];
        float height = Float.parseFloat(playerPart[7]);
        float weight = Float.parseFloat(playerPart[8]);
        int startCareer = Integer.parseInt(playerPart[9]);
        String handStr = playerPart[10];
        Hand hand;
        if (handStr.equals("Left")) {
            hand = Hand.LEFT_HANDED;
        } else if (handStr.equals("Right")) {
            hand = Hand.RIGHT_HANDED;
        } else {
            hand = Hand.AMBIDEXTROUS;
        }
        int trainerId = Integer.parseInt(playerPart[11]);
        Person trainer = personService.getPersonById(trainerId);

        String genderStr = playerPart[12];
        Gender gender;
        if (genderStr.equals("Male")) {
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }

        return new Player(
                lastName,
                firstName,
                birthDate,
                birthPlace,
                ranking,
                bestRanking,
                nationality,
                height,
                weight,
                startCareer,
                hand,
                trainer,
                gender
        );
    }

}
