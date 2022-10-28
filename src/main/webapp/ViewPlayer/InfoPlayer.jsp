<%@ page import="fr.rolandgarros.model.Person" %>

<%
    Player player = (Player) request.getAttribute("displayedPlayer");

    if ( player != null ) {
        Person trainer = player.getTrainer();
%>
<table class="w-50 txt-justify">

    <tr class="tr-noBorder">
        <td class="td-none"><%=player.getLastname()%></td>
        <td class="td-none"><%=player.getFirstname()%></td>
        <td class="td-none" colspan="2"><%=player.getNationality()%></td>
    </tr>
    <tr class="tr-noBorder">
        <td class="td-none"><%=player.getBirthDate()%></td>
        <td class="td-none"><%=player.getBirthPlace()%></td>
        <td class="td-none">Début de carrière le</td>
        <td class="td-none"><%=player.getStartCareer()%></td>
    </tr>
    <tr class="tr-noBorder">
        <td class="td-none"><%=player.getGender()%></td>
        <td class="td-none"><%=player.getHand()%></td>
        <td class="td-none"></td>
        <td class="td-none"></td>
    </tr>
    <tr class="tr-noBorder">
        <th class="td-none">Taille</th>
        <td class="td-none"><%=player.getHeight()%></td>
        <th class="td-none">Poids</th>
        <td class="td-none"><%=player.getWeight()%></td>
    </tr>
    <tr class="tr-noBorder">
        <th class="td-none">Classement</th>
        <td class="td-none"><%=player.getRanking()%></td>
        <th class="td-none">Meilleur classement</th>
        <td class="td-none"><%=player.getBestRanking()%></td>
    </tr>
    <tr class="tr-noBorder">
        <th class="td-none">Entraîneur</th>
        <td class="td-none"><%=trainer.getLastname()%> <%=trainer.getFirstname()%></td>
        <td class="td-none"></td>
        <td class="td-none"></td>
    </tr>

</table>
<% } %>