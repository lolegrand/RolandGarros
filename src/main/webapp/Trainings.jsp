<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <%@ include file="head.jsp" %>

    <body class="w-100 row">

        <%@ include file="header.jsp" %>

        <main class="w-100 row">

            <!-- By default, display the training sessions scheduled -->


            <!-- if role == trainer || role == admin -->
            <%@ include file="CreateTraining.jsp" %>

            <!-- if role == matchEditor || role == admin -->
            <%@ include file="TrainingValidation.jsp" %>

        </main>

        <%@ include file="footer.jsp" %>

    </body>

</html>