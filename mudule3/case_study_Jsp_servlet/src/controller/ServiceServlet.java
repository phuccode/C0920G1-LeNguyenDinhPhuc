package controller;

import model.Employee;
import model.Service;
import repository.ServiceRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServiceRepository serviceRepository;
    public void init() {
        serviceRepository = new ServiceRepository();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertSer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void insertSer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String service_name = request.getParameter("service_name");
        int service_area = Integer.parseInt(request.getParameter("service_area"));
        double service_cost = Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));
        Service service = new Service(service_name,service_area,service_cost,service_max_people,
                rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,
                number_of_floors);
        serviceRepository.insert(service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            default:
                listEmp(request, response);
                break;
        }
    }

    private void listEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Service> serviceList = serviceRepository.selectAll();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request, response);
    }
}
