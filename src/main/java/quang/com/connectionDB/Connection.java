package quang.com.connectionDB;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    protected java.sql.Connection getConnection() {
         String jdbcURL = "jdbc:mysql://localhost:3306/Applications_Oder";
         String jdbcUsername = "root";
         String jdbcPassword = "12345678";
        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
