<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>Malfunction list</title>
    <link rel="stylesheet" href="/resources/style.css">
<body>
<jsp:include page="/WEB-INF/views/homepage.jsp"></jsp:include>
<table class="table-malfunction">
    <thead>
    <tr>
        <th>Name</th>
        <th>Reporting</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="malfunction" items="${malfunctions}">
        <tr>
            <td><c:out value="${malfunction.name}"></c:out></td>
            <td><c:out value="${malfunction.worker}"></c:out></td>
            <td><c:out value="${malfunction.state}"></c:out></td>
            <td>
                <button  type="button"><a href="/malfunction/edit/${malfunction.id}">Edit</a></button>
                <button  type="button"><a href="/malfunction/delete/${malfunction.id}">Delete</a></button>
                <button  type="button"><a href="/malfunction/info/${malfunction.id}">More information</a></button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
