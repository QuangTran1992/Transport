<%--
  Created by IntelliJ IDEA.
  User: mebemint
  Date: 2021/08/04
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order Management Application</title>
</head>
<body>
<center>
    <h1>Order Management</h1>
    <h2>
        <a href="/orders">List All Orders</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Order</h2>
            </caption>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="cus_name"size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="cus_phonenumber" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address :</th>
                <td>
                    <input type="text" name="address" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Product_name :</th>
                <td>
                    <input type="text" name="product_name" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Product_price :</th>
                <td>
                    <input type="text" name="product_price" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Status :</th>
                <td>
                    <input type="text" name="status" size="15"/>
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
