<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New category</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/homepage.jsp"></jsp:include>
<div>
    <form:form method="post" action="/category/save" modelAttribute="category">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"></form:input>
        <input type="submit" value="Zapisz">
    </form:form>
</div>
</body>
</html>
