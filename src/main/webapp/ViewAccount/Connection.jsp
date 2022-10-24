<%@ include file="../Template/head.jsp" %>

<body class="w-100 row">

<%@ include file="../Template/header.jsp" %>

<main class="w-100 row space-around">

    <article class="w-33 row self-center space-around" id="articleConnection">

        <form class="row space-around" method="post" name="formConnection">
            <h2 class="w-100 txt-center">Connexion</h2>
            <input class="w-100" type="text" name="Login" placeholder="Login">
            <input class="w-100" type="password" name="Password" placeholder="PassWord">
            <input class="btn-blue" type="submit" name="submitFormConnection">
        </form>

    </article>

</main>

<%@ include file="../Template/footer.jsp" %>

</body>

</html>