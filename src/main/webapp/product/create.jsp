<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2023
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<form class="needs-validation" novalidate>
    <div class="form-row">
        <div class="col-md-6 mb-3">
            <label>Name of product:</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="col-md-6 mb-3">
            <label>Quantity of product:</label>
            <input type="number" class="form-control" name="quantity">
        </div>
    </div>
    <div class="form-row">
        <div class="col-md-6 mb-3">
            <label>Price of product:</label>
            <input type="number" class="form-control" name="price">
        </div>
        <div class="col-md-6 mb-3">
            <label>Url image of product:</label>
            <input type="text" class="form-control" name="img">
        </div>
    </div>
    <div class="form-row">
        <div class="col-p0hymd-6 mb-3">
            <label>Description of product:</label>
            <input type="text" class="form-control" name="description>
        </div>
        <div class="col-md-6 mb-3">
            <label>Category</label>
            <select class="custom-select" name="nameCategory">
                <c:forEach items="${categories}" var="category">
                    <option>${category.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <button class="btn btn-primary" type="submit">Submit form</button>
</form>
</body>
</html>
