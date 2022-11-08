<%@ page import="fr.rolandgarros.model.Training" %>
<%@ page import="fr.rolandgarros.model.Role" %>
<%@ page import="java.util.List" %>

<%
    Role role = (Role) request.getSession().getAttribute("role");

    List<Training> trainings = (List<Training>) request.getAttribute("trainings");

    boolean isTrainer = role == Role.TRAINER || role == Role.ADMINISTRATOR;
    boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;
%>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<main class="w-100 row space-around">
    <div class="w-50" style="margin-top: 0; max-height: 60%;">
        <% if( isTrainer ) { %>
        <%@ include file="/ViewTraining/CreateTraining.jsp" %>
        <% } %>

        <article class="w-100 scrollable" style="margin-top: 1rem">
            <%
                for (Training training: trainings) {
                    if (training.getValidated() != null) {
            %>
            <div class="w-100 row
            <% if( !training.equals(trainings.get(trainings.size() - 1)) ) { %>borderDashed <%}%>">
                <p class="w-100 txt-center">
                    Demande d'entraînement par <%=training.getBooker().getFirstname()%> <%=training.getBooker().getLastname()%>
                </p>
                <p class="w-100 txt-center">
                    Pour le cours <%=training.getCourt().getName()%>
                </p>
                <p class="w-100 txt-center">
                    Date : <%=training.getStartDate().toString()%>
                </p>
                <%if (training.getValidated()) { %>
                <p class="w-100 txt-center" style="margin: 1rem; background-color: darkgreen">Accepté</p>
                <% } %>

                <%if (!training.getValidated()) {%>
                <p class="w-100 txt-center" style="margin: 1rem; background-color: darkred">Refusé</p>
                <% } %>
            </div>
            <% } } %>
        </article>
    </div>


    <% if( isMatchEditor ) { %>
    <jsp:include page="/ViewTraining/TrainingValidation.jsp"/>
    <% } %>

</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>