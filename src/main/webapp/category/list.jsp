<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CATEGORIES</title>
</head>
<style>
    table, tr, td {
        border-collapse: collapse;
        border: black solid 1px;
    }
    td {
        text-align: center;
        width: 200px;
    }
</style>
<body>
<h2>All Categories</h2>
<a href="/categories?action=create">Create new category</a>
<form action="/categories" method="get" style="display: inline">
    <input type="hidden" name="action" value="findByName">
    <input type="text" name="nameSearch">
    <input type="submit" value="Search">
</form>
<c:if test="${mes!= null}">
    <span>${mes}</span>
</c:if>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td></td>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.idCategory}</td>
            <td>${category.name}</td>
            <td>
                <a href="/categories?action=edit&id=${category.idCategory}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
