<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
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
<h1>Xin chào ${username}</h1>
<a href="/users?act=login">SignOut</a>

<h2>All Products</h2>
<h3>
    <a href="/products?action=create">Create new product</a>
    <form action="/products" method="get" style="display: inline">
        <input type="hidden" name="action" value="findByName">
        <input type="text" name="nameSearch">
        <input type="submit" value="Search">
    </form>
    <a href="/orders">Cart</a>
    <a href="/categories">Category</a>
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
                <a class="btn btn-success" href="/products?action=edit&id=${p.idProduct} ">Edit</a>
                <form class="btn btn-success" action="/products" id="delete${p.idProduct}" method="post" style="display: inline">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="idProduct" value="${p.idProduct}">
                    <a onclick="confirmDelete(${p.idProduct})">Delete</a>
                </form>
                <form action="/orders" method="post" style="display: inline">
                    <input type="hidden" name="action" value="buy">
                    <input type="hidden" name="idProduct" value="${p.idProduct}">
                    <input class="btn btn-success" type="submit" value="Buy">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    function confirmDelete(id) {
        if (confirm("Are you sure?")) {
            document.getElementById("delete" + id).submit();
        }
    }
    function displayProduct() {
        document.getElementById("show").submit();
    }
</script>
</html>
