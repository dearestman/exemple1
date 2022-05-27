package dao;

import models.User;

import java.util.List;


public interface Dao {
    void insertUser(int id, String name, String lastName, byte age);
    void createUserTable();
    void deleteUserTable();
    List<User> selectAllUsers();
    void cleanUserTable();

}
