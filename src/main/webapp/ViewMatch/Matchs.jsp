<%
    String role = (String) request.getSession().getAttribute("role");

    boolean isMatchEditor = role != null && (role.equals("MatchEditor") || role.equals("Admin"));

    String display = request.getParameter("displayMatch");
    String create = request.getParameter("createMatch");
    String update = request.getParameter("updateMatch");

    boolean displayMore = display != null && display.equals("Détails");
    boolean formToCreateMatch = create != null && create.equals("Nouveau Joueur");
    boolean formToUpdateMatch = update != null && update.equals("Modifier");

%>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<main class="w-100 row space-around">

    <% if ( isMatchEditor ){ %>
    <nav class="nav w-100 row space-between">
        <form method="post" name="formNavMatch">
            <input class="" type="submit" name="FormToCreateMatch" value="Nouveau Joueur">
        </form>
    </nav>
    <% } %>

    <% if( !formToCreateMatch && !formToUpdateMatch){ %>
    <%@ include file="DisplayMatches.jsp" %>
    <% if( displayMore ){ %>
    <%@ include file="InfoMatch.jsp" %>
    <% } %>
    <% } %>

    <% if( formToCreateMatch ) { %>
    <%@ include file="CreateMatch.jsp" %>
    <% } %>

    <% if( formToUpdateMatch) { %>
    <%@ include file="UpdateMatch.jsp" %>
    <% } %>

</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>
