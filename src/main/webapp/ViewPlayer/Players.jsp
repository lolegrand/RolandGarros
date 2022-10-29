<%
    // String role = (String) request.getSession().getAttribute("role");
    String role = "PlayerEditor";

    boolean isPlayerEditor = role != null && (role.equals("PlayerEditor") || role.equals("Admin"));

    String display = request.getParameter("displayPlayer");
    String create = request.getParameter("createPlayer");
    String update = request.getParameter("updatePlayer");

    boolean displayMore = display != null && display.equals("Détails");
    boolean formToCreatePlayer = create != null && create.equals("Nouveau Joueur");
    boolean formToUpdatePlayer = update != null && update.equals("Modifier");

%>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<main class="w-100 row space-around">

    <% if ( isPlayerEditor ){ %>
    <nav class="nav w-100 row space-between">
        <form method="post" name="formNavPlayer">
            <input class="" type="submit" name="FormToCreatePlayer" value="Nouveau Joueur">
        </form>
    </nav>
    <% } %>

    <% if( !formToCreatePlayer && !formToUpdatePlayer){ %>
        <%@ include file="DisplayPlayers.jsp" %>
        <% if( displayMore ){ %>
            <%@ include file="InfoPlayer.jsp" %>
        <% } %>
    <% } %>

    <% if( formToCreatePlayer ) { %>
        <%@ include file="CreatePlayer.jsp" %>
    <% } %>

    <% if( formToUpdatePlayer) { %>
        <%@ include file="UpdatePlayer.jsp" %>
    <% } %>

</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>