<article class="w-50 row self-center space-around" id="articleCreateTraining">

  <form class="row space-around" method="post" name="formCreateTraining">
    <h2 class="w-100 txt-center">Nouvel entrainement</h2>

    <label class="w-25">Cours</label>
    <select required class="w-75" name="coaches">
      <% foreach ( Court court : courts ){ %>
      <option value="<% court; %>"><% court; %></option>
      <% } %>
    </select>

    <label class="w-25">Horaire</label>
    <select required class="w-75" name="coaches">
      <% foreach ( Schedule schedule : schedules ){ %>
      <option value="<% schedule; %>"><% schedule; %></option>
      <% } %>
    </select>

    <!--
      Est-ce que l'on considère l'id de l'entraineur comme suffisant pour un entrainement ?
      Ou estimons-nous que l'entrainement est l'exacte réplique du match dans son fonctionnement ?
     -->

    <input required class="btn-blue w-25" type="submit" name="submitFormCreateTraining">
  </form>

</article>