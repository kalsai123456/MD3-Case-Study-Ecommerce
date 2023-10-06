<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 10/6/2023
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
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
        <button>Add</button>
    </form>
</form>
<a href=http://localhost:8080/users?act=create>Sign Up</a>
</body>
</html>
