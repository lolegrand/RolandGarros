<%@ page import="fr.rolandgarros.model.Person" %>

<%
    Player player = (Player) request.getAttribute("displayedPlayer");

    if ( player != null ) {
        Person trainer = player.getTrainer();
%>
<article class="w-50 row scrollable space-around self-center">

    <h1 class="w-100 txt-center">Détails de <%=player.getFirstname()%> <%=player.getLastname()%></h1>

    <table class="w-50 txt-justify">

        <!-- Common information -->

        <tr class="tr-noBorder">
            <th class="td-none">Sexe</th>
            <td class="td-none"><%=player.getGender()%></td>
        </tr>
        <tr class="tr-noBorder">
            <th class="td-none">Main de jeu</th>
            <td class="td-none"><%=player.getHand()%></td>
        </tr>
        <tr class="tr-noBorder">
            <th class="td-none">Lieu de naissance</th>
            <td class="td-none"><%=player.getBirthPlace()%></td>
        </tr>
        <tr class="tr-noBorder">
            <th class="td-none">Date de naissance</th>
            <td class="td-none"><%=player.getBirthDate()%></td>
        </tr>
        <tr class="tr-noBorder">
            <th class="td-none">Nationalité</th>
            <td class="td-none"><%=player.getNationality()%></td>
        </tr>
        <tr class="tr-noBorder">
            <th class="td-none">Taille</th>
            <td class="td-none"><%=player.getHeight()%>m</td>
        </tr>
        <tr class="tr-noBorder">
            <th class="td-none">Poids</th>
            <td class="td-none"><%=player.getWeight()%>kg</td>
        </tr>

        <!-- Career details -->

        <tr class="tr-noBorder">
            <th class="td-none">Début de carrière en</th>
            <td class="td-none"><%=player.getStartCareer()%></td>
        </tr>
        <tr class="tr-noBorder">
            <th class="td-none">Classement</th>
            <td class="td-none"><%=player.getRanking()%></td>
        </tr>
        <tr class="tr-noBorder">
            <th class="td-none">Meilleur classement</th>
            <td class="td-none"><%=player.getBestRanking()%></td>
        </tr>
        <tr class="tr-noBorder">
            <th class="td-none">Entraîneur</th>
            <td class="td-none"><%=trainer.getLastname()%> <%=trainer.getFirstname()%></td>
        </tr>

    </table>
</article>
<% } %>