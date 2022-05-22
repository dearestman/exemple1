import java.util.ArrayList;

public class MainApp {


    public static void main(String[] args) {
        Service service = new Service();
        service.createUserTable();
        for (int i = 0; i < 4; i++) {
            service.insertUser(i,"Dima"+i, "Stupakov", (byte) (i+18));
        }
        ArrayList<User> users = service.selectAllUsers();
        System.out.println("Список пользователей:");
        for (User user:users
             ) {
            System.out.println(user.toString());
        }
        service.cleanUserTable();
        service.deleteUserTable();
    }


}
