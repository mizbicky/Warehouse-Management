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
    <title>Part list</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/homepage.jsp"></jsp:include>

<table class="table-malfunction">
    <thead>
<tr>
    <th>Name</th>
    <th>Category</th>
    <th>Minimum quantity</th>
    <th>Quantity</th>
    <th>Description</th>
    <th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach items="${parts}" var="part">
    <tr>
        <td> <c:out value="${part.name}"></c:out></td>
        <td> <c:out value="${part.category}"></c:out></td>
        <td> <c:out value="${part.minQuantity}"></c:out></td>
        <td> <c:out value="${part.quantity}"></c:out></td>
        <td> <c:out value="${part.description}"></c:out></td>
        <td>
            <button  type="button"><a href="/part/edit/${part.id}">Edit</a></button>
            <button  type="button"><a href="/part/delete/${part.id}">Delete</a></button>
            <button  type="button"><a href="/part/info/${part.id}">More information</a></button>
        </td>
    </tr>
</c:forEach>

</tbody>
</table>



</body>
</html>
