package ma.enset.tpjdbc.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingletonDb {
    private static String url = "jdbc:mysql://localhost:3306/javabase";
    private static String username = "java";
    private static String password = "azerty";
    public static Connection connection;

     static {
        System.out.println("Connecting database ...");
        try {
//             Class.forName("com.mysql.jdbc.Driver"); // deprecated in Java 9
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
}
