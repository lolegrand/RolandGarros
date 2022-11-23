package fr.rolandgarros.servlet.utils.StatisticsCriteria;

import fr.rolandgarros.model.Player;

import java.util.List;

public interface StatisticsFilterCriteria {

    List<Player> filterPlayer(List<Player> players);

}
