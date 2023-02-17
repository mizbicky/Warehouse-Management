<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New part</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/homepage.jsp"></jsp:include>
<div>
    <form:form method="post" action="/part/save" modelAttribute="part">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"></form:input>
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:textarea cols="30" rows="5" path="description"></form:textarea>
        </p>
        <p>
            <form:label path="minQuantity">Minimum Quantity:</form:label>
            <form:input path="minQuantity"></form:input>
        </p>
        <p>
            <form:label path="quantity">Quantity:</form:label>
            <form:input path="quantity"></form:input>
        </p>
        <p>
            <form:select itemValue="id" itemLabel="name" path="category" items="${category}"/>
            <a href="/category/add">New category</a>
        </p>

        <p>
            <form:select itemValue="id" itemLabel="shelf" path="shelf" items="${shefls}"/>
            <a href="/shelf/add">New shelf</a>
        </p>


        <input type="submit" value="Zapisz">

    </form:form>
</div>
</body>
</html>
