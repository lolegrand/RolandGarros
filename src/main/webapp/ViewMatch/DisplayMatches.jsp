<%@ page import="java.util.List,fr.rolandgarros.model.Match" %>

<%

    boolean isAdmin = role != null && role.equals("Admin");

    /*
     * Match Simple Men (MSM)
     * Match Simple Women (MSW)
     * Match Double Men (MDM)
     * Match Double Women (MDW)
     *
     * Match Simple Past          (MSP)
     * Match Simple Men Past      (MSMP)
     * Match Simple Women Past    (MSWP)
     * Match Double Men Past      (MDMP)
     * Match Double Women Past    (MDWP)
     *
     * Match Simple ToCome          (MST)
     * Match Simple Men ToCome      (MSMT)
     * Match Simple Women ToCome    (MSWT)
     * Match Double Men ToCome      (MDMT)
     * Match Double Women ToCome    (MDWT)
     */

    List<Match> matches = (List<Match>) request.getAttribute("matches");
    List<Match> matchesPast = (List<Match>) request.getAttribute("matchesPast");
    List<Match> matchesToCome = (List<Match>) request.getAttribute("matchesToCome");

    List<Match> MSM = (List<Match>) request.getAttribute("MSM");
    List<Match> MSW = (List<Match>) request.getAttribute("MSW");
    List<Match> MDM = (List<Match>) request.getAttribute("MDM");
    List<Match> MDW = (List<Match>) request.getAttribute("MDW");
    List<Match> MSP = (List<Match>) request.getAttribute("MSP");
    List<Match> MSMP = (List<Match>) request.getAttribute("MSMP");
    List<Match> MSWP = (List<Match>) request.getAttribute("MSWP");
    List<Match> MDMP = (List<Match>) request.getAttribute("MDMP");
    List<Match> MDWP = (List<Match>) request.getAttribute("MDWP");
    List<Match> MST = (List<Match>) request.getAttribute("MST");
    List<Match> MSMT = (List<Match>) request.getAttribute("MSMT");
    List<Match> MSWT = (List<Match>) request.getAttribute("MSWT");
    List<Match> MDMT = (List<Match>) request.getAttribute("MDMT");
    List<Match> MDWT = (List<Match>) request.getAttribute("MDWT");

%>

<article class="w-50 row space-around self-center">

    <h1 class="w-100 txt-center">Matchs à venir</h1>

    <h2 class="w-100">Simple Messieurs</h2>
    <div class="w-100 scrollable">
        <table class="w-100">
            <% for (Match match : MSMT) { %>
                <tr>
                    <td><%= match.getType() %> <%= match.getGenre() %></td>
                    <td><%= match.getStartDate() %></td>
                </tr>
            <tr>
                <td><%= match.getCourt() %></td>
                <td><%= match.getGameTime() %></td>
            </tr>
            <tr>
                <td><%= match.getTeamOne() %></td>
                <td><%= match.getScoreOne() %></td>
            </tr>
            <tr>
                <td><%= match.getTeamTwo() %></td>
                <td><%= match.getScoreTwo() %></td>
            </tr>
            <% } %>
        </table>
    </div>


    <h2 class="w-100">Simple Dames</h2>
    <div class="w-100 scrollable">

    </div>


    <h2 class="w-100">Double Messieurs</h2>
    <div class="w-100 scrollable">

    </div>


    <h2 class="w-100">Double Dames</h2>
    <div class="w-100 scrollable">

    </div>

</article>
