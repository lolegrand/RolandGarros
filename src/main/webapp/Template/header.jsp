<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header class="w-100 row">
    <nav class="nav w-100 row self-center space-around">
        <a href="/">Accueil</a>
        <a href="/Players">Joueurs</a>
        <a href="/Matches">Matchs</a>
        <a href="/Trainings">Entrainements</a>
        <a href="/Statistics">Statistiques</a>

        <% if ( session.getAttribute("login") == null ) { %>
        <a href="/Connection">Connexion</a>
        <% } else { %>
        <a href="/Disconnection">Déconnexion</a>
        <% } %>
    </nav>

</header>