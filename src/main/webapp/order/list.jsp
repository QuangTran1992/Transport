<%--
  Created by IntelliJ IDEA.
  User: mebemint
  Date: 2021/08/04
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
* <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Management Application</title>
    <%@include file="/layout/head.jsp"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <script src="../js/sweetalert2.min.js"></script>
    <link rel="stylesheet" href="../css/sweetalert2.min.css">

</head>
<body class="sb-nav-fixed">

    <%--Start header--%>
    <%@include file="/layout/header.jsp"%>
    <%--Header end--%>

    <div id="layoutSidenav">

        <%--Start navigation left--%>
        <%@include file="/layout/nav-left.jsp"%>
        <%--Header end--%>

        <div id="layoutSidenav_content">

            <%--Start content--%>
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Order Management</h1>
                    <div class="d-flex bd-highlight border border-secondary">
                        <div class="mr-auto p-2 bd-highlight">
                            <h2>
                                <a href="/orders?action=create"><button>Add New Order</button></a>
                            </h2>
                        </div>
                        <div class="p-2 bd-highlight mr-0">
                            <form action="orders?action=search" method="post">
                                <input type="text" placeholder="Search..." name="key">
                                <input type="submit" value="Search">
                            </form>
                        </div>
                    </div>
                    <div class="card mb-4">
                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Customer Name</th>
                                        <th>Phone</th>
                                        <th>Address</th>
                                        <th>Product Name</th>
                                        <th>Product Price</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>ID</th>
                                    <th>Customer Name</th>
                                    <th>Phone</th>
                                    <th>Address</th>
                                    <th>Product Name</th>
                                    <th>Product Price</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                                </tfoot>
                                    <c:forEach var="order" items="${listOrder}">
                                        <tbody>
                                        <tr>
                                            <td><c:out value="${order.id}"/></td>
                                            <td><c:out value="${order.cus_name}"/></td>
                                            <td><c:out value="${order.phone}"/></td>
                                            <td><c:out value="${order.address}"/></td>
                                            <td><c:out value="${order.product_name}"/></td>
                                            <td style="text-align: right"><strong><fmt:formatNumber value="${order.product_price}" type="currency" currencySymbol="$"></fmt:formatNumber></strong></td>
                                            <td><c:out value="${order.status}"/></td>
                                            <td >
                                                <a style="color: darkcyan;" href="/orders?action=edit&id=${order.id}" title="Edit"><i class="fas fa-edit fa-2x"></i></a>
                                                    <%--                    <a href="/orders?action=delete&id=${order.id}" title="Delete"><i class="fas fa-trash-alt fa-2x"></i></a>--%>
                                                <a style="color: rebeccapurple;" onclick="deleteOrder(${order.id})" title="Delete"><i class="fas fa-trash-alt fa-2x"></i></a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </main>
            <%--Content end--%>

            <%--Start footer--%>
            <%@include file="/layout/footer.jsp"%>
            <%--Footer end--%>
        </div>

    </div>

    <script>
    function deleteOrder(id){
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                ).then(()=>{
                    window.location.href = "/orders?action=delete&id=" + id;
                })
            }
        })
    }

    </script>

    <%--Start footer--%>
    <%@include file="/layout/script.jsp"%>
    <%--Footer end--%>

<%--<center>--%>
<%--    <h1>User Management</h1>--%>
<%--    <h2>--%>
<%--        <a href="/orders?action=create">Add New Order</a>--%>
<%--    </h2>--%>
<%--    <form action="orders?action=search" method="post">--%>
<%--        <input type="text" placeholder="Search..." name="key">--%>
<%--        <input type="submit" value="Search">--%>
<%--    </form>--%>
<%--</center>--%>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>

<%--        <tr class="table-success">--%>
<%--            <th>ID</th>--%>
<%--            <th>Customer Name</th>--%>
<%--            <th>Phone</th>--%>
<%--            <th>Address</th>--%>
<%--            <th>Product Name</th>--%>
<%--            <th>Product Price</th>--%>
<%--            <th>Status</th>--%>
<%--            <th>Action</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="order" items="${listOrder}">--%>
<%--            <tr class="table-active">--%>
<%--                <td><c:out value="${order.id}"/></td>--%>
<%--                <td><c:out value="${order.cus_name}"/></td>--%>
<%--                <td><c:out value="${order.phone}"/></td>--%>
<%--                <td><c:out value="${order.address}"/></td>--%>
<%--                <td><c:out value="${order.product_name}"/></td>--%>
<%--                <td style="text-align: right"><strong><fmt:formatNumber value="${order.product_price}" type="currency" currencySymbol="$"></fmt:formatNumber></strong></td>--%>
<%--                <td><c:out value="${order.status}"/></td>--%>
<%--                <td >--%>
<%--                    <a style="color: darkcyan;" href="/orders?action=edit&id=${order.id}" title="Edit"><i class="fas fa-edit fa-2x"></i></a>--%>
<%--&lt;%&ndash;                    <a href="/orders?action=delete&id=${order.id}" title="Delete"><i class="fas fa-trash-alt fa-2x"></i></a>&ndash;%&gt;--%>
<%--                    <a style="color: rebeccapurple;" onclick="deleteOrder(${order.id})" title="Delete"><i class="fas fa-trash-alt fa-2x"></i></a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<%--<script>--%>
<%--function deleteOrder(id){--%>
<%--    Swal.fire({--%>
<%--        title: 'Are you sure?',--%>
<%--        text: "You won't be able to revert this!",--%>
<%--        icon: 'warning',--%>
<%--        showCancelButton: true,--%>
<%--        confirmButtonColor: '#3085d6',--%>
<%--        cancelButtonColor: '#d33',--%>
<%--        confirmButtonText: 'Yes, delete it!'--%>
<%--    }).then((result) => {--%>
<%--        if (result.isConfirmed) {--%>
<%--            Swal.fire(--%>
<%--                'Deleted!',--%>
<%--                'Your file has been deleted.',--%>
<%--                'success'--%>
<%--            ).then(()=>{--%>
<%--                window.location.href = "/orders?action=delete&id=" + id;--%>
<%--            })--%>
<%--        }--%>
<%--    })--%>
<%--}--%>
<%--</script>--%>
</body>
</html>
