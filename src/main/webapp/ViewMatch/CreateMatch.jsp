<%@ page import="fr.rolandgarros.model.Role" %>
<%
    Role role = (Role) request.getSession().getAttribute("role");
    boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;

    Object _error = session.getAttribute("tempCreationError");
    boolean error = (boolean) (_error != null) && (boolean) _error;
    String matchCreationStep = (String) session.getAttribute("matchCreationStep");
%>

<%@ include file="../Template/head.jsp" %>

<body class="flex-column">
<%@ include file="../Template/header.jsp" %>

<main class="flex-column">
    <% if (error) { %>
    <p class="btn-red">
        Erreur dans votre formulaire, veuillez recommencer
    </p>
    <% } %>

    <% if (matchCreationStep == null) { %>
    <%@ include file="../ViewMatch/CreateMatchModality.jsp" %>
    <% } else { %>
    <%@ include file="../ViewMatch/CreateMatchPlayers.jsp" %>
    <% } %>
</main>

<%@ include file="../Template/footer.jsp" %>
</body>
</html>