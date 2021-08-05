package quang.com.controller;

import quang.com.dao.OrderDAO;
import quang.com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("layout/loginForm.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user_name");
        String passWord = request.getParameter("password");
        OrderDAO orderDAO = new OrderDAO();
        boolean b = orderDAO.verifyUser(userName,passWord);
        if (!b){
            request.setAttribute("text", "Error");
            request.getRequestDispatcher("/layout/loginForm.jsp").forward(request,response);
        }else{
            response.sendRedirect("/orders");
        }
    }
}
