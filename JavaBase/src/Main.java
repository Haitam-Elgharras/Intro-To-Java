import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javabase";
        String username = "java";
        String password = "azerty";

        System.out.println("Connecting database ...");

        try(Connection connection = DriverManager.getConnection(url, username, password))
        {
            System.out.println("Database connected!");

            // create a table product and insert some data
//            String sql = "CREATE TABLE IF NOT EXISTS products (\n"
//                    + "	id integer PRIMARY KEY,\n"
//                    + "	name text NOT NULL,\n"
//                    + "	price real\n"
//                    + ");";
//            connection.createStatement().execute(sql);
            // add a quantity column
//            String sql = "ALTER TABLE products ADD COLUMN quantity INTEGER DEFAULT 0;";
//            connection.createStatement().execute(sql);

            // insert some data
             String sql = "INSERT INTO products( name, price,quantity) VALUES( 'B', 30,10);";
            connection.createStatement().execute(sql);
            System.out.println("Data inserted!");

        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
}
