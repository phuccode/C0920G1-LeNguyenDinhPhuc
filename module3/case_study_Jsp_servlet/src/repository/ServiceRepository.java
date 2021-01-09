package repository;

import connection.MySQLConnection;
import model.Employee;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements CRUD<Service> {
    MySQLConnection mySQLConnection = new MySQLConnection();
    private static final String INSERT_SER_SQL = "INSERT INTO service" + "  (service_name,service_area, " +
            "service_cost,service_max_people,rent_type_id, " +
            "service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) VALUE " +
            " (?,?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_ALL_SER = "select * from service";
    private static final String UPDATE_EMP_SQL = "update service set  service_name = ?, service_area= ?, service_cost = ?," +
            "service_max_people = ?,rent_type_id = ?, service_type_id = ?,standard_room= ?," +
            "description_other_convenience = ?,pool_area = ?,number_of_floors = ? where service_id = ?";

    @Override
    public List<Service> selectAll() {
        List<Service> services = new ArrayList<>();
        try (Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SER);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int service_id = rs.getInt("service_id");
                String service_name = rs.getString("service_name");
                int service_area = rs.getInt("service_area");
                double service_cost = rs.getDouble("service_cost");
                int service_max_people = rs.getInt("service_max_people");
                int rent_type_id = rs.getInt("rent_type_id");
                int service_type_id = rs.getInt("service_type_id");
                String standard_room = rs.getString("standard_room");
                String description_other_convenience = rs.getString("description_other_convenience");
                double pool_area = rs.getDouble("pool_area");
                int number_of_floors = rs.getInt("number_of_floors");
                services.add(new Service(service_id, service_name, service_area, service_cost,
                        service_max_people, rent_type_id, service_type_id, standard_room,
                        description_other_convenience,pool_area,number_of_floors));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return services;
    }

    @Override
    public void insert(Service service) throws SQLException {
        System.out.println(INSERT_SER_SQL);
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SER_SQL)) {
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getServiceArea());
            preparedStatement.setDouble(3, service.getServiceCost());
            preparedStatement.setInt(4, service.getServiceMaxPeople());
            preparedStatement.setInt(5, service.getRentTypeId());
            preparedStatement.setInt(6, service.getServiceTypeId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloors());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Service select(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Service service) throws SQLException {
        boolean rowUpdated;

        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMP_SQL);) {
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getServiceArea());
            preparedStatement.setDouble(3, service.getServiceCost());
            preparedStatement.setInt(4, service.getServiceMaxPeople());
            preparedStatement.setInt(5, service.getRentTypeId());
            preparedStatement.setInt(6, service.getServiceTypeId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloors());
            preparedStatement.setInt(11, service.getServiceId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Service> search(String name) {
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
