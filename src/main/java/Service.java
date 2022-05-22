import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service implements Dao{
    @Override
    public void insertUser(int id, String name, String lastName, byte age) {
        try {
            Connection con = Util.getConnection();
            Statement stmt = con.createStatement();
            String rs = "INSERT INTO \"users\" ( " +
                    "id, name, \"lastName\", age) " +
                    "VALUES ("+id+", '"+name+"', '"+lastName+"', " + age +")";
            stmt.executeUpdate(rs);
            stmt.close();
            con.close();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void createUserTable() {
        deleteUserTable();
        try {
            Connection con = Util.getConnection();
            Statement stmt = con.createStatement();
            String rs = "" +
                    "CREATE TABLE IF NOT EXISTS users (" +
                    "id integer, " +
                    "name text, " +
                    "\"lastName\" text, " +
                    "age integer, " +
                    "CONSTRAINT users_pkey PRIMARY KEY (id) " +
                    ");" +
                    "";
            stmt.executeUpdate(rs);
            stmt.close();
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteUserTable() {
        try {
            Connection con = Util.getConnection();
            Statement stmt = con.createStatement();
            String rs = "" +
                    "DROP TABLE if exists users;" +
                    "";
            stmt.executeUpdate(rs);
            stmt.close();
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> selectAllUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            Connection con = Util.getConnection();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("" +
                        "SELECT * " +
                        "FROM \"users\"; ");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String lastName = rs.getString("lastName");
                    byte age = rs.getByte("age");
                    User user = new User(id,name,lastName,age);
                    users.add(user);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void cleanUserTable() {
        try {
            Connection con = Util.getConnection();
            Statement stmt = con.createStatement();
            String rs = "DELETE FROM users";
            stmt.executeUpdate(rs);
            stmt.close();
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
