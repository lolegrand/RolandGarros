<%@ page import="fr.rolandgarros.model.Court" %>
<%@ page import="java.util.List" %>
<%
  List<Court> courts = (List<Court>) request.getAttribute("courts");
%>

<article>
  <h2 class="txt-center no-margin">Nouveau match - Informations générales</h2>

  <form class="flex-column gap-1" method="post">
    <div class="flex-column justify-stretch gap-1">
      <h3 class="no-margin">Simple ou Double</h3>
      <div class="flex-row gap-1">
        <input type="radio" name="matchType" value="Simple" id="simple" required="required" />
        <label for="simple">Simple</label>

        <input type="radio" name="matchType" value="Double" id="double" required="required" />
        <label for="double">Double</label>
      </div>
    </div>

    <div class="flex-column justify-stretch gap-1">
      <h3 class="no-margin">Homme ou Femme</h3>
      <div class="flex-row gap-1">
        <input type="radio" name="matchGender" value="Male" id="male" required="required" />
        <label for="male">Homme</label>

        <input type="radio" name="matchGender" value="Female" id="female" required="required" />
        <label for="female">Femme</label>
      </div>
    </div>

    <div class="flex-column justify-stretch gap-1">
      <h3 class="no-margin">Court</h3>
      <select name="matchCourt" required="required">
        <% for (Court court : courts) { %>
        <option value="<%= court.getIdC() %>"><%= court.getName() %></option>
        <% } %>
      </select>
    </div>

    <div class="flex-column justify-stretch gap-1">
      <h3 class="no-margin">Date et heure de début</h3>

      <div class="flex-row gap-1">
        <input type="datetime-local" name="matchStartDate" id="startDate" required="required" />
      </div>
    </div>

    <hr class="w-100" />

    <input type="hidden" name="step" value="createMatchModality" />
    <button class="btn-blue" type="submit">Suivant</button>
  </form>

  <form class="flex-column gap-1" method="post">
    <input type="hidden" name="step" value="cancelMatchCreation" />
    <button class="btn-red" type="submit">Annuler</button>
  </form>
</article>