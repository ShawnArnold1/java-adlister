<%--
  Created by IntelliJ IDEA.
  User: makevio
  Date: 2/6/19
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
       <jsp:include page="partials/head.jsp"/>
    </head>
    <body>
        <jsp:include page="partials/navbar.jsp"/>

        <div>
            <main class="container">
                <h1>
                    Counter : ${count}
                </h1>
            </main>
        </div>
    </body>
</html>
