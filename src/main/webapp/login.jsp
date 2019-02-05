<%--
  Created by IntelliJ IDEA.
  User: makevio
  Date: 2/5/19
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>
            Login Page
        </title>
        
        <form action="/login" method="post">
            User Name
            <br>
            <input type="text" name="userName">
            <br>
            <br>
            Password
            <br>
            <input type="password" name="password">
        </form>
        <button type="submit">
            Submit!
            <%= request.getParameter("") %>
        </button>
    </head>
    <body>

    </body>
</html>
