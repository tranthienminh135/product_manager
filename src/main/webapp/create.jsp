<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2/20/2024
  Time: 5:24 PM
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
        <h1>CREATE PRODUCT</h1>
        <input type="hidden" name="action" value="create">
        <thead>
        <tr>
            <th>
                <label for="name">Name: </label>
            </th>
            <th>
                <input type="text" id="name" name="name"/>
            </th>
        </tr>
        <tr>
            <th>
                <label for="price">Price: </label>
            </th>
            <th>
                <input type="text" id="price" name="price"/>
            </th>
        </tr>
        <tr>
            <th>
                <label for="price">Category: </label>
            </th>
            <th>
                <select name="category">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </th>
        </tr>
        <tr>
            <th>
                <a href="/product">Back</a>
            </th>
            <th>
                <button>Create</button>
            </th>
        </tr>
        </thead>
    </table>
</form>
</body>
</html>
