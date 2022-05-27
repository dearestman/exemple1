import models.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user = new User(1,"Olya", "Zemcovskaya", (byte) 25);

    @Test
    public void testToString() {
        System.out.println(user.toString());
    }

    @Test
    public void getId() {
        assertEquals(1, user.getId());
    }

    @Test
    public void setId() {
        user.setId(3);
        assertEquals(3,user.getId());
    }

    @Test
    public void getName() {
        assertEquals("Olya",user.getName());
    }

    @Test
    public void setName() {
        user.setName("Dima");
        assertEquals("Dima",user.getName());
    }

    @Test
    public void getLastName() {
        assertEquals("Zemcovskaya",user.getLastName());
    }

    @Test
    public void setLastName() {
        user.setLastName("Stupakov");
        assertEquals("Stupakov",user.getLastName());
    }

    @Test
    public void getAge() {
        assertEquals(25, user.getAge());
    }

    @Test
    public void setAge() {
        user.setAge((byte) 24);
        assertEquals(24, user.getAge());
    }
}