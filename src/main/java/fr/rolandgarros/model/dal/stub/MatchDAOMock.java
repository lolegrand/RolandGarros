package fr.rolandgarros.model.dal.stub;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.Double;
import fr.rolandgarros.model.Gender;
import fr.rolandgarros.model.Match;
import fr.rolandgarros.model.Single;
import fr.rolandgarros.model.dal.MatchDAO;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MatchDAOMock implements MatchDAO {
    private final List<Match> allMatches = new ArrayList<>();
    private final List<Match> matches = new ArrayList<>();

    Date today = new Date(System.currentTimeMillis());

    @Override
    public Match getMatch(Court court, Timestamp start) {
        for (Match match : matches) {
            if ( match.getCourt().equals( court )
                    && match.getStartDate().equals( start )
            ) {
                return match;
            }
        }
        return null;
    }

    @Override
    public void createMatch(Match match) {
        matches.add(match);
    }

    @Override
    public void deleteMatch(Match match) {
        matches.remove(match);
    }

    @Override
    public void modifyMatch(Match match) {
        matches.remove(match);
        matches.add(match);
    }

    @Override
    public Match getMatchById(int id) {
        return null;
    }

    @Override
    public List<Match> getAllMatches() {
        return allMatches;
    }

    @Override
    public List<Match> getMatchesToCome() {
        for ( Match match : allMatches ) {
            if ( match.getStartDate().after( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getMatchesPast() {
        for ( Match match : allMatches ) {
            if ( match.getStartDate().before( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getSimpleMen() {
        for ( Match match : allMatches ) {
            if ( match instanceof Single
                    && match.getGender().equals( Gender.MALE )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getDoubleMen() {
        for ( Match match : allMatches ) {
            if ( match instanceof Double
                    && match.getGender().equals( Gender.MALE )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getSimpleWomen() {
        for ( Match match : allMatches ) {
            if ( match instanceof Single
                    && match.getGender().equals( Gender.FEMALE )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getDoubleWomen() {
        for ( Match match : allMatches ) {
            if ( match instanceof Double
                    && match.getGender().equals( Gender.FEMALE )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getSimpleMenToCome() {
        for ( Match match : allMatches ) {
            if ( match instanceof Single
                    && match.getGender().equals( Gender.MALE )
                    && match.getStartDate().after( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getDoubleMenToCome() {
        for ( Match match : allMatches ) {
            if ( match instanceof Double
                    && match.getGender().equals( Gender.MALE )
                    && match.getStartDate().after( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getSimpleWomenToCome() {
        for ( Match match : allMatches ) {
            if ( match instanceof Single
                    && match.getGender().equals( Gender.FEMALE )
                    && match.getStartDate().after( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getDoubleWomenToCome() {
        for ( Match match : allMatches ) {
            if ( match instanceof Double
                    && match.getGender().equals( Gender.FEMALE )
                    && match.getStartDate().after( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getSimpleMenPast() {
        for ( Match match : allMatches ) {
            if ( match instanceof Single
                    && match.getGender().equals( Gender.MALE )
                    && match.getStartDate().before( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getDoubleMenPast() {
        for ( Match match : allMatches ) {
            if ( match instanceof Double
                    && match.getGender().equals( Gender.MALE )
                    && match.getStartDate().before( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getSimpleWomenPast() {
        for ( Match match : allMatches ) {
            if ( match instanceof Single
                    && match.getGender().equals( Gender.FEMALE )
                    && match.getStartDate().before( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getDoubleWomenPast() {
        for ( Match match : allMatches ) {
            if ( match instanceof Double
                    && match.getGender().equals( Gender.FEMALE )
                    && match.getStartDate().before( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }
}
