package com.shevchenko;

import com.shevchenko.Model.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Country.class);
                configuration.addAnnotatedClass(City.class);
                configuration.addAnnotatedClass(Hospital.class);
                configuration.addAnnotatedClass(Region.class);
                configuration.addAnnotatedClass(Doctor.class);
                configuration.addAnnotatedClass(Degree.class);
                configuration.addAnnotatedClass(Patient.class);
                configuration.addAnnotatedClass(Treatment.class);
                configuration.addAnnotatedClass(Password.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Error!" + e);
            }
        }
        return sessionFactory;
    }

}
