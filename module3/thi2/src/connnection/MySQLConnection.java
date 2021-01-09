package connnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/thi?useSSL=false";
        String jdbcUsername = "root";
        String jdbcPassword = "dinhphuc98";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
