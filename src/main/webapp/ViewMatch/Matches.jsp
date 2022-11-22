<%@ page import="java.util.List" %>
<%@ page import="fr.rolandgarros.model.Single" %>
<%@ page import="fr.rolandgarros.model.Double" %>
<%@ page import="fr.rolandgarros.model.Role" %>
<%
    Role role = (Role) request.getSession().getAttribute("role");
    boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;
// TODO remove this command when dev done
isMatchEditor = ! isMatchEditor;

    /*
     * Match Simple Men (MSM)
     * Match Simple Women (MSW)
     * Match Double Men (MDM)
     * Match Double Women (MDW)
     */

    String matchesCategory = (String) request.getAttribute("matches");
    List<Single> MSM = (List<Single>) request.getAttribute("MSM");
    List<Single> MSW = (List<Single>) request.getAttribute("MSW");
    List<Double> MDM = (List<Double>) request.getAttribute("MDM");
    List<Double> MDW = (List<Double>) request.getAttribute("MDW");
%>

<%@ include file="../Template/head.jsp" %>

<body class="column">
<%@ include file="../Template/header.jsp" %>

<main class="w-100 row space-around">
    <% if (isMatchEditor) { %>
    <a href="/MatchCreation">Créer un match</a>
    <% } %>

    <a href="/Matches?matches=all">Tous les matchs</a>
    <a href="/Matches?matches=past">Matchs passés</a>
    <a href="/Matches?matches=toCome">Matchs à venir</a>

    <h1 class="w-100 txt-center">
        <% if (matchesCategory.equals("all")) { %>
        Tous les matchs
        <% } else if (matchesCategory.equals("past")) { %>
        Matchs passés
        <% } else if (matchesCategory.equals("toCome")) { %>
        Matchs à venir
        <% } %>
    </h1>

    <h2 class="w-100">Simple hommes</h2>
    <div class="w-100 scrollable">
        <% if (MSM.size() > 0) { %>
        <table class="w-100">
            <thead>
                <tr>
                    <th>Court</th>
                    <th>Date et heure</th>
                    <th>Joueur 1</th>
                    <th>Score 1</th>
                    <th>Joueur 2</th>
                    <th>Score 2</th>
                    <% if (isMatchEditor) { %>
                    <th>Modifier</th>
                    <th>Terminer</th>
                    <th>Supprimer</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
            <% for (Single match : MSM) { %>
                <tr>
                    <td><%= match.getCourt() %></td>
                    <td><%= match.getStartDate() %></td>
                    <td><%= match.getPlayerOne() %></td>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><%= match.getScoreOne() %></td>
                    <% } else { %>
                    <td>—</td>
                    <% } %>
                    <td><%= match.getPlayerTwo() %></td>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><%= match.getScoreTwo() %></td>
                    <% } else { %>
                    <td>—</td>
                    <% } %>
                    <% if (isMatchEditor) { %>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><a class="btn btn-dark btn-disabled">Modifier</a></td>
                    <td><a class="btn btn-dark btn-disabled">Terminer</a></td>
                    <td><a class="btn btn-dark btn-disabled">Supprimer</a></td>
                    <% } else { %>
                    <td><a href="/MatchUpdate?id=<%= match.getIdT() %>" class="btn btn-blue">Modifier</a></td>
                    <td><a href="/MatchEnd?id=<%= match.getIdT() %>" class="btn btn-blue">Terminer</a></td>
                    <td>
                        <form class="row no-margin" method="post">
                            <input type="hidden" name="matchIdDeletion" value="<%= match.getIdT() %>" />
                            <button class="flex-grow btn btn-red" type="submit" onclick="return confirm('Voulez-vous supprimer ce match ?')">
                                Supprimer
                            </button>
                        </form>
                    </td>
                    <% } %>
                    <% } %>
                </tr>
            <% } %>
            </tbody>
        </table>
        <% } else { %>
        <p>Aucun match prévu</p>
        <% } %>
    </div>

    <h2 class="w-100">Simple femmes</h2>
    <div class="w-100 scrollable">
        <% if (MSW.size() > 0) { %>
        <table class="w-100">
            <thead>
                <tr>
                    <th>Court</th>
                    <th>Date et heure</th>
                    <th>Joueur 1</th>
                    <th>Score 1</th>
                    <th>Joueur 2</th>
                    <th>Score 2</th>
                    <% if (isMatchEditor) { %>
                    <th>Modifier</th>
                    <th>Terminer</th>
                    <th>Supprimer</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
            <% for (Single match : MSW) { %>
                <tr>
                    <td><%= match.getCourt() %></td>
                    <td><%= match.getStartDate() %></td>
                    <td><%= match.getPlayerOne() %></td>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><%= match.getScoreOne() %></td>
                    <% } else { %>
                    <td>—</td>
                    <% } %>
                    <td><%= match.getPlayerTwo() %></td>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><%= match.getScoreTwo() %></td>
                    <% } else { %>
                    <td>—</td>
                    <% } %>
                    <% if (isMatchEditor) { %>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><a class="btn btn-dark btn-disabled">Modifier</a></td>
                    <td><a class="btn btn-dark btn-disabled">Terminer</a></td>
                    <td><a class="btn btn-dark btn-disabled">Supprimer</a></td>
                    <% } else { %>
                    <td><a href="/MatchUpdate?id=<%= match.getIdT() %>" class="btn btn-blue">Modifier</a></td>
                    <td><a href="/MatchEnd?id=<%= match.getIdT() %>" class="btn btn-blue">Terminer</a></td>
                    <td>
                        <form class="row no-margin" method="post">
                            <input type="hidden" name="matchIdDeletion" value="<%= match.getIdT() %>" />
                            <button class="flex-grow btn btn-red" type="submit" onclick="return confirm('Voulez-vous supprimer ce match ?')">
                                Supprimer
                            </button>
                        </form>
                    </td>
                    <% } %>
                    <% } %>
                </tr>
            <% } %>
            </tbody>
        </table>
        <% } else { %>
        <p>Aucun match prévu</p>
        <% } %>
    </div>

    <h2 class="w-100">Double hommes</h2>
    <div class="w-100 scrollable">
        <% if (MDM.size() > 0) { %>
        <table class="w-100">
            <thead>
                <tr>
                    <th>Court</th>
                    <th>Date et heure</th>
                    <th>Equipe 1</th>
                    <th>Score 1</th>
                    <th>Equipe 2</th>
                    <th>Score 2</th>
                    <% if (isMatchEditor) { %>
                    <th>Modifier</th>
                    <th>Terminer</th>
                    <th>Supprimer</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
            <% for (Double match : MDM) { %>
                <tr>
                    <td><%= match.getCourt() %></td>
                    <td><%= match.getStartDate() %></td>
                    <td><%= match.getTeamOnePlayerOne() %> et <%= match.getTeamOnePlayerTwo() %></td>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><%= match.getScoreOne() %></td>
                    <% } else { %>
                    <td>—</td>
                    <% } %>
                    <td><%= match.getTeamTwoPlayerOne() %> et <%= match.getTeamTwoPlayerTwo() %></td>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><%= match.getScoreTwo() %></td>
                    <% } else { %>
                    <td>—</td>
                    <% } %>
                    <% if (isMatchEditor) { %>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><a class="btn btn-dark btn-disabled">Modifier</a></td>
                    <td><a class="btn btn-dark btn-disabled">Terminer</a></td>
                    <td><a class="btn btn-dark btn-disabled">Supprimer</a></td>
                    <% } else { %>
                    <td><a href="/MatchUpdate?id=<%= match.getIdT() %>" class="btn btn-blue">Modifier</a></td>
                    <td><a href="/MatchEnd?id=<%= match.getIdT() %>" class="btn btn-blue">Terminer</a></td>
                    <td>
                        <form class="row no-margin" method="post">
                            <input type="hidden" name="matchIdDeletion" value="<%= match.getIdT() %>" />
                            <button class="flex-grow btn btn-red" type="submit" onclick="return confirm('Voulez-vous supprimer ce match ?')">
                                Supprimer
                            </button>
                        </form>
                    </td>
                    <% } %>
                    <% } %>
                </tr>
            <% } %>
            </tbody>
        </table>
        <% } else { %>
        <p>Aucun match prévu</p>
        <% } %>
    </div>

    <h2 class="w-100">Double femmes</h2>
    <div class="w-100 scrollable">
        <% if (MDW.size() > 0) { %>
        <table class="w-100">
            <thead>
                <tr>
                    <th>Court</th>
                    <th>Date et heure</th>
                    <th>Equipe 1</th>
                    <th>Score 1</th>
                    <th>Equipe 2</th>
                    <th>Score 2</th>
                    <% if (isMatchEditor) { %>
                    <th>Modifier</th>
                    <th>Terminer</th>
                    <th>Supprimer</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
            <% for (Double match : MDW) { %>
                <tr>
                    <td><%= match.getCourt() %></td>
                    <td><%= match.getStartDate() %></td>
                    <td><%= match.getTeamOnePlayerOne() %> et <%= match.getTeamOnePlayerTwo() %></td>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><%= match.getScoreOne() %></td>
                    <% } else { %>
                    <td>—</td>
                    <% } %>
                    <td><%= match.getTeamTwoPlayerOne() %> et <%= match.getTeamTwoPlayerTwo() %></td>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><%= match.getScoreTwo() %></td>
                    <% } else { %>
                    <td>—</td>
                    <% } %>
                    <% if (isMatchEditor) { %>
                    <% if (match.isTimeEventPassed()) { %>
                    <td><a class="btn btn-dark btn-disabled">Modifier</a></td>
                    <td><a class="btn btn-dark btn-disabled">Terminer</a></td>
                    <td><a class="btn btn-dark btn-disabled">Supprimer</a></td>
                    <% } else { %>
                    <td><a href="/MatchUpdate?id=<%= match.getIdT() %>" class="btn btn-blue">Modifier</a></td>
                    <td><a href="/MatchEnd?id=<%= match.getIdT() %>" class="btn btn-blue">Terminer</a></td>
                    <td>
                        <form class="row no-margin" method="post">
                            <input type="hidden" name="matchIdDeletion" value="<%= match.getIdT() %>" />
                            <button class="flex-grow btn btn-red" type="submit" onclick="return confirm('Voulez-vous supprimer ce match ?')">
                                Supprimer
                            </button>
                        </form>
                    </td>
                    <% } %>
                    <% } %>
                </tr>
            <% } %>
            </tbody>
        </table>
        <% } else { %>
        <p>Aucun match prévu</p>
        <% } %>
    </div>
</main>

<%@ include file="../Template/footer.jsp" %>
</body>
</html>