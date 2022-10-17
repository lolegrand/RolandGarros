<article class="scrollable">
    <c:forEach items="${players}" var="player">
      <aui:input class="btn-dark" type="submit" name="see${player}" value="${player}"/>
    </c:forEach>
</article>
