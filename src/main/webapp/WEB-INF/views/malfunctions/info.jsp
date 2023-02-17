
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Malfunction details</title>
  <link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/homepage.jsp"></jsp:include>
<p>Name: ${malfunction.name}</p>
<p>Reporting: ${malfunction.worker}</p>
<p>Description: ${malfunction.description}</p>
<p>Name: ${malfunction.state}</p>
<%--<p>Name: ${malfunction.parts}</p>--%>

</body>
</html>
