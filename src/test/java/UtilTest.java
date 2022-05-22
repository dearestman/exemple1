import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UtilTest {
    private static String url = "jdbc:postgresql://localhost:5432/example1";
    private static String user = "postgres";
    private static String password = "123";
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ;


    @Test
    public void getConnection() {

    }
}