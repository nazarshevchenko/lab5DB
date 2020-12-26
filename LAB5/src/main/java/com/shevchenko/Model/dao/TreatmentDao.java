package com.shevchenko.Model.dao;

import com.shevchenko.HibernateSessionFactoryUtil;
import com.shevchenko.Model.entity.City;
import com.shevchenko.Model.entity.Treatment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TreatmentDao {
    private static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public static Treatment findById(int id) {
        Treatment result = session.get(Treatment.class, id);
        return result;
    }

    public static List<Treatment> findAll() {
        List<Treatment> treatments = (List<Treatment>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Treatment").list();
        return treatments;
    }

    public static void save(Treatment treatment) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.save(treatment);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void delete(Treatment treatment) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(treatment);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void update(Treatment treatment) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.update(treatment);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }
    }
}
