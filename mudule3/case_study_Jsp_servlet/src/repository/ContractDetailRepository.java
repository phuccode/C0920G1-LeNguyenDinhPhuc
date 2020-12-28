package repository;

import connection.MySQLConnection;
import model.Contract;
import model.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements CRUD<ContractDetail> {
    MySQLConnection mySQLConnection = new MySQLConnection();
    private static final String INSERT_CON_SQL = "INSERT INTO contract_detail" + " (contract_id, " +
            "attach_service_id,quantity) VALUE " +
            " (?,?,?,?,?,?,?);";

    private static final String SELECT_ALL_CON = "select * from contract_detail";

    @Override
    public List<ContractDetail> selectAll() {
        List<ContractDetail> contractDetails = new ArrayList<>();
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CON);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int contract_detail_id = rs.getInt("contract_detail_id");
                int contract_id = rs.getInt("contract_id");
                int attach_service_id = rs.getInt("attach_service_id");
                int quantity = rs.getInt("quantity");
                contractDetails.add(new ContractDetail(contract_detail_id, contract_id, attach_service_id, quantity));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractDetails;
    }

    @Override
    public void insert(ContractDetail contractDetail) throws SQLException {
        System.out.println(INSERT_CON_SQL);
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CON_SQL)) {
            preparedStatement.setInt(1, contractDetail.getContractId());
            preparedStatement.setInt(2, contractDetail.getAttachServiceId());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public ContractDetail select(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ContractDetail contractDetail) throws SQLException {
        return false;
    }

    @Override
    public List<ContractDetail> search(String name) {
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
