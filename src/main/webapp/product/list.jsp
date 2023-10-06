<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2023
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PRODUCTS</title>
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
    tr img {
        width: 100px;
        height: 100px;
    }
</style>
<body>
<h2>All Products</h2>
<h3>
    <a href="/products?action=create">Create new product</a>
</h3>
<h3></h3>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Description</td>
        <td>Category</td>
        <td>Image</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.idProduct}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td>${p.description}</td>
            <td>${p.category.name}</td>
            <td>
                <img src="${p.getImg()}" alt="img product">
            </td>
            <td>
                <a href="/products?action=edit&id=${p.idProduct}&">Edit</a>
            </td>
            <td>
                <a href="/products?action=delete&id=${p.idProduct}&">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
