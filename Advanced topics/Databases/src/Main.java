import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javabase";
        String username = "java";
        String password = "azerty";



        System.out.println("Connecting database ...");

        try {

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Database connected!");
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
}
