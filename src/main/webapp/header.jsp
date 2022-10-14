<header class="w-100 row">

    <ul class="nav w-100 row self-center space-around">
        <li><a href="./index.jsp">Accueil</a></li>
        <li><a href="./FicheJoueur.jsp">Joueurs</a></li>
        <li><a href="./Tournois.jsp">Tournois</a></li>
        <li><a href="./Matchs.jsp">Matchs</a></li>
        <li><a href="./Entrainements.jsp">Entraînements</a></li>
        <li><a href="./Statistiques.jsp">Statistiques</a></li>

        <% if ( true ) { %>
        <li><a href="./Connexion.jsp">Connexion</a></li>
        <% } else { %>
        <li><a href="./Deconnexion.jsp">Déconnexion</a></li>
        <% } %>
    </ul>

</header>