<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <th>Surname</th>
        <th>Working on</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${workers}" var="worker">
        <tr>
            <td><c:out value="${worker.name}"></c:out></td>
            <td><c:out value="${worker.surname}"></c:out></td>
            <td> <c:out value="${worker.description}"></c:out></td>
            <td>
                <button  type="button"><a href="/worker/edit/${worker.id}">Edit</a></button>
                <button  type="button"><a href="/worker/delete/${worker.id}">Delete</a></button>
                <button  type="button"><a href="/worker/info/${worker.id}">More information</a></button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
