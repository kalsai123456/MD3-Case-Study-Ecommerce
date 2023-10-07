<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/users?act=create" method="post">
    <form method="post">
        <input type="text" name="iduser">
        <input type="text" name="name">
        <input type="text" name="username">
        <input type="text" name="password">
        <button>Register</button>
    </form>
</form>
</body>
</html>
