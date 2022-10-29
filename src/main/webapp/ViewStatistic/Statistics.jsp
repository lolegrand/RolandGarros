<%@ page import="java.util.List,fr.rolandgarros.model.Player" %>

<% List<Player> players = (List<Player>) request.getAttribute("players"); %>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<!-- search criteria -->

<nav class="nav w-100 row space-between">

  <h2 class="w-25">Critères de tri</h2>

  <form class="w-75 row space-between" method="post">

    <div class="w-33 row space-around">
      <input class="self-center" type="radio" name="Gender" value="Male">
      <label class="self-center w-25">Homme</label>

      <input class="self-center" type="radio" name="Gender" value="Female">
      <label class="self-center w-25">Femme</label>

      <input class="self-center" type="radio" name="Gender" value="None">
      <label class="self-center w-25">Mixte</label>
    </div>

    <div class="w-66 row space-around">
      <div class="w-33 row">
        <input class="self-center" type="checkbox" name="Victories">
        <label class="self-center w-75">Nombre de victoires</label>
      </div>

      <div class="w-33 row">
        <input class="self-center" type="checkbox" name="TotalGameDuration">
        <label class="self-center w-75">Temps de jeu total</label>
      </div>

      <div class="w-33 row space-around">
        <input class="btn-dark" type="submit" name="Bouyah" value="Trier">
      </div>
    </div>

  </form>

</nav>

<!-- Players list diplayed -->

<main class="w-100 row space-around">

  <article class="w-75 row">

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