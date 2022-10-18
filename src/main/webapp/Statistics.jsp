<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

  <%@ include file="head.jsp" %>

  <body class="w-100 row">

    <%@ include file="header.jsp" %>

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

        <table>
          <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Sexe</th>
            <th>Temps de jeu</th>
            <th>Nombre de Victoire</th>
            <th>Classement</th>
          </tr>
          <c:foreach items="players" var="player">
            <tr class="tr-hover">
              <c:foreach items="items" var="item">
                <td>${item}</td>
              </c:foreach>
            </tr>
          </c:foreach>
        </table>

      </article>

    </main>

    <%@ include file="footer.jsp" %>

  </body>

</html>