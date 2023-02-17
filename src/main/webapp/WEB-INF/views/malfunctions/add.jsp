<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/homepage.jsp"></jsp:include>
<div>
    <form:form method="post" action="/malfunction/save" modelAttribute="malfunction">
        <p>
            <form:select itemValue="id" itemLabel="name" path="device" items="${devices}"/>
            <a href="/device/add">New device</a>
        </p>
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"></form:input>
        </p>
        <p>
            <form:label path="description">Description:</form:label>
            <form:textarea rows="10" cols="30" path="description"></form:textarea>
        </p>
        <p>
            <form:select itemValue="id" itemLabel="name" path="worker" items="${workers}"/>
            <a href="/worker/add">New worker</a>

        </p>
        <form:hidden path="state"></form:hidden>
        <input type="submit" value="Zapisz">

    </form:form>
</div>
</body>
</html>
