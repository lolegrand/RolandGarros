<article class="w-50 row self-center space-around" id="articleTrainingValidation">

  <label class="w-100">Demandes d'entraînement</label>
  <c:forEach items="${trainingRequests}" var="trainingRequest">
    <aui:input class="w-50" value="${trainingRequest}"/>
    <aui:input class="w-25 btn-green" type="submit" name="${trainingRequest}-Accepted" value="Accepter"/>
    <aui:input class="w-25 btn-red" type="submit" name="${trainingRequest}-Refused" value="Refuser"/>
  </c:forEach>


  <form method="post" name="formValidationTraining">

  </form>

</article>