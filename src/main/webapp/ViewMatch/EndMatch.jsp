<!--
Update of:
- date
- place
No more, everything else is considered as true so to read only
-->
<article class="w-50 row self-center space-around" id="articleEndMatch">

    <form class="row space-around" method="post" name="formEndMatch">
        <h2 class="w-100 txt-center">Clore un match</h2>

        <h3 class="w-100">Modalités</h3>

        <p class="w-100 txt-justify">${match.getType()}, ${match.getGender()}</p>
        <p class="w-100 txt-justify">${match.getCourt()}, ${match.getSchedule()}</p>

        <h3 class="w-100">Participants</h3>

        <!-- if post SimpleDouble == Simple -->
        <% if ( match.getType().equals("Simple") ){ %>

        <p class="w-100">${match.getPlayer1()} VS ${match.getPlayer2()}</p>

        <% } %>

        <!-- if post SimpleDouble == Double -->
        <% if ( match.getType().equals("Double") ){ %>

        <table class="w-50">
            <tr class="tr-noBorder">
                <th>Équipe 1</th>
                <th></th>
                <th>Équipe 2</th>
            </tr>
            <tr class="tr-noBorder">
                <td class="w-33">${match.getTeam1Player1()}</td>
                <td class="w-33" rowspan="2"> VS </td>
                <td class="w-33">${match.getTeam2Player1()}</td>
            </tr>
            <tr class="tr-noBorder">
                <td class="w-33">${match.getTeam1Player2()}</td>
                <td class="w-33">${match.getTeam2Player2()}</td>
            </tr>
        </table>

        <% } %>

        <h3 class="w-100">Résultats</h3>

        <label class="w-25">Temps de jeu</label>
        <input class="w-75" type="text" name="gameTime" value="1h00" pattern="[0-9]{0,3}h[0-9]{2}">

        <label class="w-25">Premier set</label>
        <input class="w-33" type="number" min="0" max="7" name="scoreS1P1" placeholder="0">
        <input class="w-33" type="number" min="0" max="7" name="scoreS1P2" placeholder="0">

        <label class="w-25">Deuxième set</label>
        <input class="w-33" type="number" min="0" max="7" name="scoreS2P1" placeholder="0">
        <input class="w-33" type="number" min="0" max="7" name="scoreS2P2" placeholder="0">

        <label class="w-25">Troisième set</label>
        <input class="w-33" type="number" min="0" max="7" name="scoreS3P1" placeholder="0">
        <input class="w-33" type="number" min="0" max="7" name="scoreS3P2" placeholder="0">

        <% if ( match.getGender().equals("Male") ){ %>

        <label class="w-25">Quatrième set</label>
        <input class="w-33" type="number" min="0" max="7" name="scoreS4P1" placeholder="0">
        <input class="w-33" type="number" min="0" max="7" name="scoreS4P2" placeholder="0">

        <% } %>

        <input class="btn-blue w-25" type="submit" name="submitFormEndMatch" value="Finir">
    </form>

</article>