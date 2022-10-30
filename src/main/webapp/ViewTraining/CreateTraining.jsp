<%@ page import="fr.rolandgarros.model.Court" %>
<%
  List<Court> courts = (List<Court>) request.getAttribute("courts");
%>
<article class="w-50 row self-center space-around" id="articleCreateTraining">

  <form class="row space-around" method="post" name="formCreateTraining">
    <h2 class="w-100 txt-center">Demande d'entrainement</h2>

    <label class="w-25">Court</label>
    <select class="w-75" name="selectCourt">
      <% for (Court court : courts ){ %>
        <option value="<%= court.getName() %>"><%= court.getName() %></option>
      <% } %>
    </select>

    <label class="w-25">Horaire</label>
    <select class="w-75" name="selectSchedule">
        <option value="morning">Matin</option>
        <option value="afternoon">Après-midi</option>
        <option value="evening">Soirée</option>
    </select>

    <input type="hidden" name="trainer" value="<%= request.getSession().getAttribute("login") %>">

    <input class="btn-blue w-25" type="submit" name="submitFormCreateTraining" value="Nouvel Entrainement">
  </form>

</article>