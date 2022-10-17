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

        <label class="w-25">Courts</label>
        <select required class="w-75" name="coaches">
            <% foreach ( Court court : courts ){ %>
            <option value="<% court; %>"><% court; %></option>
            <% } %>
        </select>

        <label class="w-25">Horaire</label>
        <select required class="w-75" name="coaches">
            <% foreach ( Schedule schedule : schedules ){ %>
            <option value="<% schedule; %>"><% schedule; %></option>
            <% } %>
        </select>

        <% if ( Simple ){ %>

            <label class="w-25">Participant 1</label>
            <select required class="w-75" name="player1">
                <% foreach ( Player player : players ){ %>
                <option value="<% player; %>"><% player; %></option>
                <% } %>
            </select>

            <label class="w-25">Participant 2</label>
            <select required class="w-75" name="player2">
                <% foreach ( Player player : players ){ %>
                <option value="<% player; %>"><% player; %></option>
                <% } %>
            </select>

        <% } %>

        <% if ( Double ){ %>

            <label class="w-100">Équipe 1</label>

            <label class="w-25">Participant 1</label>
            <select required class="w-75" name="team1player1">
                <% foreach ( Player player : players ){ %>
                <option value="<% player; %>"><% player; %></option>
                <% } %>
            </select>

            <label class="w-25">Participant 2</label>
            <select required class="w-75" name="team1player2">
                <% foreach ( Player player : players ){ %>
                <option value="<% player; %>"><% player; %></option>
                <% } %>
            </select>

            <label class="w-100">Équipe 2</label>

            <label class="w-25">Participant 1</label>
            <select required class="w-75" name="team2player1">
                <% foreach ( Player player : players ){ %>
                <option value="<% player; %>"><% player; %></option>
                <% } %>
            </select>

            <label class="w-25">Participant 2</label>
            <select required class="w-75" name="team2player2">
                <% foreach ( Player player : players ){ %>
                <option value="<% player; %>"><% player; %></option>
                <% } %>
            </select>

        <% } %>


        <input required class="btn-blue w-25" type="submit" name="submitFormCreateMatch">
    </form>

</article>