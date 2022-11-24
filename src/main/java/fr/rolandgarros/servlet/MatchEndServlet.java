package fr.rolandgarros.servlet;

import fr.rolandgarros.model.*;
import fr.rolandgarros.services.MatchService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

        // Redirects the user if he is not permitted
        if (! isMatchEditor) {
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
                    throw new IllegalArgumentException("This match does not exist.");
                }

                request.setAttribute("match", match);
                request.setAttribute("matchType", match instanceof Single ? "Simple" : "Double");
            }
            catch (IllegalArgumentException iae) {
                error = true;
            }
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(error ? "/Template/error.jsp" : page);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute("role");
        boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

        // Redirects the user if he is not permitted
        if (! isMatchEditor) {
            response.sendRedirect("/Matches");
            return;
        }

        // Or handle the form to update start date and court, everything else is read-only

        boolean error = false;
        Match match = null;
        Timestamp ts = null;
        List<Integer> scoresOne = new ArrayList<>();
        List<Integer> scoresTwo = new ArrayList<>();

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

        if (matchId == null || matchDuration == null) {
            error = true;
        }
        else {
            try {
                // check this match exists and is not yet terminated
                match = matchService.getMatchById(Integer.parseInt(matchId));
                if (match == null || match.isTimeEventPassed()) {
                    throw new IllegalArgumentException("Match should exist and not be already passed.");
                }

                // The HTML input has the format [h]h:mm:ss, so we check the format and retrieve the data
                Matcher m = Pattern.compile("([0-9]{1,2}):([0-5][0-9]):([0-5][0-9])").matcher(matchDuration);
                if (m.matches()) {
                    long hours = Long.parseLong(m.group(1));
                    long minutes = Long.parseLong(m.group(2));
                    long seconds = Long.parseLong(m.group(3));
                    ts = new Timestamp(match.getStartDate().getTime() + (hours * 3_600 + minutes * 60 + seconds) * 1_000);
                }
                else {
                    throw new IllegalArgumentException("Timestamp does not match [H]H:MM:SS format.");
                }

                // Then check the validity of submitted scores
                int setsToWin = (match.getGender().equals(Gender.MALE) && match instanceof Single) ? 3 : 2;
                int playerOneSetsWon = 0;
                int playerTwoSetsWon = 0;

                // At most setsToWin * 2 - 1 sets can be played we analyze them and ignore any further GET parameters
                for (int i = 0; i < setsToWin * 2 - 1; i++) {
                    String scorePlayerOne = scoresPlayerOne[i];
                    String scorePlayerTwo = scoresPlayerTwo[i];

                    if (scorePlayerOne == null || scorePlayerTwo == null) {
                        // Throws if there is no winner and a score is null
                        // Or if there is already a winner and scores are inconsistently null and not null
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
                        if ((playerOneSetsWon == setsToWin || playerTwoSetsWon == setsToWin)) {
                            // Ignore the empty (zeros) fields after a player/team has won
                            // And throw only if superfluous data is submitted
                            if (scoreOne != 0 || scoreTwo != 0) {
                                throw new IllegalArgumentException("Invalid set scores.");
                            }
                        }
                        // If the score are not in any possible case, then they are wrong
                        else {
                            scoresOne.add(scoreOne);
                            scoresTwo.add(scoreTwo);
                            if (
                                    (scoreOne == 7 && (scoreTwo == 5 || scoreTwo == 6))
                                            || (scoreOne == 6 && 0 < scoreTwo && scoreTwo <= 4)
                            ) {
                                playerOneSetsWon++;
                            }
                            else if (
                                    (scoreTwo == 7 && (scoreOne == 5 || scoreOne == 6))
                                            || (scoreTwo == 6 && 0 < scoreOne && scoreOne <= 4)
                            ) {
                                playerTwoSetsWon++;
                            }
                            else {
                                throw new IllegalArgumentException("Invalid set scores.");
                            }
                        }
                    }
                }
            }
            // NumberFormatException is a subtype of IllegalArgumentException
            catch (IllegalArgumentException iae) {
                error = true;
            }
        }

        if (match == null) {
            // 400 Bad Request
            response.setStatus(400);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Template/error.jsp");
            dispatcher.forward(request, response);
        }
        // If an error has been found in the submission
        else if (error) {
            session.setAttribute("tempUpdateError", true);
            // Redirects the user to the same form to prevent resubmission
            response.sendRedirect("/MatchEnd?id=" + match.getIdT());
        }

        else {
            match.endMatch(ts, scoresOne, scoresTwo);
            matchService.modifyMatch(match);
            session.removeAttribute("tempUpdateError");

            // Then redirects the user to the list of matches
            response.sendRedirect("/Matches");
        }
    }
}
