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

public class TimeGameSortPlayer implements StatisticsSortCriteria{
    @Override
    public List<Entry<Player, Float>> sortPlayer(List<Player> players, List<Match> matches) {
        Map<Player, Float> out = new HashMap<>();

        for (Player player : players) {
            float nbMilli = 0;
            for (Match match : matches) {
                if (match.isTimeEventPassed()) {
                    if (match instanceof Single) {
                        if (player.equals(((Single) match).getPlayerTwo()) ||
                                player.equals(((Single) match).getPlayerOne())) {
                            nbMilli += match.getEndDate().getTime() - match.getStartDate().getTime();
                        }

                    } else if (match instanceof Double) {
                        List<Player> matchPlayers = new ArrayList<>();
                        matchPlayers.add(((Double) match).getTeamOnePlayerOne());
                        matchPlayers.add(((Double) match).getTeamOnePlayerTwo());
                        matchPlayers.add(((Double) match).getTeamTwoPlayerOne());
                        matchPlayers.add(((Double) match).getTeamTwoPlayerTwo());
                        if (matchPlayers.contains(player)) {
                            nbMilli += match.getEndDate().getTime() - match.getStartDate().getTime();
                        }
                    }
                }
            }
            nbMilli = nbMilli / 1000;
            nbMilli = nbMilli / 3600;
            out.put(player, nbMilli);
        }

        List<Entry<Player, Float>> list = new ArrayList<>(out.entrySet());
        list.sort(Entry.comparingByValue());

        return list;
    }
}
