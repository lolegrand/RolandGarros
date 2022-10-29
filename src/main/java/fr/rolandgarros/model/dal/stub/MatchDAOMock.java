package fr.rolandgarros.model.dal.stub;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.Match;
import fr.rolandgarros.model.dal.MatchDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MatchDAOMock implements MatchDAO {
    private final List<Match> allMatches = new ArrayList<>();
    private final List<Match> matches = new ArrayList<>();


    Date today = new Date(System.currentTimeMillis());


    @Override
    public Match getMatch(Court court, Date start) {
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
            if ( match.getType().equals( "Simple" )
                    && match.getGenre().equals( "Male" )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getDoubleMen() {
        for ( Match match : allMatches ) {
            if ( match.getType().equals( "Double" )
                    && match.getGenre().equals( "Male" )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getSimpleWomen() {
        for ( Match match : allMatches ) {
            if ( match.getType().equals( "Simple" )
                    && match.getGenre().equals( "Female" )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getDoubleWomen() {
        for ( Match match : allMatches ) {
            if ( match.getType().equals( "Double" )
                    && match.getGenre().equals( "Female" )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }

    @Override
    public List<Match> getSimpleMenToCome() {
        for ( Match match : allMatches ) {
            if ( match.getType().equals( "Simple" )
                    && match.getGenre().equals( "Male" )
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
            if ( match.getType().equals( "Double" )
                    && match.getGenre().equals( "Male" )
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
            if ( match.getType().equals( "Simple" )
                    && match.getGenre().equals( "Female" )
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
            if ( match.getType().equals( "Double" )
                    && match.getGenre().equals( "Female" )
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
            if ( match.getType().equals( "Simple" )
                    && match.getGenre().equals( "Male" )
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
            if ( match.getType().equals( "Double" )
                    && match.getGenre().equals( "Male" )
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
            if ( match.getType().equals( "Simple" )
                    && match.getGenre().equals( "Female" )
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
            if ( match.getType().equals( "Double" )
                    && match.getGenre().equals( "Female" )
                    && match.getStartDate().before( today )
            ) {
                matches.add( match );
            }
        }
        return matches;
    }
}
