import java.util.ArrayList;

abstract public interface Dao {
    void insertUser(int id, String name, String lastName, byte age);
    void createUserTable();
    void deleteUserTable();
    ArrayList<User> selectAllUsers();
    void cleanUserTable();

}
