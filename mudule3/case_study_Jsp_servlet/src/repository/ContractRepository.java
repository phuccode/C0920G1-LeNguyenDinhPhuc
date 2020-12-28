package repository;

import connection.MySQLConnection;
import model.Contract;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements CRUD<Contract>{
    MySQLConnection mySQLConnection = new MySQLConnection();
    private static final String INSERT_CON_SQL = "INSERT INTO contract" + "  (contract_start_date,contract_end_date, " +
            "contract_deposit,contract_total_money,employee_id, " +
            "customer_id,service_id) VALUE " +
            " (?,?,?,?,?,?,?);";

    private static final String SELECT_ALL_CON = "select * from contract";

    @Override
    public List<Contract> selectAll() {
        List<Contract> contracts = new ArrayList<>();
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CON);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int contract_id = rs.getInt("contract_id");
                String contract_start_date = rs.getString("contract_start_date");
                String contract_end_date = rs.getString("contract_end_date");
                double contract_deposit = rs.getDouble("contract_deposit");
                double contract_total_money = rs.getDouble("contract_total_money");
                int employee_id = rs.getInt("employee_id");
                int customer_id = rs.getInt("customer_id");
                int service_id = rs.getInt("service_id");
                contracts.add(new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit,
                        contract_total_money, employee_id, customer_id, service_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contracts;
    }

    @Override
    public void insert(Contract contract) throws SQLException {
        System.out.println(INSERT_CON_SQL);
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CON_SQL)) {
            preparedStatement.setString(1, contract.getContractStartDate());
            preparedStatement.setString(2, contract.getContractEndDate());
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setDouble(4, contract.getContractTotalMoney());
            preparedStatement.setInt(5, contract.getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getServiceId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Contract select(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Contract contract) throws SQLException {
        return false;
    }

    @Override
    public List<Contract> search(String name) {
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
