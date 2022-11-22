<%@ page import="fr.rolandgarros.model.Match" %>
<%@ page import="fr.rolandgarros.model.Single" %>
<%@ page import="fr.rolandgarros.model.Double" %>

<%
    Match match = (Match) request.getAttribute("match");
    String matchType = (String) request.getAttribute("matchType");
    String matchGender = (String) request.getAttribute("matchGender");

    /*
    End match:
    - display all information about the match
    - fill scores to terminate the match
    -> the winner will be defined by the controller according to the scores
     */
%>

<%@ include file="../Template/head.jsp" %>

<body class="column">
<%@ include file="../Template/header.jsp" %>

<main>
<article class="w-50 row self-center space-around">
    <h2 class="w-100 txt-center">Clore un match</h2>

    <form class="row space-around" method="post">
        <h3 class="w-100">Modalités</h3>

        <input type="hidden" name="matchId" value="<%= match.getIdT() %>" />

        <p class="w-100 txt-justify"><%= matchType %>, <%= matchGender %></p>
        <p class="w-100 txt-justify"><%= match.getCourt() %>, <%= match.getStartDate().toString().substring(0, 16) %></p>

        <h3 class="w-100">Participants</h3>

        <% if (matchType.equals("Simple")) { %>
        <% Single singleMatch = (Single) match; %>
        <p class="w-100">
            <%= singleMatch.getPlayerOne() %> VS <%= singleMatch.getPlayerTwo() %>
        </p>
        <% } %>

        <% if (matchType.equals("Double")) { %>
        <% Double doubleMatch = (Double) match; %>
        <table class="fixed-layout">
            <tr class="tr-noBorder">
                <th>Équipe 1</th>
                <th></th>
                <th>Équipe 2</th>
            </tr>
            <tr class="tr-noBorder">
                <td><%= doubleMatch.getTeamOnePlayerOne() %></td>
                <td rowspan="2"> VS </td>
                <td><%= doubleMatch.getTeamTwoPlayerOne() %></td>
            </tr>
            <tr class="tr-noBorder">
                <td><%= doubleMatch.getTeamOnePlayerTwo() %></td>
                <td rowspan="2"> VS </td>
                <td><%= doubleMatch.getTeamTwoPlayerTwo() %></td>
            </tr>
        </table>
        <% } %>

        <h3 class="w-100">Résultats</h3>

        <label for="matchDuration">Temps de jeu</label>
        <input type="time" name="matchDuration" id="matchDuration" />

        <p>Premier set</p>
        <label for="scoreS1P1">Joueur/équipe 1</label>
        <input type="number" min="0" max="7" value="0" name="scoreS1P1" id="scoreS1P1" />
        <label for="scoreS1P2">Joueur/équipe 2</label>
        <input type="number" min="0" max="7" value="0" name="scoreS1P2" id="scoreS1P2" />

        <p>Deuxième set</p>
        <label for="scoreS2P1">Joueur/équipe 1</label>
        <input type="number" min="0" max="7" value="0" name="scoreS2P1" id="scoreS2P1" />
        <label for="scoreS2P2">Joueur/équipe 2</label>
        <input type="number" min="0" max="7" value="0" name="scoreS2P2" id="scoreS2P2" />

        <p>Troisième set</p>
        <label for="scoreS3P1">Joueur/équipe 1</label>
        <input type="number" min="0" max="7" value="0" name="scoreS3P1" id="scoreS3P1" />
        <label for="scoreS3P2">Joueur/équipe 2</label>
        <input type="number" min="0" max="7" value="0" name="scoreS3P2" id="scoreS3P2" />

        <% if (matchGender.equals("Male") && matchType.equals("Simple")) { %>
        <p>Quatrième set</p>
        <label for="scoreS4P1">Joueur/équipe 1</label>
        <input type="number" min="0" max="7" value="0" name="scoreS4P1" id="scoreS4P1" />
        <label for="scoreS4P2">Joueur/équipe 2</label>
        <input type="number" min="0" max="7" value="0" name="scoreS4P2" id="scoreS4P2" />

        <p>Cinquième set</p>
        <label for="scoreS5P1">Joueur/équipe 1</label>
        <input type="number" min="0" max="7" value="0" name="scoreS5P1" id="scoreS5P1" />
        <label for="scoreS5P2">Joueur/équipe 2</label>
        <input type="number" min="0" max="7" value="0" name="scoreS5P2" id="scoreS5P2" />
        <% } %>

        <small>Laissez égaux à 0 les sets non joués</small>

        <button class="btn-blue" type="submit">
            Valider
        </button>
        <a class="btn-red" href="/Matches">Annuler</a>
    </form>
</article>
</main>

<%@ include file="../Template/footer.jsp" %>
</body>
</html>