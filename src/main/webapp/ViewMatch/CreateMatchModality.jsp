<article class="w-50 row self-center space-around" id="articleCreateMatch">

  <form class="row space-around" method="post" name="formCreateMatchModality">
    <h2 class="w-100 txt-center">Nouveau match</h2>

    <label class="w-25">Simple ou Double</label>
    <div class="w-75">
      <input class="w-25" type="radio" name="SimpleDouble" id="Simple">
      <label class="w-75">Simple</label>
      <input class="w-25" type="radio" name="SimpleDouble" id="Double">
      <label class="w-75">Double</label>
    </div>

    <label class="w-25">Homme ou Femme</label>
    <div class="w-75">
      <input class="w-25" type="radio" name="Gender" id="Male">
      <label class="w-75">Homme</label>
      <input class="w-25" type="radio" name="Gender" id="Female">
      <label class="w-75">Femme</label>
    </div>

    <label class="w-25">Court</label>
    <% String selectCourt = "selectCourt"; %>
    <aui:select class="w-75" name="<%= selectCourt %>">
      <c:forEach items="${courts}" var="court">
        <aui:option value="${court}" selected="${court==selectCourt ? true : false }">${court}</aui:option>
      </c:forEach>
    </aui:select>


    <label class="w-25">Horaire</label>
    <% String selectSchedule = "selectSchedule"; %>
    <aui:select class="w-75" name="<%= selectSchedule %>">
      <c:forEach items="${schedules}" var="schedule">
        <aui:option value="${schedule}" selected="${schedule==selectSchedule ? true : false }">${schedule}</aui:option>
      </c:forEach>
    </aui:select>

    <input class="btn-blue w-25" type="submit" name="submitFormCreateMatchModality" value="Suivant">
  </form>

</article>