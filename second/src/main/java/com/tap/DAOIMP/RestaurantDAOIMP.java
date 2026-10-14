package com.tap.DAOIMP;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import com.tap.DAO.RestaurantDAO;
import com.tap.Model.Restaurant;
import com.tap.Model.Users;
import com.tap.utiliy.HibernateUtil;

public class RestaurantDAOIMP implements RestaurantDAO {

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(restaurant);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(restaurant);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) session.remove(restaurant);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Restaurant.class, restaurantId);
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Restaurant> query = session.createQuery("FROM Restaurant", Restaurant.class);
            return query.getResultList();
        }
    }
  @Override
    public Users getAllRestaurantsByAdminId(int id) {
    	 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    	        String hql = "FROM Users WHERE userid=:id";
    	        Query<Users> query = session.createQuery(hql,Users.class);
    	        query.setParameter("id", id);
    	          Users user=query.uniqueResult();
    	          return user;
    	        
    	    }
    }
}
