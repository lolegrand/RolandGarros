<article class="w-50 row self-center space-around" id="articleCreateTraining">

  <form class="row space-around" method="post" name="formCreateTraining">
    <h2 class="w-100 txt-center">Demande d'entrainement</h2>

    <label class="w-25">Court</label>
    <% String selectCourt = NULL; %>
    <aui:select class="w-75" name="<%= selectCourt; %>">
      <c:forEach items="${courts}" var="court">
        <aui:option value="${court}" selected="${court==selectCourt ? true : false }">${court}</aui:option>
      </c:forEach>
    </aui:select>


    <label class="w-25">Horaire</label>
    <% String selectSchedule = NULL; %>
    <aui:select class="w-75" name="<%= selectSchedule; %>">
      <c:forEach items="${schedules}" var="schedule">
        <aui:option value="${schedule}" selected="${schedule==selectSchedule ? true : false }">${schedule}</aui:option>
      </c:forEach>
    </aui:select>

    <input required class="btn-blue w-25" type="submit" name="submitFormCreateTraining">
  </form>

</article>