package com.shevchenko.Model.dao;

import com.shevchenko.HibernateSessionFactoryUtil;
import com.shevchenko.Model.entity.Country;
import com.shevchenko.Model.entity.Password;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PasswordDao {
    private static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    public static Password findById(int id) {
        Password result = session.get(Password.class, id);
        return result;
    }

    public static void save(Password password) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.save(password);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void update(Password password) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.update(password);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }
    }

    public static void delete(Password password) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(password);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }
    }

    public static Password findPasswordById(int id) {
        return session.get(Password.class, id);
    }

    public static List<Password> findAll() {
        List<Password> passwords = (List<Password>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Password ").list();
        return passwords;
    }
}
