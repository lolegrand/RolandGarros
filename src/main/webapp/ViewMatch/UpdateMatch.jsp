<%@ page import="fr.rolandgarros.model.Court" %>
<%@ page import="fr.rolandgarros.model.Match" %>
<%@ page import="fr.rolandgarros.model.Single" %>
<%@ page import="fr.rolandgarros.model.Double" %>
<%@ page import="java.util.List" %>

<%
    Match match = (Match) request.getAttribute("match");
    List<Court> courts = (List<Court>) request.getAttribute("courts");
%>

<%@ include file="../Template/head.jsp" %>

<body class="column">
<%@ include file="../Template/header.jsp" %>

<main>
    <article class="content">
        <h2 class="w-100 txt-center">Mise à jour du match</h2>

        <form class="row space-around" method="post" name="formUpdateMatch">
            <h3 class="w-100">Modalités</h3>

            <input type="hidden" name="matchId" value="<%= match.getIdT() %>" />

            <label class="w-25">Simple ou Double</label>
            <p class="w-75"><%= request.getAttribute("matchType") %></p>
            <p class="w-75"><%= match.getGender() %></p>

            <label class="w-25" for="court">Court</label>
            <select class="w-75" name="court" id="court" required="required">
                <% for (Court court : courts) { %>
                <% if (match.getCourt().equals(court)) { %>
                <option value="<%= court %>" selected="selected"><%= court %></option>
                <% } %>
                <% else { %>
                <option value="<%= court %>"><%= court %></option>
                <% } %>
                <% } %>
            </select>

            <label class="w-25" for="startDate">Horaire</label>
            <input type="datetime-local" name="startDate" id="startDate" required="required" value="<%= match.getStartDate().toString().substring(0, 16) %>" />

            <h3 class="w-100">Participants</h3>

            <% if (request.getAttribute("typeMatch").equals("Simple")) {
                Single matchSingle = (Single) match; %>
            <label class="w-25">Participant 1</label>
            <p class="w-75"><%= matchSingle.getPlayerOne() %></p>

            <label class="w-25">Participant 2</label>
            <p class="w-75"><%= matchSingle.getPlayerTwo() %></p>
            <% } %>

            <% if (request.getAttribute("typeMatch").equals("Double")) {
                Double matchDouble = (Double) match; %>
            <p class="w-100">Équipe 1</p>

            <label class="w-25">Participant 1</label>
            <p class="w-75"><%= matchDouble.getTeamOnePlayerOne() %></p>

            <label class="w-25">Participant 2</label>
            <p class="w-75"><%= matchDouble.getTeamOnePlayerTwo() %></p>

            <p class="w-100">Équipe 2</p>

            <label class="w-25">Participant 1</label>
            <p class="w-75"><%= matchDouble.getTeamTwoPlayerOne() %></p>

            <label class="w-25">Participant 2</label>
            <p class="w-75"><%= matchDouble.getTeamTwoPlayerTwo() %></p>
            <% } %>

            <button class="btn-blue" type="submit">
                Mettre à jour
            </button>
        </form>
    </article>
</main>

<%@ include file="../Template/footer.jsp" %>
</body>
</html>