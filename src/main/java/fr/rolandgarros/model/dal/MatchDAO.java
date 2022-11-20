package fr.rolandgarros.model.dal;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.Match;

import java.sql.Timestamp;
import java.util.List;

public interface MatchDAO {


    Match getMatch(Court court, Timestamp start);
    void createMatch(Match match);
    void deleteMatch(Match match);
    void modifyMatch(Match match);
    Match getMatchById(int id);

    List<Match> getAllMatches();
    List<Match> getMatchesToCome();
    List<Match> getMatchesPast();

    List<Match> getSimpleMen();
    List<Match> getDoubleMen();
    List<Match> getSimpleWomen();
    List<Match> getDoubleWomen();

    List<Match> getSimpleMenToCome();
    List<Match> getDoubleMenToCome();
    List<Match> getSimpleWomenToCome();
    List<Match> getDoubleWomenToCome();

    List<Match> getSimpleMenPast();
    List<Match> getDoubleMenPast();
    List<Match> getSimpleWomenPast();
    List<Match> getDoubleWomenPast();

}
