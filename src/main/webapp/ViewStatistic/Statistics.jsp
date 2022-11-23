<%@ page import="java.util.List,fr.rolandgarros.model.Player" %>
<%@ page import="java.util.Map" %>

<%
  List<Player> players = (List<Player>) request.getAttribute("players");
  List<Map.Entry<Player, Float>> playerSorted = (List<Map.Entry<Player, Float>>) request.getAttribute("playerSorted");
  String sortName = (String) request.getAttribute("sortName");
  String sortGender = (String) request.getAttribute("genderStr");
  if (sortGender == null) {
    sortGender = "Mixe";
  }

%>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<!-- search criteria -->

<nav class="nav w-100 row space-between align-center border-top-0">
  <h2>Critères de tri</h2>

  <form class="flex-grow row justify-end gap-1" method="post">
    <div class="row items-center gap-1">
      <input type="radio" name="Gender" value="Male" id="Male"
             <% if (sortGender.equals("Male")) { %> checked="checked" <% }%>
      />
      <label for="Male">Homme</label>

      <input type="radio" name="Gender" value="Female" id="Female"
              <% if (sortGender.equals("Female")) { %> checked="checked" <% }%>
      />
      <label for="Female">Femme</label>

      <input type="radio" name="Gender" value="Mixe" id="Mixed"
              <% if (sortGender.equals("Mixe")) { %> checked="checked" <% }%>/>
      <label for="Mixed">Mixte</label>
    </div>

    <div class="row gap-1">
      <div class="row items-center gap-1">
        <input type="radio" name="Sort" value="Victories" id="Victories" />
        <label for="Victories">Nombre de victoires</label>
      </div>

      <div class="row items-center gap-1">
        <input type="radio" name="Sort" value="TotalGameDuration" id="TotalGameDuration" />
        <label for="TotalGameDuration">Temps de jeu total</label>
      </div>

      <div class="row gap-1">
        <input class="btn-dark" type="submit" name="submitFormStatistics" value="Trier" />
      </div>
    </div>

  </form>

</nav>

<!-- Players list diplayed -->

<main class="w-100 row space-around">

  <article class="w-100 row">

    <table class="w-100">
      <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Sexe</th>
        <% if (sortName != null) {%><th><%=sortName%></th><% } %>
        <th>Classement</th>
      </tr>

      <% if (playerSorted == null) { %>
        <% for (Player player: players) { %>

          <tr class="tr-hover">
            <td><%=player.getLastname()%></td>
            <td><%=player.getFirstname()%></td>
            <td><%=player.getGender()%></td>
            <td><%=player.getRanking()%></td>
          </tr>

        <% } %>
      <% } else { %>
        <% for (Map.Entry<Player, Float> playerTuple: playerSorted) {
          Player player = playerTuple.getKey();
          Float value = playerTuple.getValue();
        %>
        <tr class="tr-hover">
          <td><%=player.getLastname()%></td>
          <td><%=player.getFirstname()%></td>
          <td><%=player.getGender()%></td>
          <td><%=value%> <% if (sortName.equals("TotalGameDuration")) { %> h <% } %></td>
          <td><%=player.getRanking()%></td>
        </tr>
        <% } %>
      <% } %>

    </table>

  </article>

</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>