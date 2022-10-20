<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <%@ include file="head.jsp" %>

    <body class="w-100 row">

        <%@ include file="header.jsp" %>

        <main class="w-100 row">

            <!--
                By default, display the match sessions scheduled
                - if there is a session, then a role matchEditor or admin, display an update button
                - if there is a session, then a role admin, display a delete button
            -->
            <c:foreach items="${matches}" var="match">

                <div class="w-50">

                    <!-- Where -->
                    <aui:input class="w-100"
                    <!-- readonly="\${role!=matchEditor && role!=admin ? true : false }" -->
                    type="text" name="${match.getCourt()}" value="${match.getCourt()}"/>

                    <!-- When -->
                    <aui:input class="w-100"
                    <!-- readonly="\${role!=matchEditor && role!=admin ? true : false }" -->
                    type="date" name="${match.getDate()}" value="${match.getDate()}"/>

                    <!-- Who -->
                    <ul>
                    <c:foreach items="${match.getPlayers()}" var="player">
                        <li>${player}</li>
                    </c:foreach>
                    </ul>

                </div>

                <% if( request.getSession().getAttribute("role").equals("MatchEditor")
                        || request.getSession().getAttribute("role").equals("Admin") )
                { %>
                    <aui:input class="w-25 btn-dark" type="submit" name="update${match}" value="Modifier"/>
                <% } %>

                <% if( request.getSession().getAttribute("role").equals("Admin") ){ %>
                    <aui:input class="w-25 btn-red" type="submit" name="delete${match}" value="Supprimer"/>
                <% } %>

            </c:foreach>

            <!--
                if role == matchEditor || role == admin :
                    - be able to create a match
                    - be able to validate a training request
            -->
            <% if( request.getSession().getAttribute("role").equals("MatchEditor")
                    || request.getSession().getAttribute("role").equals("Admin") )
            { %>
                <%@ include file="CreateMatch.jsp" %>
                <%@ include file="TrainingValidation.jsp" %>
            <% } %>

        </main>

        <%@ include file="footer.jsp" %>

    </body>

</html>