package fr.rolandgarros.model.dal;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.Match;

import java.sql.Date;
import java.util.List;

public interface MatchDAO {


    public Match getMatch(Court court, Date start);

    public List<Match> getAllMatches();
    public List<Match> getMatchesToCome();
    public List<Match> getMatchesPast();

    public List<Match> getSimpleMen();
    public List<Match> getDoubleMen();
    public List<Match> getSimpleWomen();
    public List<Match> getDoubleWomen();

    public List<Match> getSimpleMenToCome();
    public List<Match> getDoubleMenToCome();
    public List<Match> getSimpleWomenToCome();
    public List<Match> getDoubleWomenToCome();

    public List<Match> getSimpleMenPast();
    public List<Match> getDoubleMenPast();
    public List<Match> getSimpleWomenPast();
    public List<Match> getDoubleWomenPast();

}
