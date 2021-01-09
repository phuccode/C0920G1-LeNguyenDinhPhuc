package repository;

import connnection.MySQLConnection;
import model.BenhAn;
import model.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements CRUD<BenhAn>{
    MySQLConnection mySQLConnection = new MySQLConnection();
    private static final String INSERT_BENHNHAN_SQL = "INSERT INTO benhan" + "  (ma_benh_an,phuong_phap, " +
            "bac_si " + " (?,?,?);";

    private static final String SELECT_BENHNHAN_BY_ID = "select * from benhan where ma_benh_an =?";
    private static final String SELECT_ALL_BENHNHAN = "select * from benhan";
    private static final String DELETE_BENHNHAN_SQL = "delete from benhan where ma_benh_an = ?;";
    private static final String UPDATE_BENHNHAN_SQL = "update benhan set  ma_benh_an = ?, phuong_phap= ?, bac_si = ?," +
            "where ma_benh_an = ?";

    @Override
    public List<BenhAn> selectAll() {
        List<BenhAn> benhAns = new ArrayList<>();
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BENHNHAN);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ma_benh_an = rs.getInt("ma_benh_an");
                String phuong_phap = rs.getString("phuong_phap");
                String bac_si = rs.getString("bac_si");
                benhAns.add(new BenhAn(ma_benh_an,
                        phuong_phap, bac_si));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benhAns;
    }

    @Override
    public void insert(BenhAn benhAn) throws SQLException {

    }


    @Override
    public BenhAn select(int id) {
        BenhAn benhAn = null;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENHNHAN_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String phuong_phap = rs.getString("phuong_phap");
                String bac_si = rs.getString("bac_si");
                benhAn = new BenhAn(id, phuong_phap, bac_si);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benhAn;
    }

    @Override
    public BenhAn select(String ma_benh_nhan) {
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
    public boolean update(BenhAn benhAn) throws SQLException {

        boolean rowUpdated;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENHNHAN_SQL);) {
            preparedStatement.setString(1, benhAn.getPhuongPhap());
            preparedStatement.setString(2, benhAn.getBacSi());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }



    @Override
    public List<BenhAn> search(String name) {
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
