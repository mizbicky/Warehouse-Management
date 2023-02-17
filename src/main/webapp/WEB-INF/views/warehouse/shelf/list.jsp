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
        <th>Shelf</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="shelf" items="${shelfs}">
        <tr>
            <td><c:out value="${shelf.shelf}"/></td>
            <td>
                <button  type="button"><a href="/shelf/edit/${shelf.id}">Edit</a></button>
                <button  type="button"><a href="/shelf/delete/${shelf.id}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
