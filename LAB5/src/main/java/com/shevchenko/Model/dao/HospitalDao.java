package com.shevchenko.Model.dao;

import com.shevchenko.HibernateSessionFactoryUtil;
import com.shevchenko.Model.entity.Hospital;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HospitalDao {
    private static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public static Hospital findById(int id) {
        Hospital result = session.get(Hospital.class, id);
        return result;
    }

    public static List<Hospital> findAll() {
        List<Hospital> hospitals = (List<Hospital>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Hospital").list();
        return hospitals;
    }

    public static void save(Hospital hospital) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.save(hospital);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void delete(Hospital hospital) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(hospital);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void update(Hospital hospital) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.update(hospital);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }
}
