package fr.rolandgarros.services;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.Match;
import fr.rolandgarros.model.dal.MatchDAO;
import fr.rolandgarros.model.dal.dataModel.MatchDAOImpl;
import fr.rolandgarros.model.dal.stub.MatchDAOMock;

import java.sql.Timestamp;
import java.util.List;

public class MatchService {
//    private final MatchDAO matchDAO = new MatchDAOMock();
    private final MatchDAO matchDAO = new MatchDAOImpl();

    public Match getMatch(Court court, Timestamp start) { return matchDAO.getMatch(court, start); }
    public Match getMatchById(int id) { return matchDAO.getMatchById(id); }
    public void createMatch(Match match) {
        matchDAO.createMatch(match);
    }
    public void deleteMatch(Match match) {
        matchDAO.deleteMatch(match);
    }
    public void modifyMatch(Match match) {
        matchDAO.modifyMatch(match);
    }
    public List<Match> getAllMatches() {
        return matchDAO.getAllMatches();
    }
    public List<Match> getMatchesToCome() { return matchDAO.getMatchesToCome(); }
    public List<Match> getMatchesPast() { return matchDAO.getMatchesPast(); }

    public List<Match> getSimpleMen() { return matchDAO.getSimpleMen(); }
    public List<Match> getDoubleMen() { return matchDAO.getDoubleMen(); }
    public List<Match> getSimpleWomen() { return matchDAO.getSimpleWomen(); }
    public List<Match> getDoubleWomen() { return matchDAO.getDoubleWomen(); }

    public List<Match> getSimpleMenToCome() { return matchDAO.getSimpleMenToCome(); }
    public List<Match> getDoubleMenToCome() { return matchDAO.getDoubleMenToCome(); }
    public List<Match> getSimpleWomenToCome() { return matchDAO.getSimpleWomenToCome(); }
    public List<Match> getDoubleWomenToCome() { return matchDAO.getDoubleWomenToCome(); }

    public List<Match> getSimpleMenPast() { return matchDAO.getSimpleMenPast(); }
    public List<Match> getDoubleMenPast() { return matchDAO.getDoubleMenPast(); }
    public List<Match> getSimpleWomenPast() { return matchDAO.getSimpleWomenPast(); }
    public List<Match> getDoubleWomenPast() { return matchDAO.getDoubleWomenPast(); }
}
