package controller;

import model.Customer;
import repository.AccountRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/account")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                try {
                    login(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "logout":
                logout(request,response);
                break;
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/account/login.jsp");
        dispatch.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");

            boolean isValid = AccountRepository.checkLogin(username, password);

            if (isValid) {
                HttpSession session = request.getSession();

                session.setAttribute("namelogin", username);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/account/login.jsp");
                dispatch.forward(request, response);
            }
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
