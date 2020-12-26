package com.shevchenko.Model.dao;

import com.shevchenko.HibernateSessionFactoryUtil;
import com.shevchenko.Model.entity.Doctor;
import com.shevchenko.Model.entity.Hospital;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DoctorDao {
    private static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public static Doctor findById(int id) {
        Doctor result = session.get(Doctor.class, id);
        return result;
    }

    public static List<Doctor> findAll() {
        List<Doctor> doctors = (List<Doctor>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Doctor").list();
        return doctors;
    }

    public static void save(Doctor doctor) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.save(doctor);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void delete(Doctor doctor) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(doctor);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void update(Doctor doctor) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.update(doctor);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }
}
