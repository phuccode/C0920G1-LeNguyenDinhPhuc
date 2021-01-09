package repository;

import connection.MySQLConnection;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements CRUD<Employee> {
    MySQLConnection mySQLConnection = new MySQLConnection();
    private static final String INSERT_EMP_SQL = "INSERT INTO employee" + "  (employee_name,employee_birthday, " +
            "employee_id_card,employee_salary,employee_phone, " +
            "employee_email,employee_address,position_id,education_degree_id,division_id,user_name) VALUE " +
            " (?,?,?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_EMP_BY_ID = "select * from employee where employee_id =?";
    private static final String SELECT_ALL_EMP = "select * from employee";
    private static final String DELETE_EMP_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMP_SQL = "update employee set  employee_name = ?, employee_birthday= ?, employee_id_card = ?," +
            "employee_salary = ?,employee_phone = ?, employee_email = ?,employee_address= ?," +
            "position_id = ?,education_degree_id = ?,division_id = ?,user_name = ? where employee_id = ?";
    @Override
    public List<Employee> selectAll() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMP);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int employee_id = rs.getInt("employee_id");
                String employee_name = rs.getString("employee_name");
                String employee_birthday = rs.getString("employee_birthday");
                String employee_id_card = rs.getString("employee_id_card");
                double employee_salary = rs.getDouble("employee_salary");
                String employee_phone = rs.getString("employee_phone");
                String employee_email = rs.getString("employee_email");
                String employee_address = rs.getString("employee_address");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");
                String user_name = rs.getString("user_name");
                employees.add(new Employee(employee_id, employee_name, employee_birthday, employee_id_card,
                        employee_salary, employee_phone, employee_email, employee_address,
                        position_id,education_degree_id,division_id,user_name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public void insert(Employee employee) throws SQLException {
        System.out.println(INSERT_EMP_SQL);
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMP_SQL)) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegree());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Employee select(int id) {
        Employee employee = null;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMP_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String employee_name = rs.getString("employee_name");
                String employee_birthday = rs.getString("employee_birthday");
                String employee_id_card = rs.getString("employee_id_card");
                double employee_salary = rs.getDouble("employee_salary");
                String employee_phone = rs.getString("employee_phone");
                String employee_email = rs.getString("employee_email");
                String employee_address = rs.getString("employee_address");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");
                String user_name = rs.getString("user_name");
                employee = new Employee(employee_name, employee_birthday, employee_id_card,
                        employee_salary, employee_phone, employee_email, employee_address,
                        position_id,education_degree_id,division_id,user_name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    @Override
    public Employee select(String ma_benh_nhan) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMP_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMP_SQL);) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegree());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12, employee.getEmployeeId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Employee> search(String name) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Employee> employees = new ArrayList<>();
        String query = "{CALL search_employee(?)}";
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
                int employee_id = rs.getInt("employee_id");
                String employee_name = rs.getString("employee_name");
                String employee_birthday = rs.getString("employee_birthday");
                String employee_id_card = rs.getString("employee_id_card");
                double employee_salary = rs.getDouble("employee_salary");
                String employee_phone = rs.getString("employee_phone");
                String employee_email = rs.getString("employee_email");
                String employee_address = rs.getString("employee_address");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");
                String user_name = rs.getString("user_name");
                employees.add(new Employee(employee_id, employee_name, employee_birthday, employee_id_card,
                        employee_salary, employee_phone, employee_email, employee_address,
                        position_id,education_degree_id,division_id,user_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
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
