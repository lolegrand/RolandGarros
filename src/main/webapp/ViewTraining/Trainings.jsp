<%@ page import="fr.rolandgarros.model.Training" %>
<%@ page import="fr.rolandgarros.model.Role" %>

<%
    Role role = (Role) request.getSession().getAttribute("role");
    Boolean isTrainer = role == Role.TRAINER || role == Role.ADMINISTRATOR;
    Boolean isMatchEditor = role == Role.MATCH_EDITOR || role == Role.ADMINISTRATOR;
%>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<main class="w-100 row">

    <!-- By default, display the training sessions scheduled -->

    <!-- if role == trainer || role == admin -->
    <% if( isTrainer )
    { %>
    <%@ include file="/ViewTraining/CreateTraining.jsp" %>
    <% } %>

    <!-- if role == matchEditor || role == admin -->
    <% if( isMatchEditor )
    { %>
    <%@ include file="/ViewTraining/TrainingValidation.jsp" %>
    <% } %>

</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>