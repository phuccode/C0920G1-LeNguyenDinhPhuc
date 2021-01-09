package repository;

import connection.MySQLConnection;
import model.BenhNhan;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepository implements CRUD<BenhNhan> {
    MySQLConnection mySQLConnection = new MySQLConnection();
    private static final String INSERT_BENHNHAN_SQL = "INSERT INTO benhnhan" + "  (ma_benh_nhan,ten_benh_nhan, " +
            "ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien, " +
            "ma_benh_an " + " (?,?,?,?,?,?);";

    private static final String SELECT_BENHNHAN_BY_ID = "select * from benhnhan where ma_benh_nhan =?";
    private static final String SELECT_ALL_BENHNHAN = "select * from benhnhan";
    private static final String DELETE_BENHNHAN_SQL = "delete from benhnhan where ma_benh_nhan = ?;";
    private static final String UPDATE_BENHNHAN_SQL = "update benhnhan set  ma_benh_nhan = ?, ten_benh_nhan= ?, ngay_nhap_vien = ?," +
            "ngay_ra_vien = ?,ly_do_nhap_vien = ?, ma_benh_an = ? where ma_benh_nhan = ?";

    @Override
    public List<BenhNhan> selectAll() {
        List<BenhNhan> benhNhans = new ArrayList<>();
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BENHNHAN);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ma_benh_nhan = rs.getInt("ma_benh_nhan");
                String ten_benh_nhan = rs.getString("ten_benh_nhan");
                String ngay_nhap_vien = rs.getString("ngay_nhap_vien");
                String ngay_ra_vien = rs.getString("ngay_ra_vien");
                String ly_do_nhap_vien = rs.getString("ly_do_nhap_vien");
                int ma_benh_an = rs.getInt("ma_benh_an");
                benhNhans.add(new BenhNhan(ma_benh_nhan,
                        ten_benh_nhan, ngay_nhap_vien, ngay_ra_vien, ly_do_nhap_vien, ma_benh_an));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benhNhans;
    }

    @Override
    public void insert(BenhNhan benhNhan) throws SQLException {

    }

    @Override
    public BenhNhan select(int id) {
        BenhNhan benhNhan = null;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENHNHAN_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String ten_benh_nhan = rs.getString("ten_benh_nhan");
                String ngay_nhap_vien = rs.getString("ngay_nhap_vien");
                String ngay_ra_vien = rs.getString("ngay_ra_vien");
                String ly_do_nhap_vien = rs.getString("ly_do_nhap_vien");
                int ma_benh_an = rs.getInt("ma_benh_an");
                benhNhan = new BenhNhan(id, ten_benh_nhan, ngay_nhap_vien, ngay_ra_vien,
                        ly_do_nhap_vien, ma_benh_an);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benhNhan;
    }

    @Override
    public BenhNhan select(String ma_benh_nhan) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BENHNHAN_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(BenhNhan benhNhan) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENHNHAN_SQL);) {
            preparedStatement.setString(1, benhNhan.getTenBenhNhan());
            preparedStatement.setString(2, benhNhan.getNgayNhapVien());
            preparedStatement.setString(3, benhNhan.getNgayRaVien());
            preparedStatement.setString(4, benhNhan.getLyDoNhapVien());
            preparedStatement.setInt(5, benhNhan.getMaBenhAn());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    @Override
    public List<BenhNhan> search(String name) {
        return null;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
