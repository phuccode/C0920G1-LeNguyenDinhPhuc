package controller;

import model.ContractDetail;
import repository.ContractDetailRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contractDetails")
public class ContractDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContractDetailRepository contractDetailRepository;
    public void init() {
        contractDetailRepository = new ContractDetailRepository();
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
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(contract_id,attach_service_id,quantity);
        contractDetailRepository.insert(contractDetail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract_detail/create.jsp");
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
        List<ContractDetail> contractDetailList = contractDetailRepository.selectAll();
        request.setAttribute("contractDetailList", contractDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract_detail/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract_detail/create.jsp");
        dispatcher.forward(request, response);
    }
}
