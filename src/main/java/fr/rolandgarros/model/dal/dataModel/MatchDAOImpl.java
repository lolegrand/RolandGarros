package fr.rolandgarros.model.dal.dataModel;
import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.Match;
import fr.rolandgarros.model.dal.MatchDAO;

import java.sql.Timestamp;
import java.util.List;

public class MatchDAOImpl implements MatchDAO {

    @Override
    public Match getMatch(Court court, Timestamp start) {
        return null;
    }

    @Override
    public Match getMatchById(int id) {
        return null;
    }

    @Override
    public List<Match> getAllMatches() {
        return null;
    }

    @Override
    public List<Match> getMatchesToCome() {
        return null;
    }

    @Override
    public List<Match> getMatchesPast() {
        return null;
    }

    @Override
    public List<Match> getSimpleMen() {
        return null;
    }

    @Override
    public List<Match> getDoubleMen() {
        return null;
    }

    @Override
    public List<Match> getSimpleWomen() {
        return null;
    }

    @Override
    public List<Match> getDoubleWomen() {
        return null;
    }

    @Override
    public List<Match> getSimpleMenToCome() {
        return null;
    }

    @Override
    public List<Match> getDoubleMenToCome() {
        return null;
    }

    @Override
    public List<Match> getSimpleWomenToCome() {
        return null;
    }

    @Override
    public List<Match> getDoubleWomenToCome() {
        return null;
    }

    @Override
    public List<Match> getSimpleMenPast() {
        return null;
    }

    @Override
    public List<Match> getDoubleMenPast() {
        return null;
    }

    @Override
    public List<Match> getSimpleWomenPast() {
        return null;
    }

    @Override
    public List<Match> getDoubleWomenPast() {
        return null;
    }
}
