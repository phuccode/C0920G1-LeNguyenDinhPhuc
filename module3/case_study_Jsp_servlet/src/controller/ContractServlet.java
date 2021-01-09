package controller;

import model.Contract;
import model.Service;
import repository.ContractRepository;
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

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContractRepository contractRepository;
    public void init() {
        contractRepository = new ContractRepository();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertCon(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void insertCon(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String contract_start_date = request.getParameter("contract_start_date");
        String contract_end_date = request.getParameter("contract_end_date");
        double contract_deposit = Double.parseDouble(request.getParameter("contract_deposit"));
        double contract_total_money = Double.parseDouble(request.getParameter("contract_total_money"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Contract contract = new Contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,
                employee_id,customer_id,service_id);
        contractRepository.insert(contract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
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
                listCon(request, response);
                break;
        }
    }

    private void listCon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contract> contractList = contractRepository.selectAll();
        request.setAttribute("contractList", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        dispatcher.forward(request, response);
    }
}
