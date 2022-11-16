<%@ page import="java.util.List,fr.rolandgarros.model.Player" %>

<%

  List<Player> players = (List<Player>) request.getAttribute("players");
  boolean isAdmin = role == Role.ADMINISTRATOR;

%>
<article class="row scrollable space-around self-center">

  <h1 class="w-100 txt-center">Liste des joueurs participants au tournois</h1>

  <table class="w-100">

    <% for (Player player: players) { %>

    <tr class="tr-noBorder tr-hover">

      <td class="td-none"><%=player.getLastname()%></td>
      <td class="td-none"><%=player.getFirstname()%></td>
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
          <input class="btn-red" type="submit" name="deletePlayer" value="Supprimer" onclick="return confirm('Confirmer la suppression ?')">
        </form>
      </td>

      <% } %>

    </tr>
    <% } %>
  </table>

</article>
