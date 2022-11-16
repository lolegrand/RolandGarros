<%@ page import="fr.rolandgarros.model.Player" %>
<%@ page import="java.util.List" %>
<%
  String matchType = (String) request.getAttribute("matchType");
  List<Player> players = (List<Player>) request.getAttribute("players");
%>

<article>
  <form class="flex-column gap-1" method="post">
    <h2 class="txt-center no-margin">Nouveau match - Participants</h2>

    <% if (matchType.equals("Simple")) { %>
    <label for="player1">Participant 1</label>
    <select name="player1" id="player1">
      <% for (Player player : players) { %>
      <option value="<%= player.getId() %>"><%= player %></option>
      <% } %>
    </select>

    <label for="player2">Participant 2</label>
    <select name="player2" id="player2">
      <% for (Player player : players) { %>
      <option value="<%= player.getId() %>"><%= player %></option>
      <% } %>
    </select>
    <% } %>

    <% if (matchType.equals("Double")) { %>
    <label class="w-100">Équipe 1</label>

    <label for="team1player1">Participant 1</label>
    <select name="team1player1" id="team1player1">
      <% for (Player player : players) { %>
      <option value="<%= player.getId() %>"><%= player %></option>
      <% } %>
    </select>

    <label for="team1player2">Participant 2</label>
    <select name="team1player2" id="team1player2">
      <% for (Player player : players) { %>
      <option value="<%= player.getId() %>"><%= player %></option>
      <% } %>
    </select>

    <label class="w-100">Équipe 2</label>

    <label for="team2player1">Participant 1</label>
    <select name="team2player1" id="team2player1">
      <% for (Player player : players) { %>
      <option value="<%= player.getId() %>"><%= player %></option>
      <% } %>
    </select>

    <label for="team2player2">Participant 2</label>
    <select name="team2player2" id="team2player2">
      <% for (Player player : players) { %>
      <option value="<%= player.getId() %>"><%= player %></option>
      <% } %>
    </select>
    <% } %>

    <input type="hidden" name="step" value="createMatchPlayers" />
    <button class="btn-blue" type="submit">Valider</button>
  </form>

  <form class="flex-column gap-1" method="post">
    <input type="hidden" name="step" value="cancelMatchCreation" />
    <button class="btn-red" type="submit">Annuler</button>
  </form>
</article>