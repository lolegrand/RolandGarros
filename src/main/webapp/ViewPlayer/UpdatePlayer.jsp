<%
    Player player = (Player) request.getAttribute("updatedPlayer");

    String errorMsg = "";

    if ( request.getAttribute("UpdatePlayerError") != null ) {
        errorMsg = request.getAttribute("UpdatePlayerError").toString();
    }

    if ( player != null ) {
        Person trainer = player.getTrainer();
%>
<article class="w-50 row self-center space-around" id="articleUpdatePlayer">

    <form class="row space-around items-center" method="post" name="formUpdatePlayer">
        <h2 class="w-100 txt-center">Mise à jour d'une fiche joueur</h2>

        <label class="w-25">Prénom</label>
        <p class="w-75"><%= player.getFirstname() %></p>

        <label class="w-25">Nom</label>
        <p class="w-75"><%= player.getLastname() %></p>

        <label class="w-25">Date de naissance</label>
        <p class="w-75"><%= player.getBirthDate() %></p>

        <label class="w-25">Lieu de naissance</label>
        <p class="w-75"><%= player.getBirthPlace() %></p>

        <label class="w-25">Nationalité</label>
        <p class="w-75"><%= player.getNationality() %></p>

        <label class="w-25">Taille</label>
        <p class="w-75"><%= player.getHeight() %></p>

        <!-- Updatable items : weight and ranking -->

        <label class="w-25">Poids</label>
        <input required class="w-75" type="number" min="0.0" max="500.0" name="weight" value="<%= player.getWeight() %>">
        <p class="w-100 txt-right error"><%= errorMsg %></p>

        <label class="w-25">Classement en Simple</label>
        <input required class="w-75" type="number" min="0" name="ranking" value="<%= player.getRanking() %>">
        <p class="w-100 txt-right error"><%= errorMsg %></p>

        <!-- End of updatable items -->

        <label class="w-25">Classement en Simple</label>
        <p class="w-75"><%= player.getHand() %></p>

        <label class="w-25">Début de carrière</label>
        <p class="w-75"><%= player.getStartCareer() %></p>

        <label class="w-25">Entraîneur</label>
        <p class="w-75"><%= trainer.getLastname() %> <%= trainer.getFirstname() %></p>

        <input class="btn-blue w-25" type="submit" name="submitFormUpdatePlayer" value="Mettre à jour">
    </form>

</article>

<% } %>