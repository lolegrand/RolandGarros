<%@ page import="fr.rolandgarros.core.Utils" %>
<%@ page import="fr.rolandgarros.model.Match" %>
<%@ page import="fr.rolandgarros.model.Single" %>
<%@ page import="fr.rolandgarros.model.Double" %>
<%@ page import="fr.rolandgarros.model.Gender" %>

<%
    Match match = (Match) request.getAttribute("match");
    String matchType = (String) request.getAttribute("matchType");

    String playerType = matchType.equals("Simple") ? "Joueur" : "Équipe";

    Object _error = session.getAttribute("tempUpdateError");
    boolean error = (_error != null) && (boolean) _error;

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
    <% if (error) { %>
    <p class="btn-red">
        Erreur dans votre formulaire, veuillez recommencer.
    </p>
    <% } %>

    <article class="content">
        <h2 class="txt-center no-margin">Clore un match</h2>

        <form class="flex-column gap-1" method="post">
            <div class="flex-row gap-1">
                <div class="flex-column justify-start items-center padding-1 gap-1">
                    <h3 class="no-margin">Modalités</h3>

                    <input type="hidden" name="matchId" value="<%= match.getIdT() %>" />

                    <label>Catégorie</label>
                    <input type="text" disabled="disabled" value="<%= request.getAttribute("matchType") %>" />

                    <label>Genre</label>
                    <input type="text" disabled="disabled" value="<%= match.getGender().equals(Gender.MALE) ? "Homme" : "Femme" %>" />

                    <label>Court</label>
                    <input type="text" disabled="disabled" value="<%= match.getCourt() %>" />

                    <label>Date et heure de début</label>
                    <input type="datetime-local" disabled="disabled" value="<%= Utils.dateFormatHTMLInput.format(match.getStartDate()) %>" />
                </div>

                <hr />

                <div class="flex-column justify-start items-center padding-1 gap-1">
                    <h3 class="no-margin">Participants</h3>

                    <% if (matchType.equals("Simple")) { %>
                    <% Single matchSingle = (Single) match; %>
                    <label>Participant 1</label>
                    <input type="text" disabled="disabled" value="<%= matchSingle.getPlayerOne() %>" />

                    <label>Participant 2</label>
                    <input type="text" disabled="disabled" value="<%= matchSingle.getPlayerTwo() %>" />
                    <% } %>

                    <% if (matchType.equals("Double")) { %>
                    <% Double matchDouble = (Double) match; %>
                    <p>Équipe 1</p>

                    <label>Participant 1</label>
                    <input type="text" disabled="disabled" value="<%= matchDouble.getTeamOnePlayerOne() %>" />

                    <label>Participant 2</label>
                    <input type="text" disabled="disabled" value="<%= matchDouble.getTeamOnePlayerTwo() %>" />

                    <p>Équipe 2</p>

                    <label>Participant 1</label>
                    <input type="text" disabled="disabled" value="<%= matchDouble.getTeamTwoPlayerOne() %>" />

                    <label>Participant 2</label>
                    <input type="text" disabled="disabled" value="<%= matchDouble.getTeamTwoPlayerTwo() %>" />
                    <% } %>
                </div>
            </div>

            <hr class="w-100" />

            <div class="flex-column margin-bottom-1 gap-1">
                <h3 class="no-margin txt-center">Résultats</h3>

                <div class="flex-column gap-1">
                    <label class="txt-center" for="matchDuration">Temps de jeu</label>
                    <input type="text" name="matchDuration" id="matchDuration" pattern="[0-9]{1,2}:[0-5][0-9]:[0-5][0-9]" value="00:00:00" />
                </div>

                <h4 class="no-margin margin-top-1 txt-center">Premier set</h4>
                <div class="flex-row justify-center">
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS1P1"><%= playerType %> 1</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS1P1" id="scoreS1P1" />
                    </div>
                    <hr style="margin: 0 2rem;" />
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS1P2"><%= playerType %> 2</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS1P2" id="scoreS1P2" />
                    </div>
                </div>

                <h4 class="no-margin margin-top-1 txt-center">Deuxième set</h4>
                <div class="flex-row justify-center">
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS2P1"><%= playerType %> 1</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS2P1" id="scoreS2P1" />
                    </div>
                    <hr style="margin: 0 2rem;" />
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS2P2"><%= playerType %> 2</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS2P2" id="scoreS2P2" />
                    </div>
                </div>

                <h4 class="no-margin margin-top-1 txt-center">Troisième set</h4>
                <div class="flex-row justify-center">
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS3P1"><%= playerType %> 1</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS3P1" id="scoreS3P1" />
                    </div>
                    <hr style="margin: 0 2rem;" />
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS3P2"><%= playerType %> 2</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS3P2" id="scoreS3P2" />
                    </div>
                </div>

                <% if (match.getGender().equals(Gender.MALE) && matchType.equals("Simple")) { %>
                <h4 class="no-margin margin-top-1 txt-center">Quatrième set</h4>
                <div class="flex-row justify-center">
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS4P1"><%= playerType %> 1</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS4P1" id="scoreS4P1" />
                    </div>
                    <hr style="margin: 0 2rem;" />
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS4P2"><%= playerType %> 2</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS4P2" id="scoreS4P2" />
                    </div>
                </div>

                <h4 class="no-margin margin-top-1 txt-center">Cinquième set</h4>
                <div class="flex-row justify-center">
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS5P1"><%= playerType %> 1</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS5P1" id="scoreS5P1" />
                    </div>
                    <hr style="margin: 0 2rem;" />
                    <div class="flex-column items-center gap-1">
                        <label for="scoreS5P2"><%= playerType %> 2</label>
                        <input type="number" min="0" max="7" value="0" name="scoreS5P2" id="scoreS5P2" />
                    </div>
                </div>
                <% } %>
            </div>

            <small class="txt-center">Laissez égaux à 0 les sets non joués</small>

            <button class="btn-blue" type="submit">Valider</button>

            <hr class="w-100" />

            <a class="btn-red txt-center" href="/Matches">Annuler</a>
        </form>
    </article>
</main>

<%@ include file="../Template/footer.jsp" %>
</body>
</html>