<%--
  Created by IntelliJ IDEA.
  User: mebemint
  Date: 2021/08/04
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="orders?action=orders">List All Orders</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Order
                </h2>
            </caption>
            <c:if test="${order != null}">
                <input type="hidden" name="id" value="<c:out value='${order.id}' />"/>
            </c:if>
            <tr>
                <th>Customer_Name:</th>
                <td>
                    <input type="text" name="cus_name" size="45"
                           value="<c:out value='${order.cus_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer_Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${order.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address :</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${order.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product_Name :</th>
                <td>
                    <input type="text" name="product_name" size="15"
                           value="<c:out value='${order.product_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product_price :</th>
                <td>
                    <input type="text" name="product_price" size="15"
                           value="<c:out value='${order.product_price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Status :</th>
                <td>
                    <input type="text" name="status" size="15"
                           value="<c:out value='${order.status}' />"
                    />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
