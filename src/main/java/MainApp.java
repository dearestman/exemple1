import models.User;
import services.Service;

import java.util.List;

public class MainApp {


    static void doEx2(){
        Service service = new Service();
        service.createUserTable();
        for (int i = 0; i < 4; i++) {
            service.insertUser(i,"Dima"+i, "Stupakov", (byte) (i+18));
        }
        List<User> users = service.selectAllUsers();
        System.out.println("Список пользователей:");
        for (User user:users
        ) {
            System.out.println(user.toString());
        }
        service.cleanUserTable();
        service.deleteUserTable();
    }

      public static void main(String[] args) {
          doEx2();
    }

}
