package fr.rolandgarros.servlet.utils.StatisticsCriteria;

import fr.rolandgarros.model.Match;
import fr.rolandgarros.model.Player;

import java.util.List;
import java.util.Map;

public interface StatisticsSortCriteria {

    List<Map.Entry<Player, Float>> sortPlayer(List<Player> players, List<Match> matches);

}
