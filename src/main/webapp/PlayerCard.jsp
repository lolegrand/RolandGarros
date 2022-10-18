<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <%@ include file="head.jsp" %>

    <body class="w-100 row">

        <%@ include file="header.jsp" %>

        <main class="w-100 row">


            <!--
                By default, display the player sessions scheduled
                - if there is a session, then a role playerEditor or admin, display an update button
                - if there is a session, then a role admin, display a delete button
            -->
            <c:foreach items="${players}" var="player">

                <div class="w-50">

                    <!-- Where -->
                    <aui:input class="w-100"
                    <!-- readonly="\${role!=playerEditor && role!=admin ? true : false }" -->
                    type="text" name="${player.getCourt()}" value="${player.getCourt()}"/>

                    <!-- When -->
                    <aui:input class="w-100"
                    <!-- readonly="\${role!=playerEditor && role!=admin ? true : false }" -->
                    type="date" name="${player.getDate()}" value="${player.getDate()}"/>

                    <!-- Who -->
                    <ul>
                        <c:foreach items="${player.getPlayers()}" var="player">
                            <li>${player}</li>
                        </c:foreach>
                    </ul>

                </div>

                <!-- if role == playerEditor || role == admin -->
                <aui:input class="w-25 btn-dark" type="submit" name="update${player}" value="Modifier"/>

                <!-- if role == admin -->
                <aui:input class="w-25 btn-red" type="submit" name="delete${player}" value="Supprimer"/>

            </c:foreach>

            <!--
                if role == playerEditor || role == admin :
                    - be able to create a player
                    - be able to validate a training request
            -->
            <%@ include file="CreatePlayer.jsp" %>


            <%@ include file="ListsPlayers.jsp" %>

        </main>

        <%@ include file="footer.jsp" %>

    </body>

</html>