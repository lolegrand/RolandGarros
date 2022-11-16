<%@ page import="fr.rolandgarros.servlet.AccountServlet" %>
<%
    String error = (String) request.getAttribute("error");
%>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<main class="w-100 flex-row justify-center items-center connection-main">

    <article class="flex-grow">

        <form class="w-100 flex-column justify-center items-center gap-1" method="post" name="formConnection">
            <h2 class="w-100 txt-center">Connexion</h2>
            <input class="w-100" type="text" name="Login" placeholder="Login">
            <input class="w-100" type="password" name="Password" placeholder="Password">

            <input class="w-25 btn-blue" type="submit" name="submitFormConnection">

            <% if (error != null) { %>

            <%
                String errorString = "";
                if (AccountServlet.LOGIN_ERROR_WRONG_LOGIN_OR_PASSWORD.equals(error)) {
                    errorString = "Mauvais mot de passe ou identifiant";
                }
            %>

            <h3 style=" background-color: darkred;
                        padding: 1rem 0;"
                class="w-100 txt-center"><%= errorString %></h3>

            <% } %>

        </form>

    </article>

</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>