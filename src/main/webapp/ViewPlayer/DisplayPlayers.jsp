<%@ page import="java.util.List,fr.rolandgarros.model.Player" %>

<%

  List<Player> players = (List<Player>) request.getAttribute("players");

  boolean isAdmin = role != null && role.equals("Admin");

%>

<table class="w-100">

  <tr>

    <th>Nom</th>
    <th>Prénom</th>
    <th class="td-none"></th>
    <% if ( isPlayerEditor ) { %><th class="td-none"></th><% } %>
    <% if ( isAdmin ) { %><th class="td-none"></th><% } %>

  </tr>

  <% for (Player player: players) { %>

  <tr class="tr-hover">

    <td><%=player.getLastname()%></td>
    <td><%=player.getFirstname()%></td>
    <td class="td-none">
      <form method="post" name="FormToSeePlayer">
        <input type="hidden" name="playerLastname" value="<%=player.getLastname()%>"/>
        <input type="hidden" name="playerFirstname" value="<%=player.getFirstname()%>"/>
        <input class="btn-dark" type="submit" name="displayPlayer" value="Détails"/>
      </form>
    </td>

    <% if ( isPlayerEditor ) { %>

    <td class="td-none">
      <form method="post" name="FormToUpdatePlayer">
        <input type="hidden" name="playerLastname" value="<%=player.getLastname()%>"/>
        <input type="hidden" name="playerFirstname" value="<%=player.getFirstname()%>"/>
        <input class="btn-blue" type="submit" name="updatePlayer" value="Modifier"/>
      </form>
    </td>

    <% } %>

    <% if( isAdmin ){ %>

    <td class="td-none">
      <form method="post" name="FormToDeletePlayer">
        <input type="hidden" name="playerLastname" value="<%=player.getLastname()%>"/>
        <input type="hidden" name="playerFirstname" value="<%=player.getFirstname()%>"/>
        <input class="btn-red" type="submit" name="deletePlayer" value="Supprimer"/>
      </form>
    </td>

    <% } %>

  </tr>

  <% } %>
</table>
