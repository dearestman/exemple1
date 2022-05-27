package services;

import dao.Dao;
import dao.UserHibernateDaoImpl;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Service implements Dao {
    private UserHibernateDaoImpl userHibernateDao = new UserHibernateDaoImpl();
    @Override
    public void insertUser(int id, String name, String lastName, byte age) {
        userHibernateDao.insertUser(id,name,lastName,age);
    }

    @Override
    public void createUserTable() {
        userHibernateDao.createUserTable();
    }

    @Override
    public void deleteUserTable() {
        userHibernateDao.deleteUserTable();
    }

    @Override
    public List<User> selectAllUsers() {
        return userHibernateDao.selectAllUsers();
    }

    @Override
    public void cleanUserTable() {
        userHibernateDao.cleanUserTable();
    }
}
