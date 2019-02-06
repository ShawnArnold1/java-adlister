<%--
  Created by IntelliJ IDEA.
  User: makevio
  Date: 2/5/19
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="partials/head.jsp"/>
    </head>
        <jsp:include page="partials/navbar.jsp"/>
    <body>
        <form action="/login" method="POST">
            User Name
            <br>
            <input type="text" name="username" id="username">
            <br>
            <br>
            Password
            <br>
            <input type="password" name="password" id="password">
            <button type="submit">
                Submit!
            </button>
        </form>

    </body>
</html>
