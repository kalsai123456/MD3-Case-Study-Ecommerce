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
    <form action="/products" method="get" style="display: inline">
        <input type="hidden" name="action" value="findByName">
        <input type="text" name="nameSearch">
        <input type="submit" value="Search">
    </form>
</h3>
<c:if test="${mes!= null}">
    <span>${mes}</span>
</c:if>
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
                <a href="/products?action=edit&id=${p.idProduct}">Edit</a>
            </td>
            <td>
                <form action="/products" id="delete${p.idProduct}" method="post" style="display: inline">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="idProduct" value="${p.idProduct}">
                    <a onclick="confirmDelete(${p.idProduct})">Delete</a>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    function confirmDelete(id) {
        if (confirm("Are you sure?")) {
            document.getElementById("delete"+id).submit();
        }
    }
</script>
</html>
