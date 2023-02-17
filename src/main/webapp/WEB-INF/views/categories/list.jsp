<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 16.02.2023
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/homepage.jsp"></jsp:include>
<table class="table-malfunction">
    <thead>
    <tr>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td><c:out value="${category.name}"/></td>
            <td>
                <button  type="button"><a href="/category/edit/${category.id}">Edit</a></button>
                <button  type="button"><a href="/category/delete/${category.id}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
