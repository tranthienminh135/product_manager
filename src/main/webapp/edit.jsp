<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2/20/2024
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product" method="post">
    <table>
        <h1>UPDATE PRODUCT</h1>
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${product.id}">
        <thead>
        <tr>
            <th>
                <label for="name">Name: </label>
            </th>
            <th>
                <input type="text" id="name" name="name" value="${product.productName}"/>
            </th>
        </tr>
        <tr>
            <th>
                <label for="price">Price: </label>
            </th>
            <th>
                <input type="text" id="price" name="price" value="${product.productPrice}"/>
            </th>
        </tr>
        <tr>
            <th>
                <label for="category">Category: </label>
            </th>
            <th>
                <select name="category" id="category">
                    <c:forEach items="${categories}" var="category">
                        <c:if test="${product.categoryId == category.id}">
                            <option value="${category.id}" selected>${category.categoryName}</option>
                        </c:if>
                        <c:if test="${product.categoryId != category.id}">
                            <option value="${category.id}">${category.categoryName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </th>
        </tr>
        <tr>
            <th>
                <a href="/product">Back</a>
            </th>
            <th>
                <button>Update</button>
            </th>
        </tr>
        </thead>
    </table>
</form>
</body>
</html>
