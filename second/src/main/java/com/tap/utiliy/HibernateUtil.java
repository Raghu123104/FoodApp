package com.tap.utiliy;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                            .addAnnotatedClass(com.tap.Model.Restaurant.class)
                            .addAnnotatedClass(com.tap.Model.Users.class)
                            .addAnnotatedClass(com.tap.Model.Menu.class)
                            .addAnnotatedClass(com.tap.Model.Orders.class)
                            .addAnnotatedClass(com.tap.Model.CartItems.class)
                            .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
