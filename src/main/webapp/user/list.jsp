<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 10/6/2023
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
  Created by IntelliJ IDEA.
  User: FPTSHOP
  Date: 10/5/2023
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--    <h2>${user.idUser}, ${user.name}, ${user.userName}</h2>--%>
    <table border="1">
        <tr>
            <th>UserId</th>
            <th>Name</th>
            <th>UserName</th>
            <th>Manage</th>

        </tr>
        <c:forEach var="user" items="${dsUS}" >
            <tr>
                <td>${user.idUser}</td>
                <td>${user.name}</td>
                <td>${user.userName}</td>



                <td><a href="http://localhost:8080/users?act=delete&id=${user.idUser}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

</body>
</html>
