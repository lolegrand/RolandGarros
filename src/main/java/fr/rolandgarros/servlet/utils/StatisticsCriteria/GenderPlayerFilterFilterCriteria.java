package fr.rolandgarros.servlet.utils.StatisticsCriteria;

import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GenderPlayerFilterFilterCriteria implements StatisticsFilterCriteria {

    private Gender gender;

    public GenderPlayerFilterFilterCriteria(Gender gender) {
        this.gender = gender;
    }

    @Override
    public List<Player> filterPlayer(List<Player> players) {
        List<Player> output = new ArrayList<>();
        for (Player player: players) {
            if (player.getGender() == gender) {
                output.add(player);
            }
        }
        return output;
    }
}
