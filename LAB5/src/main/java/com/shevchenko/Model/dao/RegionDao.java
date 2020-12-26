package com.shevchenko.Model.dao;

import com.shevchenko.HibernateSessionFactoryUtil;
import com.shevchenko.Model.entity.City;
import com.shevchenko.Model.entity.Country;
import com.shevchenko.Model.entity.Hospital;
import com.shevchenko.Model.entity.Region;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegionDao {
    private static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public static Region findById(int id) {
        Region result = session.get(Region.class, id);
        return result;
    }

    public static List<Region> findAll() {
        List<Region> region = (List<Region>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Region").list();
        return region;
    }

    public static void save(Region region) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.save(region);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void delete(Region region) {

        try {
            Transaction tx1 = session.beginTransaction();
            session.delete(region);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }

    }

    public static void update(Region region) {
        try {
            Transaction tx1 = session.beginTransaction();
            session.update(region);
            tx1.commit();
        }catch ( HibernateException he){
            session.getTransaction().rollback();
            he.printStackTrace();
        }
        finally {
        }
    }

    public static Region findRegionById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Region.class, id);
    }




}
