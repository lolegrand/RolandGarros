<%@ page import="java.util.List,fr.rolandgarros.model.Player" %>
<%
    List<Player> players = (List<Player>) request.getAttribute("players");
%>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<main class="w-100 row">
    <%
        String role = (String) request.getSession().getAttribute("role");
        boolean isPlayerEditor = role != null && (role.equals("PlayerEditor") || role.equals("Admin"));
        boolean isAdmin = role != null && role.equals("Admin");
    %>

    <!--
        By default, display the player
        - if there is a session, then a role playerEditor or admin, display an update button
        - if there is a session, then a role admin, display a delete button
    -->
    <%
        for (Player player: players) {
    %>
        <input class="w-50" name="see<%=player.getLastname()%>" value="<%=player.getFirstname()%> <%=player.getLastname()%>"/>
        <%
            if ( isPlayerEditor ) {
        %>
        <input class="w-25 btn-dark" type="submit" name="update${player}" value="Modifier"/>
        <% } %>

        <% if( isAdmin ){ %>
        <input class="w-25 btn-red" type="submit" name="delete${player}" value="Supprimer"/>
        <% } %>
    <%
        }
    %>

    <!--
        if role == playerEditor || role == admin :
            - be able to create a player
    -->
    <%
        if( isPlayerEditor ) {
    %>
    <%@ include file="/ViewPlayer/CreatePlayer.jsp" %>
    <% } %>

    <!--
        if updatePlayer:
            - be able to update a player
    -->
    <%
        String updatePlayer = (String) request.getAttribute("updatePlayer");
        if( updatePlayer != null && updatePlayer.equals("PlayerName") ) {
    %>
    <%@ include file="/ViewPlayer/UpdatePlayer.jsp" %>
    <% } %>

</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>