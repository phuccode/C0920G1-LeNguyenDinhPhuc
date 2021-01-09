package controller;

import common.*;
import model.Customer;
import repository.CustomerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerRepository customerRepository;
    public void init() {
        customerRepository = new CustomerRepository();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertCus(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateCus(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                try {
                    deleteCus(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                listCustomerByKeyword(request, response);
                break;
            default:
                listCus(request, response);
                break;
        }
    }

    private void listCustomerByKeyword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("customer_name");
        List<Customer> customerList = customerRepository.search(name);
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String customer_name = request.getParameter("customer_name");
        String customer_birthday = request.getParameter("customer_birthday");
        String customer_gender = request.getParameter("customer_gender");
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        Customer customer = new Customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,
                customer_id_card,customer_phone,customer_email,customer_address);
        customerRepository.update(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
//        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
//        String customer_name = request.getParameter("customer_name");
//        String customer_birthday = request.getParameter("customer_birthday");
//        String customer_gender = request.getParameter("customer_gender");
//        String customer_id_card = request.getParameter("customer_id_card");
//        String customer_phone = request.getParameter("customer_phone");
//        String customer_email = request.getParameter("customer_email");
//        String customer_address = request.getParameter("customer_address");
//        String messageID = null;
//        String messageBirthday = null;
//        String messageNumberPhone = null;
//        String messageIdCard = null;
//        String messageEmail = null;
//        Customer newCus = new Customer(customer_type_id, customer_name,customer_birthday,customer_gender,
//                customer_id_card,customer_phone,customer_email,customer_address);
//        RequestDispatcher dispatcher;
//        List<Customer> customerList = customerRepository.selectAll();
//        if (!Validate.checkBirthday(customer_birthday)) {
//            messageBirthday = "yyyy-mm-dd";
//        }else if (!Validate.checkNumberPhone(customer_phone)){
//            messageNumberPhone = "84xxxxxxxxx";
//        }else if (!Validate.checkIdCard(customer_id_card)){
//            messageIdCard = "xxxxxxxxx";
//        }else if (!Validate.checkEmail(customer_email)){
//            messageEmail = "xxx@xxx.xxx";
//        } else if (checkCus != null) {
//            messageID = "The id you entered is identical";
//        } else {
//            customerRepository.insert(newCus);
//            customerList = customerRepository.selectAll();
//        }
//        request.setAttribute("messageID", messageID);
//        request.setAttribute("messageBirthday", messageBirthday);
//        request.setAttribute("messageNumberPhone",messageNumberPhone);
//        request.setAttribute("messageIdCard",messageIdCard);
//        request.setAttribute("messageEmail",messageEmail);
//        request.setAttribute("customerList", customerList);
//        dispatcher = request.getRequestDispatcher("view/Customer/create.jsp");
//        customerRepository.insert(newCus);
//        dispatcher = request.getRequestDispatcher("customer/create.jsp");
//        dispatcher.forward(request, response);
        boolean flag = true;
//        String messageId = null;
        String messageBirthday = null;
        String messageIdCard = null;
        String messagePhone = null;
        String messageEmail = null;
//        String id = null;
//        try {
//            id = request.getParameter("id");
//            Validate.regexCustomerId(id);
//        } catch (IdException e) {
//            messageId = e.getMessage();
//            flag = false;
//        }
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));

        String name = request.getParameter("customer_name");
        System.out.println(name);

        String birthday = null;
        try {
            birthday = request.getParameter("customer_birthday");
            Validate.regexDate(birthday);
        } catch (DateException e) {
            messageBirthday = e.getMessage();
            flag = false;
        }

        String gender = request.getParameter("customer_gender");

        String idCard = null;
        try {
            idCard = request.getParameter("customer_id_card");
            Validate.regexIdCard(idCard);
        } catch (IdCardException e) {
            messageIdCard = e.getMessage();
            flag = false;
        }

        String phoneNumber = null;
        try {
            phoneNumber = request.getParameter("customer_phone");
            Validate.regexPhone(phoneNumber);
        } catch (NumberPhoneException e) {
            messagePhone = e.getMessage();
            flag = false;
        }

        String email = null;
        try {
            email = request.getParameter("customer_email");
            Validate.regexEmail(email);
        } catch (EmailException e) {
            messageEmail = e.getMessage();
            flag = false;
        }
        String address = request.getParameter("customer_address");
        if (!flag) {
            request.setAttribute("messageBirthday", messageBirthday);
            request.setAttribute("messageIdCard", messageIdCard);
            request.setAttribute("messagePhone", messagePhone);
            request.setAttribute("messageEmail", messageEmail);
            showNewForm(request, response);
        } else {
            Customer customer = new Customer(customer_type_id,name, birthday, idCard, phoneNumber, email, address, gender);
            customerRepository.insert(customer);
        }
    }

    private void deleteCus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        customerRepository.delete(customer_id);
        List<Customer> listCus = customerRepository.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        request.setAttribute("customerList", listCus);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = customerRepository.select(customer_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listCus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> customerList = customerRepository.selectAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }
}
