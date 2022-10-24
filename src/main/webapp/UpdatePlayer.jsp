<!--
    Update of:
        - weight
        - height
        - rank
    No more, everything else is considered as true so to read only
-->
<article class="w-50 row self-center space-around" id="articleUpdatePlayer">

    <% String errorMsg = "BOUYAAAAAH"; %>

    <form class="row space-around" method="post" name="formUpdatePlayer">
        <h2 class="w-100 txt-center">Mise à jour d'une fiche joueur</h2>

        <label class="w-25">Prénom</label>
        <input readonly class="w-75" type="text" name="firstname" value="${player.getFirstname()}">

        <label class="w-25">Nom</label>
        <input readonly class="w-75" type="text" name="lastname" value="${player.getLastname()}">

        <label class="w-25">Date de naissance</label>
        <input readonly class="w-25" type="date" name="birthday">

        <label class="w-25">Lieu de naissance</label>
        <input readonly class="w-25" type="text" name="birthplace" value="${player.getBirthplace()}">

        <label class="w-25">Nationalité</label>
        <input readonly class="w-25" type="text" name="nationality" value="${player.getNationality()}">

        <label class="w-25">Taille</label>
        <input readonly class="w-25" type="number" min="050" max="500" name="size" value="${player.getHeight()}">
        <p class="w-50"><%= errorMsg %></p>

        <label class="w-25">Poids</label>
        <input readonly class="w-25" type="number" min="0.0" max="500.0" name="pound" value="${player.getWeight()}">
        <p class="w-50"><%= errorMsg %></p>

        <label class="w-25">Classement en Simple</label>
        <input required class="w-25" type="number" min="0" name="ranking" value="${player.getRanking()}">
        <p class="w-50"><%= errorMsg %></p>

        <label class="w-25">Classement en Simple</label>
        <input readonly class="w-25" type="text" name="hand" value="${player.getHand()}">

        <label class="w-25">Début de carrière</label>
        <input readonly class="w-25" type="date" name="careerStart">

        <label class="w-25">Entraîneur</label>
        <input readonly class="w-25" type="text" name="hand" value="${player.getTrainer()}">

        <input class="btn-blue w-25" type="submit" name="submitFormUpdatePlayer" value="Mettre à jour">
    </form>

</article>