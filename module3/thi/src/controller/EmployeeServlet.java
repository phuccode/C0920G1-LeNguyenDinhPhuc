package controller;

import model.Customer;
import model.Employee;
import repository.EmployeeRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeRepository employeeRepository;
    public void init() {
        employeeRepository = new EmployeeRepository();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertEmp(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateEmp(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    deleteEmp(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                listEmpByKeyword(request, response);
                break;
            default:
                listEmp(request, response);
                break;
        }
    }

    private void listEmpByKeyword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("employee_name");
        List<Employee> employeeList = employeeRepository.search(name);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> employeeList = employeeRepository.selectAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        Employee employee = employeeRepository.select(employee_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        employeeRepository.delete(employee_id);
        List<Employee> listCus = employeeRepository.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        request.setAttribute("employeeList", listCus);
        dispatcher.forward(request, response);
    }

    private void updateEmp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        double employee_salary = Double.parseDouble(request.getParameter("employee_salary"));
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));
        String user_name = request.getParameter("user_name");
        Employee employee = new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,
                employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,user_name);
        employeeRepository.update(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String employee_name = request.getParameter("employee_name");
        String employee_birthday = request.getParameter("employee_birthday");
        String employee_id_card = request.getParameter("employee_id_card");
        double employee_salary = Double.parseDouble(request.getParameter("employee_salary"));
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));
        String user_name = request.getParameter("user_name");
        Employee employee = new Employee(employee_name,employee_birthday,employee_id_card,employee_salary,
                employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,user_name);
        employeeRepository.insert(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }
}
