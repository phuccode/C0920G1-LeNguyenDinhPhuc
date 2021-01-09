package controller;

import model.BenhNhan;
import model.Customer;
import repository.BenhNhanRepository;
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

@WebServlet(name = "BenhNhanServlet", urlPatterns = "/customers")
public class BenhNhanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BenhNhanRepository benhNhanRepository;
    public void init() {
        benhNhanRepository = new BenhNhanRepository();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                try {
                    updateCus(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void updateCus(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int ma_benh_nhan = Integer.parseInt(request.getParameter("ma_benh_nhan"));
        String ten_benh_nhan = request.getParameter("ten_benh_nhan");
        String ngay_nhap_vien = request.getParameter("ngay_nhap_vien");
        String ngay_ra_vien = request.getParameter("ngay_ra_vien");
        String ly_do_nhap_vien = request.getParameter("ly_do_nhap_vien");
        int ma_benh_an = Integer.parseInt(request.getParameter("ma_benh_an"));
        BenhNhan benhNhan = new BenhNhan(ma_benh_nhan,ten_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien,
                ma_benh_an);
        benhNhanRepository.update(benhNhan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
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
            default:
                listCus(request, response);
                break;
        }
    }

    private void listCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BenhNhan> benhNhanList = benhNhanRepository.selectAll();
        request.setAttribute("benhNhanList", benhNhanList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCus(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int ma_benh_nhan = Integer.parseInt(request.getParameter("ma_benh_nhan"));
        benhNhanRepository.delete(ma_benh_nhan);
        List<BenhNhan> listCus = benhNhanRepository.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        request.setAttribute("customerList", listCus);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ma_benh_nhan = Integer.parseInt(request.getParameter("ma_benh_nhan"));
        BenhNhan benhNhan = benhNhanRepository.select(ma_benh_nhan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("benhNhan", benhNhan);
        dispatcher.forward(request, response);
    }
}
