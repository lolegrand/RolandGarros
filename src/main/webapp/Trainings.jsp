<%@ include file="head.jsp" %>

<body class="w-100 row">

<%@ include file="header.jsp" %>

<main class="w-100 row">

    <!-- By default, display the training sessions scheduled -->


    <!-- if role == trainer || role == admin -->
    <% if( request.getSession().getAttribute("role").equals("Trainer")
            || request.getSession().getAttribute("role").equals("Admin") )
    { %>
    <%@ include file="CreateTraining.jsp" %>
    <% } %>

    <!-- if role == matchEditor || role == admin -->
    <% if( request.getSession().getAttribute("role").equals("MatchEditor")
            || request.getSession().getAttribute("role").equals("Admin") )
    { %>
    <%@ include file="TrainingValidation.jsp" %>
    <% } %>

</main>

<%@ include file="footer.jsp" %>

</body>

</html>