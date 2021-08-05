package quang.com.controller;

import quang.com.dao.OrderDAO;
import quang.com.model.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private OrderDAO orderDAO;

    public void init() {
        orderDAO = new OrderDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertOrder(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateOrder(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                try {
                    searchByName(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                        showNewForm(request, response);
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteOrder(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    listOrder(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }



    private void listOrder(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
            List<Order> listOrders = orderDAO.selectAllOrders();
            request.setAttribute("listOrder", listOrders);
            RequestDispatcher dispatcher = request.getRequestDispatcher("order/list.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/create.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order existingOrder = orderDAO.selectOrder(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/edit.jsp");
        request.setAttribute("order", existingOrder);
        dispatcher.forward(request, response);
    }
    private void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String cus_name = request.getParameter("cus_name");
        String cus_phonenumber = request.getParameter("cus_phonenumber");
        String address = request.getParameter("address");
        String product_name = request.getParameter("product_name");
        float product_price = Float.parseFloat(request.getParameter("product_price"));
        String status = request.getParameter("status");

        Order newOrder = new Order(cus_name, cus_phonenumber, address, product_name, product_price, status);
        orderDAO.insertOrder(newOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/create.jsp");
        dispatcher.forward(request, response);
    }
    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String cus_name = request.getParameter("cus_name");
        String cus_phonenumber = request.getParameter("cus_phonenumber");
        String address = request.getParameter("address");
        String product_name = request.getParameter("product_name");
        float product_price = Float.parseFloat(request.getParameter("product_price"));
        String status = request.getParameter("status");

        Order order = new Order(id,cus_name, cus_phonenumber, address,product_name,product_price,status);
        orderDAO.updateOrder(order);
        response.sendRedirect("orders");
    }
    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderDAO.deleteOrder(id);

        List<Order> listOrder = orderDAO.selectAllOrders();
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/list.jsp");
        dispatcher.forward(request, response);
    }
    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String key = request.getParameter("key");
        List<Order> orderList = orderDAO.find(key);

        request.setAttribute("order",orderList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("order/search.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
