<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header class="w-100 row">

    <ul class="nav w-100 row self-center space-around">
        <li><a href="./index.jsp">Accueil</a></li>
        <li><a href="./PlayerCard.jsp">Joueurs</a></li>
        <li><a href="./Tournament.jsp">Tournois</a></li>
        <li><a href="./Matchs.jsp">Matchs</a></li>
        <li><a href="./Trainings.jsp">Entraînements</a></li>
        <li><a href="./Statistics.jsp">Statistiques</a></li>

        <% if ( session.getAttribute("login") == null ) { %>
        <li><a href="/Connection">Connexion</a></li>
        <% } else { %>
        <li><a href="./Deconnexion.jsp">Déconnexion</a></li>
        <% } %>
    </ul>

</header>