<article class="w-50 row self-center space-around" id="articleCreatePlayer">

  <form class="row space-around" method="post" name="formCreatePlayer">
    <h2 class="w-100 txt-center">Nouvelle fiche joueur</h2>

    <label class="w-25">Prénom</label>
    <input required class="w-75" type="text" name="firstname" placeholder="Prénom">

    <label class="w-25">Nom</label>
    <input required class="w-75" type="text" name="lastname" placeholder="NOM">

    <label class="w-25">Date de naissance</label>
    <input required class="w-25" type="date" name="birthday">

    <p class="w-50"><% errorMsg; %></p>

    <label class="w-25">Lieu de naissance</label>
    <input required class="w-25" type="text" name="birthplace" placeholder="Lieu de naissance">

    <p class="w-50"><% errorMsg; %></p>

    <label class="w-25">Nationalité</label>
    <input required class="w-25" type="text" name="nationality" placeholder="Nationalité">

    <p class="w-50"><% errorMsg; %></p>

    <label class="w-25">Taille</label>
    <input required class="w-25" type="number" min="050" max="500" name="size" placeholder="170">

    <p class="w-50"><% errorMsg; %></p>

    <label class="w-25">Poids</label>
    <input required class="w-25" type="number" min="0.0" max="500.0" name="pound" placeholder="65.7">

    <p class="w-50"><% errorMsg; %></p>

    <label class="w-25">Classement en Simple</label>
    <input required class="w-25" type="number" min="0" name="ranking" placeholder="1">

    <p class="w-50"><% errorMsg; %></p>

    <div class="w-100 row space-around">
      <input required class="self-center" type="radio" name="hand" id="rightHand">
      <label class="self-center">Droitier</label>
      <input required class="self-center" type="radio" name="hand" id="leftHand">
      <label class="self-center">Gaucher</label>
      <input required class="self-center" type="radio" name="hand" id="bothHand">
      <label class="self-center">Ambidextre</label>
    </div>

    <label class="w-25">Début de carrière</label>
    <input required class="w-25" type="date" name="careerStart">

    <p class="w-50"><% errorMsg; %></p>

    <label class="w-25">Entraîneur</label>
    <select required class="w-75" name="coaches">
      <% foreach ( coaches as coach ) { %>
      <option value="<% coach; %>"></option>
      <% } %>
    </select>

    <input required class="btn-blue w-25" type="submit" name="submitFormCreatePlayer">
  </form>

</article>