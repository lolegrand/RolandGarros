package fr.rolandgarros.servlet.utils.StatisticsCriteria;

import fr.rolandgarros.model.Double;
import fr.rolandgarros.model.Match;
import fr.rolandgarros.model.Player;
import fr.rolandgarros.model.Single;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NumberOfVictorySortPlayer implements StatisticsSortCriteria{
    @Override
    public List<Entry<Player, Float>> sortPlayer(List<Player> players, List<Match> matches) {
        Map<Player, Float> out = new HashMap<>();

        for (Player player : players) {
            float nbWin = 0;
            for (Match match : matches) {
                if (match instanceof Single) {
                    if (((Single) match).getWinner() == player) {
                        nbWin += 1;
                    }
                } else if (match instanceof Double) {
                    List<Player> winners = ((Double) match).getWinner();
                    if (winners.contains(player)) {
                        nbWin += 1;
                    }
                }
            }
            out.put(player, nbWin);
        }

        List<Entry<Player, Float>> list = new ArrayList<>(out.entrySet());
        list.sort(Entry.comparingByValue());

        return list;
    }
}
