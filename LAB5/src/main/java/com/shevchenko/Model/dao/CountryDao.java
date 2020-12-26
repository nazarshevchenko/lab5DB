package com.shevchenko.Model.dao;

import com.shevchenko.Model.entity.City;
import com.shevchenko.Model.entity.Country;
import com.shevchenko.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CountryDao {
    private static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    public static Country findById(int id) {
        Country result = session.get(Country.class, id);
        return result;
    }

    public static void save(Country country) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.save(country);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void update(Country country) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.update(country);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }
    }

    public static void delete(Country country) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(country);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }
    }

    public static Country findCountryById(int id) {
        return session.get(Country.class, id);
    }

    public static List<Country> findAll() {
        List<Country> countrys = (List<Country>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Country").list();
        return countrys;
    }


}
