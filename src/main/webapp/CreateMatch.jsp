<article class="w-50 row self-center space-around" id="articleCreateMatch">

    <form class="row space-around" method="post" name="formCreateMatch">
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
            <input class="w-25" type="radio" name="Gender" id="Man">
            <label class="w-75">Man</label>
            <input class="w-25" type="radio" name="Gender" id="Woman">
            <label class="w-75">Woman</label>
        </div>

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

        <% if ( Simple ){ %>

            <% String selectPlayer1 = NULL; %>
            <% String selectPlayer2 = NULL; %>

            <label class="w-25">Participant 1</label>
            <aui:select class="w-75" name="<%= selectPlayer1; %>">
                <c:forEach items="${players}" var="player">
                    <aui:option value="${player}" selected="${player==selectPlayer1 ? true : false }">${player}</aui:option>
                </c:forEach>
            </aui:select>

            <label class="w-25">Participant 2</label>
            <aui:select class="w-75" name="<%= selectPlayer2; %>">
                <c:forEach items="${players}" var="player">
                    <aui:option value="${player}" selected="${player==selectPlayer2 ? true : false }">${player}</aui:option>
                </c:forEach>
            </aui:select>

        <% } %>

        <% if ( Double ){ %>

        <% String selectTeam1Player1 = NULL; %>
        <% String selectTeam1Player2 = NULL; %>
        <% String selectTeam2Player1 = NULL; %>
        <% String selectTeam2Player2 = NULL; %>

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

        <input required class="btn-blue w-25" type="submit" name="submitFormCreateMatch">
    </form>

</article>