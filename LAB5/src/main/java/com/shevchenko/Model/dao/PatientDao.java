package com.shevchenko.Model.dao;

import com.shevchenko.HibernateSessionFactoryUtil;
import com.shevchenko.Model.entity.Doctor;
import com.shevchenko.Model.entity.Patient;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PatientDao {
    private static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public static Patient findById(int id) {
        Patient result = session.get(Patient.class, id);
        return result;
    }

    public static List<Patient> findAll() {
        List<Patient> patients = (List<Patient>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Patient ").list();
        return patients;
    }

    public static void save(Patient patient) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.save(patient);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void delete(Patient patient) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(patient);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void update(Patient patient) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.update(patient);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }
}
