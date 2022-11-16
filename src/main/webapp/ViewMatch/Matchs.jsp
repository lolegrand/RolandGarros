<%@ page import="java.util.List" %>
<%@ page import="fr.rolandgarros.model.Match" %>
<%@ page import="fr.rolandgarros.model.Single" %>
<%@ page import="fr.rolandgarros.model.Double" %>
<%
    String role = (String) request.getSession().getAttribute("role");
    boolean isMatchEditor = role != null && (role.equals("MatchEditor") || role.equals("Admin"));

    boolean displayMore = request.getParameter("displayMatch") != null;

    boolean isAdmin = role != null && role.equals("Admin");

    /*
    List<Match> matches = (List<Match>) request.getAttribute("matches");
    List<Match> matchesPast = (List<Match>) request.getAttribute("matchesPast");
    List<Match> matchesToCome = (List<Match>) request.getAttribute("matchesToCome");
    */

    /*
     * Match Simple Men (MSM)
     * Match Simple Women (MSW)
     * Match Double Men (MDM)
     * Match Double Women (MDW)
     */

    /*
    List<Single> MSM = (List<Single>) request.getAttribute("MSM");
    List<Single> MSW = (List<Single>) request.getAttribute("MSW");
    List<Double> MDM = (List<Double>) request.getAttribute("MDM");
    List<Double> MDW = (List<Double>) request.getAttribute("MDW");
    */

    /*
     * Match Simple Past          (MSP)
     * Match Simple Men Past      (MSMP)
     * Match Simple Women Past    (MSWP)
     * Match Double Men Past      (MDMP)
     * Match Double Women Past    (MDWP)
     */

    /*
    List<Single> MSMP = (List<Single>) request.getAttribute("MSMP");
    List<Single> MSWP = (List<Single>) request.getAttribute("MSWP");
    List<Double> MDMP = (List<Double>) request.getAttribute("MDMP");
    List<Double> MDWP = (List<Double>) request.getAttribute("MDWP");
    */

    /*
     * Match Simple ToCome          (MST)
     * Match Simple Men ToCome      (MSMT)
     * Match Simple Women ToCome    (MSWT)
     * Match Double Men ToCome      (MDMT)
     * Match Double Women ToCome    (MDWT)
     */

    List<Single> MSMT = (List<Single>) request.getAttribute("MSMT");
    List<Single> MSWT = (List<Single>) request.getAttribute("MSWT");
    List<Double> MDMT = (List<Double>) request.getAttribute("MDMT");
    List<Double> MDWT = (List<Double>) request.getAttribute("MDWT");

%>

<%@ include file="../Template/head.jsp" %>

<body class="column">
<%@ include file="../Template/header.jsp" %>

<main class="w-100 row space-around">
    <% if (isMatchEditor) { %>
    <a href="/MatchCreation">Créer un match</a>
    <% } %>

    <h1 class="w-100 txt-center">Matchs à venir</h1>

    <h2 class="w-100">Simple hommes</h2>
    <div class="w-100 scrollable"><%
        if (MSMT.size() > 0) { %>
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
                    <th>Supprimer</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
            <% for (Single match : MSMT) { %>
                <tr>
                    <td><%= match.getCourt() %></td>
                    <td><%= match.getStartDate() %></td>
                    <td><%= match.getPlayerOne() %></td>
                    <td><%= match.getScoreOne() %></td>
                    <td><%= match.getPlayerTwo() %></td>
                    <td><%= match.getScoreTwo() %></td>
                    <% if (isMatchEditor) { %>
                    <td><a href="/MatchUpdate?id=<%= match.getIdT() %>">Modifier</a></td>
                    <td>
                        <form action="post">
                            <input type="hidden" name="matchIdDeletion" value="<%= match.getIdT() %>" />
                            <button class="btn-red" type="submit" onclick="return confirm('Voulez-vous supprimer ce match ?')">
                                Supprimer
                            </button>
                        </form>
                    </td>
                    <% } %>
                </tr>
            <% } %>
            </tbody>
        </table><%
        }
        else { %>
        <p>Aucun match prévu</p><%
            } %>
    </div>

    <h2 class="w-100">Simple femmes</h2>
    <div class="w-100 scrollable"><%
        if (MSWT.size() > 0) { %>
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
                    <th>Supprimer</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
            <% for (Single match : MSWT) { %>
                <tr>
                    <td><%= match.getCourt() %></td>
                    <td><%= match.getStartDate() %></td>
                    <td><%= match.getPlayerOne() %></td>
                    <td><%= match.getScoreOne() %></td>
                    <td><%= match.getPlayerTwo() %></td>
                    <td><%= match.getScoreTwo() %></td>
                    <% if (isMatchEditor) { %>
                    <td><a href="/MatchUpdate?id=<%= match.getIdT() %>">Modifier</a></td>
                    <td>
                        <form action="post">
                            <input type="hidden" name="matchIdDeletion" value="<%= match.getIdT() %>" />
                            <button class="btn-red" type="submit" onclick="return confirm('Voulez-vous supprimer ce match ?')">
                                Supprimer
                            </button>
                        </form>
                    </td>
                    <% } %>
                </tr>
            <% } %>
            </tbody>
        </table><%
        }
        else { %>
        <p>Aucun match prévu</p><%
            } %>
    </div>

    <h2 class="w-100">Double hommes</h2>
    <div class="w-100 scrollable"><%
        if (MDMT.size() > 0) { %>
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
                    <th>Supprimer</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
            <% for (Double match : MDMT) { %>
                <tr>
                    <td><%= match.getCourt() %></td>
                    <td><%= match.getStartDate() %></td>
                    <td><%= match.getTeamOnePlayerOne() %> et <%= match.getTeamOnePlayerTwo() %></td>
                    <td><%= match.getScoreOne() %></td>
                    <td><%= match.getTeamTwoPlayerOne() %> et <%= match.getTeamTwoPlayerTwo() %></td>
                    <td><%= match.getScoreTwo() %></td>
                    <% if (isMatchEditor) { %>
                    <td><a href="/MatchUpdate?id=<%= match.getIdT() %>">Modifier</a></td>
                    <td>
                        <form action="post">
                            <input type="hidden" name="matchIdDeletion" value="<%= match.getIdT() %>" />
                            <button class="btn-red" type="submit" onclick="return confirm('Voulez-vous supprimer ce match ?')">
                                Supprimer
                            </button>
                        </form>
                    </td>
                    onclick="return confirm('Voulez-vous accepter cette entrainement ?')">
                    <% } %>
                </tr>
            <% } %>
            </tbody>
        </table><%
        }
        else { %>
        <p>Aucun match prévu</p><%
        } %>
    </div>

    <h2 class="w-100">Double femmes</h2>
    <div class="w-100 scrollable"><%
        if (MDWT.size() > 0) { %>
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
                    <th>Supprimer</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
            <% for (Double match : MDWT) { %>
                <tr>
                    <td><%= match.getCourt() %></td>
                    <td><%= match.getStartDate() %></td>
                    <td><%= match.getTeamOnePlayerOne() %> et <%= match.getTeamOnePlayerTwo() %></td>
                    <td><%= match.getScoreOne() %></td>
                    <td><%= match.getTeamTwoPlayerOne() %> et <%= match.getTeamTwoPlayerTwo() %></td>
                    <td><%= match.getScoreTwo() %></td>
                    <td><a href="/MatchUpdate?id=<%= match.getIdT() %>">Modifier</a></td>
                    <td>
                        <form action="post">
                            <input type="hidden" name="matchIdDeletion" value="<%= match.getIdT() %>" />
                            <button class="btn-red" type="submit" onclick="return confirm('Voulez-vous supprimer ce match ?')">
                                Supprimer
                            </button>
                        </form>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table><%
        }
        else { %>
        <p>Aucun match prévu</p><%
        } %>
    </div>

    <% if (displayMore) { %>
    <% } %>
</main>

<%@ include file="../Template/footer.jsp" %>
</body>
</html>