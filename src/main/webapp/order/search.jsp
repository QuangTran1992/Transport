<%--
  Created by IntelliJ IDEA.
  User: mebemint
  Date: 2021/08/04
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Order Management Application</title>
</head>
<center>

    <table class="table mb-0" border="1">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Customer_Name</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Product_Name</th>
            <th>Product_Price</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${order}">
            <tr>
                <td><c:out value="${order.id}"/></td>
                <td><c:out value="${order.cus_name}"/></td>
                <td><c:out value="${order.phone}"/></td>
                <td><c:out value="${order.address}"/></td>
                <td><c:out value="${order.product_name}"/></td>
                <td><c:out value="${order.product_price}"/></td>
                <td><c:out value="${order.status}"/></td>
                <td>
                    <a href="/orders?action=edit&id=${order.id}">Edit</a>
                    <a href="/orders?action=delete&id=${order.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
</div>
</body>
</html>
