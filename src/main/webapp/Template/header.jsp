<%@ page import="fr.rolandgarros.model.Role" %>


<%
    Role roles = (Role) request.getSession().getAttribute("role");
    boolean isAdministrator = roles == Role.ADMINISTRATOR;
%>

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
        <li><a href="/Disconnection" onclick="return confirm('Voulez-vous vous déconnecter ?')">Déconnexion</a></li>
        <% } %>

        <% if ( isAdministrator ) { %>
        <li><a href="/Account">Manage Account</a></li>
        <% } %>

    </ul>

</header>