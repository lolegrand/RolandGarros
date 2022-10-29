<!--
    Update of:
        - date
        - place
    No more, everything else is considered as true so to read only
-->
<article class="w-50 row self-center space-around" id="articleUpdateMatch">

    <form class="row space-around" method="post" name="formUpdateMatch">
        <h2 class="w-100 txt-center">Mise à jour du match</h2>

        <h3 class="w-100">Modalités</h3>

        <label class="w-25">Simple ou Double</label>
        <p class="w-75">${match.getType()}</p>

        <label class="w-25">Homme ou Femme</label>
        <p class="w-75">${match.getGender()}</p>

        <label class="w-25">Court</label>
        <% String selectCourt = "selectCourt"; %>
        <aui:select class="w-75" name="<%= selectCourt %>">
            <c:forEach items="${courts}" var="court">
                <aui:option value="${court}" selected="${match.getCourt()==selectCourt ? true : false }">${court}</aui:option>
            </c:forEach>
        </aui:select>

        <label class="w-25">Horaire</label>
        <% String selectSchedule = "selectSchedule"; %>
        <aui:select class="w-75" name="<%= selectSchedule %>">
            <c:forEach items="${schedules}" var="schedule">
                <aui:option value="${schedule}" selected="${match.getSchedule()==selectSchedule ? true : false }">${schedule}</aui:option>
            </c:forEach>
        </aui:select>


        <h3 class="w-100">Participants</h3>

        <!-- if post SimpleDouble == Simple -->
        <% if ( request.getParameter("SimpleDouble").equals("Simple") ){ %>

        <label class="w-25">Participant 1</label>
        <p class="w-75">${match.getPlayer1()}</p>

        <label class="w-25">Participant 2</label>
        <p class="w-75">${match.getPlayer2()}</p>

        <% } %>

        <!-- if post SimpleDouble == Double -->
        <% if ( request.getParameter("SimpleDouble").equals("Double") ){ %>

        <label class="w-100">Équipe 1</label>

        <label class="w-25">Participant 1</label>
        <p class="w-75">${match.getTeam1Player1()}</p>

        <label class="w-25">Participant 2</label>
        <p class="w-75">${match.getTeam1Player2()}</p>

        <label class="w-100">Équipe 2</label>

        <label class="w-25">Participant 1</label>
        <p class="w-75">${match.getTeam2Player1()}</p>

        <label class="w-25">Participant 2</label>
        <p class="w-75">${match.getTeam2Player2()}</p>

        <% } %>

        <input class="btn-blue w-25" type="submit" name="submitFormUpdateMatch" value="Mettre à jour">
    </form>

</article>