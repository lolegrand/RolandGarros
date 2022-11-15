<%@ page import="fr.rolandgarros.model.Role" %>
<%
    Role role = (Role) request.getSession().getAttribute("role");
    boolean isPlayerEditor = role != null && (role.equals(Role.PLAYER_EDITOR) || role.equals(Role.ADMINISTRATOR));

    String display = request.getParameter("displayPlayer");
    String create = request.getParameter("createPlayer");
    String update = request.getParameter("updatePlayer");

    if ( create == null && request.getAttribute("formToCreatePlayer") != null ){
        create = request.getAttribute("formToCreatePlayer").toString();
    }

    boolean displayMore = display != null && display.equals("Détails");
    boolean formToCreatePlayer = create != null && create.equals("Nouveau Joueur");
    boolean formToUpdatePlayer = update != null && update.equals("Modifier");

    int addedPlayer = request.getIntHeader("addedPlayer");
%>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<main class="w-100 row space-around">

    <% if ( isPlayerEditor ){ %>
    <nav class="nav w-100 row space-between">
        <form method="post" name="formNavPlayer">
            <input class="" type="submit" name="createPlayer" value="Nouveau Joueur">
        </form>

        <% if (addedPlayer != -1) {%>
        <p>
            Vous avez ajouté <%= addedPlayer%> joueur.
        </p>
        <% } %>

        <form method="post" name="fromUploadCSV" enctype="multipart/form-data">
            File :
            <input type="file" name="file" id="file"/>
            <input type="submit" value="Upload" name="upload" id="upload" />
        </form>
    </nav>
    <% } %>

    <% if( !formToCreatePlayer && !formToUpdatePlayer){ %>
        <%@ include file="/ViewPlayer/DisplayPlayers.jsp" %>
        <% if( displayMore ){ %>
            <%@ include file="/ViewPlayer/InfoPlayer.jsp" %>
        <% } %>
    <% } %>

    <% if( formToCreatePlayer ) { %>
        <%@ include file="/ViewPlayer/CreatePlayer.jsp" %>
    <% } %>

    <% if( formToUpdatePlayer) { %>
        <%@ include file="/ViewPlayer/UpdatePlayer.jsp" %>
    <% } %>
</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>