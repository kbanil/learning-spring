<%--
  Created by IntelliJ IDEA.
  User: anil
  Date: 3/12/17
  Time: 12:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spitter Application</title>
</head>
<body>
    <h1>Welcome to Spittr</h1>
    <a href="<c:url value="/spittles" />" >Spittles</a>
    <a href="<c:url value="/spitter/register" />">Register</a>
</body>
</html>
