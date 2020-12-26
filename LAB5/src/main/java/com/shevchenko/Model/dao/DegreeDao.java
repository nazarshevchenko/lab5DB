package com.shevchenko.Model.dao;

import com.shevchenko.HibernateSessionFactoryUtil;
import com.shevchenko.Model.entity.Country;
import com.shevchenko.Model.entity.Degree;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DegreeDao {
    private static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    public static Degree findById(int id) {
        Degree result = session.get(Degree.class, id);
        return result;
    }

    public static void save(Degree degree) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.save(degree);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void update(Degree degree) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.update(degree);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }
    }

    public static void delete(Degree degree) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(degree);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }
    }

    public static Degree findDegreeById(int id) {
        return session.get(Degree.class, id);
    }

    public static List<Degree> findAll() {
        List<Degree> degrees = (List<Degree>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Degree").list();
        return degrees;
    }
}
