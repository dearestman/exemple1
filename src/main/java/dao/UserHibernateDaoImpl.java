package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Util;

import java.util.ArrayList;
import java.util.List;

public class UserHibernateDaoImpl implements Dao {

    @Override
    public void insertUser(int id, String name, String lastName, byte age) {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "INSERT INTO \"users\" ( " +
                "id, name, \"lastName\", age) " +
                "VALUES ("+id+", '"+name+"', '"+lastName+"', " + age +")";

        Query query = session.createSQLQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void createUserTable() {
        deleteUserTable();
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "" +
                "CREATE TABLE IF NOT EXISTS users (" +
                "id integer, " +
                "name text, " +
                "\"lastName\" text, " +
                "age integer, " +
                "CONSTRAINT users_pkey PRIMARY KEY (id) " +
                ");" +
                "";

        Query query = session.createSQLQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUserTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXISTS users";

        Query query = session.createSQLQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "" +
                "SELECT * " +
                "FROM \"users\"; " +
                "";

        List<Object[]> list = session.createSQLQuery(sql).list();
        for (Object[] object:list
             ) {
            int id = (Integer) object[0];
            String name = (String) object[1];
            String lastName = (String) object[2];
            int age = (Integer) object[3];
            users.add(new User(id,name,lastName,(byte) age));
        }

        transaction.commit();
        session.close();
        return users;
    }

    @Override
    public void cleanUserTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DELETE FROM users";

        Query query = session.createSQLQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
