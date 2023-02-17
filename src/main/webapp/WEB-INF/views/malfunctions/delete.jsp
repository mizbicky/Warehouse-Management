<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 16.02.2023
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/homepage.jsp"></jsp:include>
<h1>Do you wanna delete malfunction: ${malfunction.name}</h1>
<form:form method="post" action="/malfunction/delete/${malfunction.id}" modelAttribute="malfunction">
    <form:hidden path="id"></form:hidden>
    <input type="submit" value="Delete">
</form:form>
<a href="/malfunction/list"><button id="cancel-button">Cancel</button></a>

</body>
</html>
