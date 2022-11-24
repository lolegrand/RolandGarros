<%@ page import="fr.rolandgarros.core.Utils" %>
<%@ page import="fr.rolandgarros.model.*" %>
<%@ page import="fr.rolandgarros.model.Double" %>
<%@ page import="java.util.List" %>

<%
    Match match = (Match) request.getAttribute("match");
    List<Court> courts = (List<Court>) request.getAttribute("courts");
    String matchType = (String) request.getAttribute("matchType");

    Object _error = session.getAttribute("tempUpdateError");
    boolean error = (_error != null) && (boolean) _error;
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
        <h2 class="txt-center no-margin">Mise à jour du match</h2>

        <form class="flex-column gap-1" method="post">
            <div class="flex-row gap-1">
                <div class="flex-column justify-start items-center padding-1 gap-1">
                    <h3 class="no-margin">Modalités</h3>

                    <input type="hidden" name="matchId" value="<%= match.getIdT() %>" />

                    <label>Catégorie</label>
                    <input type="text" disabled="disabled" value="<%= request.getAttribute("matchType") %>" />

                    <label>Genre</label>
                    <input type="text" disabled="disabled" value="<%= match.getGender().equals(Gender.MALE) ? "Homme" : "Femme" %>" />

                    <label for="matchCourt">Court</label>
                    <select class="self-stretch" name="matchCourt" id="matchCourt" required="required">
                        <% for (Court court : courts) { %>
                        <% if (court.equals(match.getCourt())) { %>
                        <option value="<%= court.getIdC() %>" selected="selected"><%= court %></option>
                        <% } else { %>
                        <option value="<%= court.getIdC() %>"><%= court %></option>
                        <% } %>
                        <% } %>
                    </select>

                    <label for="matchStartDate">Date et heure de début</label>
                    <input type="datetime-local" name="matchStartDate" id="matchStartDate" required="required" value="<%= Utils.dateFormatHTMLInput.format(match.getStartDate()) %>" />
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

            <button class="btn-blue" type="submit">Valider</button>
        </form>
    </article>
</main>

<%@ include file="../Template/footer.jsp" %>
</body>
</html>