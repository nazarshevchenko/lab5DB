package com.shevchenko.Model.dao;

import com.shevchenko.HibernateSessionFactoryUtil;
import com.shevchenko.Model.entity.City;
import com.shevchenko.Model.entity.Country;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDao {
    private static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public static City findById(int id) {
        City result = session.get(City.class, id);
        return result;
    }

    public static List<City> findAll() {
        List<City> cities = (List<City>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From City").list();
        return cities;
    }

    public static void save(City city) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.save(city);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void delete(City city) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(city);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void update(City city) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.update(city);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }
    }

}
