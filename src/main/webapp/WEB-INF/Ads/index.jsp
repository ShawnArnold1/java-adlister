<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: makevio
  Date: 2019-02-06
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Your Profile" />
        </jsp:include>
    </head>
    <body>
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <div class="container">
            <h1>
                Here Are all the quotes!
            </h1>
            <c:forEach var="Ad" items="${ads}">
            <div class="col-md-6">
                <h2>
                        ${Ad.title}
                </h2>
                <p>
                    Author: ${Ad.description}
                </p>
            </div>
            </c:forEach>
        </div>
    </body>
</html>
