<%@ page import="fr.rolandgarros.model.Training" %>
<%@ page import="java.util.List" %>

<%
  List<Training> trainings = (List<Training>) request.getAttribute("trainings");
%>

<article class="w-50 row self-center space-around" id="articleTrainingValidation">

  <label class="w-100">Demandes d'entraînement</label>


  <%
    for (Training training: trainings) {
      if (training.getValidated() == null) {
  %>
  <form method="post" class="w-100 row space-around" style="border: dashed black; border-width: 0 0 3px 0; margin: 0">
    <p class="w-100 txt-center">Demande d'entraînement par <%=training.getBooker().getFirstname()%> <%=training.getBooker().getLastname()%></p>
    <p class="w-100 txt-center">Pour le cours <%=training.getCourt().getName()%></p>
    <p class="w-100 txt-center">Date : <%=training.getStartDate().toString()%></p>
    <input class="w-25 btn-green" type="submit" name="<%=training%>" value="Accepter">
    <input class="w-25 btn-red" type="submit" name="<%=training%>" value="Refuser">
  </form>
  <% } } %>

  <form method="post" name="formValidationTraining">

  </form>

</article>