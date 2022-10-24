<%@ include file="head.jsp" %>

<body class="w-100 row">

<%@ include file="header.jsp" %>

<main class="w-100 row">


    <!--
        By default, display the player
        - if there is a session, then a role playerEditor or admin, display an update button
        - if there is a session, then a role admin, display a delete button
    -->
    <c:foreach items="${players}" var="player">

        <input class="w-50" name="see${player}" value="${player}"/>

        <% if( request.getSession().getAttribute("role").equals("PlayerEditor")
                || request.getSession().getAttribute("role").equals("Admin") )
        { %>
        <input class="w-25 btn-dark" type="submit" name="update${player}" value="Modifier"/>
        <% } %>

        <% if( request.getSession().getAttribute("role").equals("Admin") ){ %>
        <input class="w-25 btn-red" type="submit" name="delete${player}" value="Supprimer"/>
        <% } %>

    </c:foreach>

    <!--
        if role == playerEditor || role == admin :
            - be able to create a player
    -->

    <% if( request.getSession().getAttribute("role").equals("PlayerEditor")
            || request.getSession().getAttribute("role").equals("Admin") )
    { %>
    <%@ include file="CreatePlayer.jsp" %>
    <% } %>

    <!--
        if updatePlayer:
            - be able to update a player
    -->

    <% if( request.getAttribute("updatePlayer").equals("PlayerName") ){ %>
    <%@ include file="UpdatePlayer.jsp" %>
    <% } %>

</main>

<%@ include file="footer.jsp" %>

</body>

</html>