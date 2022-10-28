<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header class="w-100 row">

    <ul class="nav w-100 row self-center space-around">
        <li><a href="/">Accueil</a></li>
        <li><a href="/Players">Joueurs</a></li>
        <li><a href="/Matchs">Matchs</a></li>
        <li><a href="/Trainings">Entraînements</a></li>
        <li><a href="/Statistics">Statistiques</a></li>

        <% if ( session.getAttribute("login") == null ) { %>
        <li><a href="/Connection">Connexion</a></li>
        <% } else { %>
        <li><a href="/Disconnection">Déconnexion</a></li>
        <% } %>
    </ul>

</header>