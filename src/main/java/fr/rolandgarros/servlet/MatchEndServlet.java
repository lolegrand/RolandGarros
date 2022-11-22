package fr.rolandgarros.servlet;

import fr.rolandgarros.model.*;
import fr.rolandgarros.services.MatchService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchEndServlet extends HttpServlet {
    private static final MatchService matchService = new MatchService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ViewMatch/EndMatch.jsp";

        Role role = (Role) request.getSession().getAttribute("role");
        boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

// TODO inverser la condition
        // Redirects the user if he is not permitted
        if (isMatchEditor) {
            response.sendRedirect("/Matches");
            return;
        }

        // Or display the page
        boolean error = false;
        String matchId = request.getParameter("id");

        if (matchId == null) {
            error = true;
        }
        else {
            try {
                // Check if the match exists
                Match match = matchService.getMatchById(Integer.parseInt(matchId));
                if (match == null) {
                    error = true;
                }
            }
            catch (IllegalArgumentException iae) {
                error = true;
            }
        }

        if (error) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Template/error.jsp");
            dispatcher.forward(request, response);
        }

        else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Role role = (Role) request.getSession().getAttribute("role");
        boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

// TODO inverser la condition
        // Redirects the user if he is not permitted
        if (isMatchEditor) {
            response.sendRedirect("/Matches");
            return;
        }

        // Or handle the form to update start date and court, everything else is read-only

        boolean error = false;
        List<Integer> scoresOne = new ArrayList<>();
        List<Integer> scoresTwo = new ArrayList<>();
        Match match = null;
        Timestamp ts = null;

        String matchId = request.getParameter("matchId");
        String matchDuration = request.getParameter("matchDuration");
        String[] scoresPlayerOne = {
            request.getParameter("scoreS1P1"),
            request.getParameter("scoreS2P1"),
            request.getParameter("scoreS3P1"),
            request.getParameter("scoreS4P1"),
            request.getParameter("scoreS5P1"),
        };
        String[] scoresPlayerTwo = {
            request.getParameter("scoreS1P2"),
            request.getParameter("scoreS2P2"),
            request.getParameter("scoreS3P2"),
            request.getParameter("scoreS4P2"),
            request.getParameter("scoreS5P2"),
        };

        try {
            // check this match exists and is not yet terminated
            match = matchService.getMatchById(Integer.parseInt(matchId));
            if (match == null || ! match.isTimeEventPassed()) {
                error = true;
            }
            else {
                // The HTML input[type=time] has the format hh:mm, so we check the format and retrieve the data
                Matcher m = Pattern.compile("([01][0-9]|2[0-3]):([0-5][0-9])").matcher(matchDuration);
                if (m.matches()) {
                    long hours = Long.parseLong(m.group(0));
                    long minutes = Long.parseLong(m.group(1));
                    ts = new Timestamp(match.getStartDate().getTime() + (hours * 60 + minutes) * 60 * 1_000);
                }
                else {
                    error = true;
                }

                // Check the validity of submitted scores
                if (!error) {
                    int setsToWin = (match.getGender().equals(Gender.MALE) && match instanceof Single) ? 3 : 2;
                    int playerOneSetsWon = 0;
                    int playerTwoSetsWon = 0;

                    // At most setsToWin * 2 - 1 sets can be played we analyze them and ignore any further GET parameters
                    for (int i = 0; i < setsToWin * 2 - 1; i++) {
                        String scorePlayerOne = scoresPlayerOne[i];
                        String scorePlayerTwo = scoresPlayerTwo[i];

                        if (scorePlayerOne == null || scorePlayerTwo == null) {
                            // Tolerate missing fields only if they were not required and if they are BOTH absent
                            if (
                                    (playerOneSetsWon < setsToWin && playerTwoSetsWon < setsToWin)
                                    || (scorePlayerOne != null || scorePlayerTwo != null)
                            ) {
                                throw new IllegalArgumentException("Invalid set scores.");
                            }
                        }
                        else {
                            // Tries to parse their value to integers
                            int scoreOne = Integer.parseInt(scorePlayerOne);
                            int scoreTwo = Integer.parseInt(scorePlayerTwo);

                            // Define possible cases the scores can fill
                            if ((playerOneSetsWon == setsToWin || playerTwoSetsWon == setsToWin) && scoreOne == 0 && scoreTwo == 0) {
                                // Ignore the empty (zeros) fields after the necessary sets have been found
                                // Throws only if superfluous data is submitted
                                continue;
                            }
                            else if (
                                    (scoreOne == 7 && (scoreTwo == 5 || scoreTwo == 6))
                                    || (scoreOne == 6 && 0 < scoreTwo && scoreTwo <= 4)
                            ) {
                                scoresOne.add(scoreOne);
                                playerOneSetsWon++;
                            }
                            else if (
                                    (scoreTwo == 7 && (scoreOne == 5 || scoreOne == 6))
                                    || (scoreTwo == 6 && 0 < scoreOne && scoreOne <= 4)
                            ) {
                                scoresTwo.add(scoreTwo);
                                playerTwoSetsWon++;
                            }
                            // If the score are not in any possible case, then they are wrong
                            else {
                                throw new IllegalArgumentException("Invalid set scores.");
                            }
                        }
                    }
                }
            }
        }
        // NumberFormatException is a subtype of IllegalArgumentException
        catch (IllegalArgumentException iae) {
            error = true;
        }

        // If an error has been found in the submission
        if (error) {
            // Redirects the user to the same form to prevent resubmission
            response.sendRedirect("/MatchEnd?id=" + match.getIdT());
        }

        else {
            match.endMatch(ts, scoresOne, scoresTwo);
            matchService.modifyMatch(match);

            // Then redirects the user to prevent multiple form submission
            response.sendRedirect("/Matches");
        }
    }
}
