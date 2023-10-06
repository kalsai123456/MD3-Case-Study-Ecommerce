<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 10/6/2023
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="http://localhost:8080/users?act=loginSuccess" method="post">
    <form method="post">
        <input type="text" name="username">
        <input type="text" name="password">
        <button>Login</button>
    </form>
</form>
<c:if test="${mes!= null}">
    <span>${mes}</span>
</c:if>
<a href=http://localhost:8080/users?act=create>Register</a>
</body>
</html>
