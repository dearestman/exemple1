import models.User;
import org.junit.Test;
import services.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceTest {
    Service service = new Service();
    ArrayList<User> users = new ArrayList<>();
    User user = new User(221,"Olya", "Zemcovskaya", (byte) 25);

    {
        service.createUserTable();
        for (int i = 0; i < 4; i++) {
            service.insertUser(i,"Dima"+i, "Stupakov", (byte) (i+18));
        }
    }



    @Test
    public void insertUser() {
        service.insertUser((int) user.getId(), user.getName(), user.getLastName(), user.getAge());
    }

    @Test
    public void createUserTable() {
        service.createUserTable();
    }

    @Test
    public void deleteUserTable() {
        service.deleteUserTable();
    }

    @Test
    public void selectAllUsers() {
        List<User> users = service.selectAllUsers();
    }

    @Test
    public void cleanUserTable() {
        service.cleanUserTable();
    }
}