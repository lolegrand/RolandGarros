<article class="w-50 row self-center space-around" id="articleCreateMatch">

  <form class="row space-around" method="post" name="formCreateMatchPlayers">
    <h2 class="w-100 txt-center">Nouveau match - Participants</h2>

    <!-- foreach post from fromCreateMatchModality : to save -->

    <!-- if Genre == Male : select all male player for following select-->
    <!-- if Genre == Female : select all female player for following select-->

    <!-- if post SimpleDouble == Simple -->
    <% if ( request.getParameter("SimpleDouble").equals("Simple") ){ %>

    <% String selectPlayer1 = "selectPlayer1"; %>
    <% String selectPlayer2 = "selectPlayer2"; %>

    <label class="w-25">Participant 1</label>
    <aui:select class="w-75" name="<%= selectPlayer1 %>">
      <c:forEach items="${players}" var="player">
        <aui:option value="${player}" selected="${player==selectPlayer1 ? true : false }">${player}</aui:option>
      </c:forEach>
    </aui:select>

    <label class="w-25">Participant 2</label>
    <aui:select class="w-75" name="<%= selectPlayer2 %>">
      <c:forEach items="${players}" var="player">
        <aui:option value="${player}" selected="${player==selectPlayer2 ? true : false }">${player}</aui:option>
      </c:forEach>
    </aui:select>

    <% } %>

    <!-- if post SimpleDouble == Double -->
    <% if ( request.getParameter("SimpleDouble").equals("Double") ){ %>

    <% String selectTeam1Player1 = "selectTeam1Player1"; %>
    <% String selectTeam1Player2 = "selectTeam1Player2"; %>
    <% String selectTeam2Player1 = "selectTeam2Player1"; %>
    <% String selectTeam2Player2 = "selectTeam2Player2"; %>

    <label class="w-100">Équipe 1</label>

    <label class="w-25">Participant 1</label>
    <aui:select class="w-75" name="<%= selectTeam1Player1 %>">
      <c:forEach items="${players}" var="player">
        <aui:option value="${player}" selected="${player==selectTeam1Player1 ? true : false }">${player}</aui:option>
      </c:forEach>
    </aui:select>

    <label class="w-25">Participant 2</label>
    <aui:select class="w-75" name="<%= selectTeam1Player2 %>">
      <c:forEach items="${players}" var="player">
        <aui:option value="${player}" selected="${player==selectTeam1Player2 ? true : false }">${player}</aui:option>
      </c:forEach>
    </aui:select>

    <label class="w-100">Équipe 2</label>

    <label class="w-25">Participant 1</label>
    <aui:select class="w-75" name="<%= selectTeam2Player1 %>">
      <c:forEach items="${players}" var="player">
        <aui:option value="${player}" selected="${player==selectTeam2Player1 ? true : false }">${player}</aui:option>
      </c:forEach>
    </aui:select>

    <label class="w-25">Participant 2</label>
    <aui:select class="w-75" name="<%= selectTeam2Player2 %>">
      <c:forEach items="${players}" var="player">
        <aui:option value="${player}" selected="${player==selectTeam2Player2 ? true : false }">${player}</aui:option>
      </c:forEach>
    </aui:select>

    <% } %>

    <input class="btn-blue w-25" type="submit" name="submitFormCreateMatchPlayers" value="Enregistrer">
  </form>

</article>