<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/homepage.jsp"></jsp:include>
<body>
<form:form method="post" action="/device/edit" modelAttribute="device">
    <p>
        <form:hidden path="id"></form:hidden>
        <form:label path="name">Name:</form:label><br/>
        <form:input path="name"/><br/>
    </p>
    <input type="submit">
</form:form>
</body>
</body>
</html>
