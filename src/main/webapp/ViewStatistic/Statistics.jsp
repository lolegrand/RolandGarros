<%@ page import="java.util.List,fr.rolandgarros.model.Player" %>

<% List<Player> players = (List<Player>) request.getAttribute("players"); %>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<!-- search criteria -->

<nav class="nav w-100 row space-between align-center border-top-0">
  <h2>Critères de tri</h2>

  <form class="flex-grow row justify-end gap-1" method="post">
    <div class="row items-center gap-1">
      <input type="radio" name="Gender" value="Male" id="Male" />
      <label for="Male">Homme</label>

      <input type="radio" name="Gender" value="Female" id="Female" />
      <label for="Female">Femme</label>

      <input type="radio" name="Gender" value="None" id="Mixed" />
      <label for="Mixed">Mixte</label>
    </div>

    <div class="row gap-1">
      <div class="row items-center gap-1">
        <input type="checkbox" name="Victories" id="Victories" />
        <label for="Victories">Nombre de victoires</label>
      </div>

      <div class="row items-center gap-1">
        <input type="checkbox" name="TotalGameDuration" id="TotalGameDuration" />
        <label for="TotalGameDuration">Temps de jeu total</label>
      </div>

      <div class="row gap-1">
        <input class="btn-dark" type="submit" name="Bouyah" value="Trier" />
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
        <th>Temps de jeu</th>
        <th>Nombre de Victoire</th>
        <th>Classement</th>
      </tr>

      <% for (Player player: players) { %>

        <tr class="tr-hover">
          <td><%=player.getLastname()%></td>
          <td><%=player.getFirstname()%></td>
          <td><%=player.getGender()%></td>
          <td>xxx</td>
          <td>xxx</td>
          <td><%=player.getRanking()%></td>
        </tr>

      <% } %>

    </table>

  </article>

</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>