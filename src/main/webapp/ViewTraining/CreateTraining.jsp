<%@ page import="fr.rolandgarros.model.Court" %>
<%@ page import="fr.rolandgarros.model.Person" %>
<%
  List<Court> courts = (List<Court>) request.getAttribute("courts");
  List<Person> trainers = (List<Person>) request.getAttribute("trainers");
  String error = (String) request.getAttribute("reqCreationError");
%>
<article class="w-100 row space-around" id="articleCreateTraining">

  <form class="row space-around" method="post" name="formCreateTraining">
    <h2 class="w-100 txt-center">Demande d'entrainement</h2>

    <label class="w-25">Court</label>
    <select class="w-75" name="selectCourt">
      <% for (Court court : courts ){ %>
        <option value="<%= court.getIdC() %>"><%= court.getName() %></option>
      <% } %>
    </select>

    <label class="w-25">Horaire</label>
    <input class="w-75" type="datetime-local" name="selectSchedule"/>

    <label class="w-25">Entrainer</label>
    <select class="w-75" name="selectTrainer">
      <% for (Person trainer : trainers ){ %>
      <option value="<%= trainer.getId() %>"><%= trainer.getLastname() %> <%= trainer.getFirstname() %></option>
      <% } %>
    </select>
    <input type="hidden" name="trainer" value="<%= request.getSession().getAttribute("login") %>">

    <input class="btn-blue w-25" style="margin: 10px" type="submit" name="submitFormCreateTraining" value="Nouvel Entrainement">

    <% if (error != null) {%>
    <div class="w-100">
      <%=error%>
    </div>
    <%}%>
  </form>

</article>