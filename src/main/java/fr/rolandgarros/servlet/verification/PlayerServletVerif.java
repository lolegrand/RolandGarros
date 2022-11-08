package fr.rolandgarros.servlet.verification;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Hand;
import fr.rolandgarros.model.Person;

import java.sql.Date;

public class PlayerServletVerif {

    // Check functions to submit forms

    public static boolean checkGender( String gender ) {
        return gender.equals(Gender.MALE) || gender.equals(Gender.FEMALE);
    }

    public static boolean checkBirthDate( Date birthdate ) {
        Date fifteenYearsAgo = new Date((System.currentTimeMillis()/1000/3600/24/365) - 15);
        return !birthdate.before(fifteenYearsAgo);
    }

    public static boolean checkBirthPlace( String birthplace ) {
        return !birthplace.isEmpty();
    }

    public static boolean checkRanking( Integer ranking ) {
        return ranking.compareTo(0) != -1 && ranking.compareTo(0) != 0;
    }

    public static boolean checkBestRanking( Integer bestRanking ) {
        return bestRanking.compareTo(0) != -1 && bestRanking.compareTo(0) != 0;
    }

    public static boolean checkNationality( String nationality ) {
        return !nationality.isEmpty();
    }

    public static boolean checkHeight( Float height ) {
        return height.compareTo(150f) != -1 && height.compareTo(150f) != 0 ;
    }

    public static boolean checkWeight( Float weight ) {
        return weight.compareTo(40f) != -1 && weight.compareTo(40f) != 0 ;
    }

    public static boolean checkStartCareer( Integer startCareer ) {
        int currentYear = 2022;
        return startCareer.compareTo(currentYear+1) != 0
                && startCareer.compareTo(currentYear+1) != 1;
    }

    public static boolean checkHand( Hand hand ) {
        return hand.equals(Hand.LEFT_HANDED)
                || hand.equals(Hand.RIGHT_HANDED)
                || hand.equals(Hand.AMBIDEXTROUS);
    }

    public static boolean checkTrainer( Person trainer ) {
        return trainer != null;
    }

}
