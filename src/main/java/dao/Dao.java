package dao;

import models.User;

import java.util.ArrayList;
import java.util.List;


abstract public interface Dao {
    void insertUser(int id, String name, String lastName, byte age);
    void createUserTable();
    void deleteUserTable();
    List<User> selectAllUsers();
    void cleanUserTable();

}
