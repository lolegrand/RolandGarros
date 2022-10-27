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
        <p class="w-75">${player.getFirstname()}</p>

        <label class="w-25">Nom</label>
        <p class="w-75">${player.getLastname()}</p>

        <label class="w-25">Date de naissance</label>
        <p class="w-75">${player.getBirthdate()}</p>

        <label class="w-25">Lieu de naissance</label>
        <p class="w-75">${player.getBirthplace()}</p>

        <label class="w-25">Nationalité</label>
        <p class="w-75">${player.getNationality()}</p>

        <!-- To update -->

        <label class="w-25">Taille</label>
        <input required class="w-25" type="number" min="050" max="500" name="size" value="${player.getHeight()}">
        <p class="w-50"><%= errorMsg %></p>

        <label class="w-25">Poids</label>
        <input required class="w-25" type="number" min="0.0" max="500.0" name="pound" value="${player.getWeight()}">
        <p class="w-50"><%= errorMsg %></p>

        <label class="w-25">Classement en Simple</label>
        <input required class="w-25" type="number" min="0" name="ranking" value="${player.getRanking()}">
        <p class="w-50"><%= errorMsg %></p>

        <!--  -->

        <label class="w-25">Classement en Simple</label>
        <p class="w-75">${player.getHand()}</p>

        <label class="w-25">Début de carrière</label>
        <p class="w-75">${player.getCareerStart()}</p>

        <label class="w-25">Entraîneur</label>
        <p class="w-75">${player.getTrainer()}</p>

        <input class="btn-blue w-25" type="submit" name="submitFormUpdatePlayer" value="Mettre à jour">
    </form>

</article>