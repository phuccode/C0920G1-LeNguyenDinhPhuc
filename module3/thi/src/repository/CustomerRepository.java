package repository;

import connection.MySQLConnection;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements CRUD<Customer> {

    MySQLConnection mySQLConnection = new MySQLConnection();

    private static final String INSERT_CUS_SQL = "INSERT INTO customer" + "  (customer_type_id,customer_name, " +
            "customer_birthday,customer_gender,customer_id_card, " +
            "customer_phone,customer_email,customer_address) VALUE " +
            " (?,?,?,?,?,?,?,?);";

    private static final String SELECT_CUS_BY_ID = "select * from customer where customer_id =?";
    private static final String SELECT_ALL_CUS = "select * from customer";
    private static final String DELETE_CUS_SQL = "delete from customer where customer_id = ?;";
        private static final String UPDATE_CUS_SQL = "update customer set  customer_type_id = ?, customer_name= ?, customer_birthday = ?," +
            "customer_gender = ?,customer_id_card = ?, customer_phone = ?,customer_email= ?,customer_address = ? where customer_id = ?";


    @Override
    public List<Customer> selectAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUS);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                int customer_type_id = rs.getInt("customer_type_id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                String customer_gender = rs.getString("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email = rs.getString("customer_email");
                String customer_address = rs.getString("customer_address");
                customers.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday,
                        customer_gender, customer_id_card, customer_phone, customer_email, customer_address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public void insert(Customer customer) throws SQLException {
        System.out.println(INSERT_CUS_SQL);
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUS_SQL)) {
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setString(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Customer select(int id) {
        Customer customer = null;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customer_type_id = rs.getInt("customer_type_id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                String customer_gender = rs.getString("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email = rs.getString("customer_email");
                String customer_address = rs.getString("customer_address");
                customer = new Customer(id, customer_type_id, customer_name, customer_birthday, customer_gender,
                        customer_id_card, customer_phone, customer_email, customer_address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public Customer select(String ma_benh_nhan) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUS_SQL);) {
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setString(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Customer> search(String name) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customers = new ArrayList<>();
        String query = "{CALL search_customer(?)}";
        // Step 1: Establishing a Connection
        try (
                Connection connection = mySQLConnection.getConnection();
                // Step 2:Create a statement using connection object
                CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, name);
            // Step 3: Execute the query or update query
            ResultSet rs = callableStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                int customer_type_id = rs.getInt("customer_type_id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                String customer_gender = rs.getString("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email = rs.getString("customer_email");
                String customer_address = rs.getString("customer_address");
                customers.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday,
                        customer_gender, customer_id_card, customer_phone, customer_email, customer_address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
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
