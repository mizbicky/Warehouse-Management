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
    <form:form method="post" action="/shelf/save" modelAttribute="shelf">
        <p>
            <form:label path="shelf">Shelf number:</form:label>
            <form:input path="shelf"></form:input>
        </p>
        <input type="submit" value="Zapisz">

    </form:form>
</div>
</body>
</html>
