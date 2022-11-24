<%@ page import="java.util.List" %>
<%@ page import="fr.rolandgarros.model.Account" %>
<%
    List<Account> accounts = (List<Account>) request.getAttribute("accounts");

    Role role = (Role) request.getSession().getAttribute("role");

    boolean isAdmin = role == Role.ADMINISTRATOR;
%>

<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<% if ( isAdmin ) {%>

<main class="w-100 row space-around">

    <article class="w-75 row">

        <table class="w-100">
            <tr>
                <th>Login</th>
                <th>Role</th>
                <th>Action</th>
            </tr>

            <% for (Account account: accounts) { %>

            <tr class="tr-hover">
                <td><%=account.getLogin()%></td>
                <td><%=account.getRole().toString()%></td>
                <td>
                    <form method="post">
                        <input type="hidden" value="<%=account.getIdAccount()%>" name="accountId">
                        <input class="btn-red" type="submit" value="Supprimer" name="delete">
                    </form>
                </td>
            </tr>

            <% } %>

        </table>

    </article>

    <% } else { %>
    <article class="w-75 row">

        <h1> Vous n'étes pas un adminnistrateur </h1>

    </article>
    <% } %>

</main>



<%@ include file="../Template/footer.jsp" %>

</body>

</html>
