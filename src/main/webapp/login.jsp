<%--
  Created by IntelliJ IDEA.
  User: makevio
  Date: 2/5/19
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>

<%
    if(request.getMethod().equalsIgnoreCase("post"))
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(!username.isEmpty() && !password.isEmpty())
        {
            if (username.equals("admin") && password.equals("password")) {
                response.sendRedirect("/profile.jsp");
            }
        }
    }

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>
            Login Page
        </title>
    </head>
    <body>
        <form action="login.jsp" method="POST">
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
