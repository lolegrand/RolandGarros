<%@ page import="fr.rolandgarros.model.Training" %>
<%@ page import="java.util.List" %>
<%
  List<Training> trainings = (List<Training>) request.getAttribute("trainings");
  boolean showValidator = false;

  for (Training training : trainings) {
    if (training.getValidated() == null) {
      showValidator = true;
      break;
    }
  }

%>

<% if (showValidator) { %>

<article class="w-50 row self-center space-around" id="articleTrainingValidation">

  <%
    for (Training training: trainings) {
      if (training.getValidated() == null) {
  %>
  <form method="post" class="w-100 row space-around"
        style="margin: 10px; box-shadow: rgba(100, 100, 111, 0.2) 0 7px 29px 0;">

    <p class="w-100 txt-center">
      Demande d'entraînement par <%=training.getBooker().getFirstname()%> <%=training.getBooker().getLastname()%>
    </p>
    <p class="w-100 txt-center">
      Pour le cours <%=training.getCourt().getName()%>
    </p>
    <p class="w-100 txt-center">
      Date : <%=training.getStartDate().toString()%>
    </p>

    <input type="hidden" name="training" value="<%=training.getIdT()%>">

    <input class="w-25 btn-green" type="submit" name="state" value="Accepter" onclick="return confirm('Voulez-vous accepter cet entrainement ?')">

    <input class="w-25 btn-red" type="submit" name="state" value="Refuser" onclick="return confirm('Voulez-vous refuser cet entrainement ?')">
  </form>
  <%
      }
    }
  %>

  <form method="post" name="formValidationTraining">

  </form>

</article>

<% } %>