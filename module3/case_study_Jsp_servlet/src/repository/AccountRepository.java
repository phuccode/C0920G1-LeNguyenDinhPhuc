package repository;

import connection.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {
    public static MySQLConnection mySQLConnection = new MySQLConnection();

    public static boolean checkLogin(String username, String password) throws SQLException {
        boolean isValid = false;
        Connection connection = mySQLConnection.getConnection();
        String sql = "select * from user where user_name = ? and password = ?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setString(1,username);
        pre.setString(2,password);
        ResultSet rs = pre.executeQuery();
        if(rs.next()){
            isValid = true;
        }else {
            isValid = false;
        }
        return isValid;
    }
}
