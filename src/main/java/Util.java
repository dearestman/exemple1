import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String url = "jdbc:postgresql://localhost:5432/example1";
    private static String user = "postgres";
    private static String password = "123";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

}
