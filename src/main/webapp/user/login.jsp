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
    <link rel="stylesheet" href="css/login.css">
    <title>Title</title>
</head>
<body>
<div class="login">
    <h2>User Login</h2>
    <form action="http://localhost:8080/users?act=loginSuccess" method="post">
        <form method="post">
<%--            <p>UserName</p>--%>
            <input type="text" name="username">
<%--            <p>Password</p>--%>
            <input type="password" name="password">
            <button>Login</button>
            <button><a href=http://localhost:8080/users?act=create>Register</a></button>
        </form>
    </form>
    <p>
        <c:if test="${mes!= null}">
            <span>${mes}</span>
        </c:if>
    </p>
</div>



</body>
</html>
