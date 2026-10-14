package com.tap.DAOIMP;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tap.DAO.OrderDAO;
import com.tap.Model.Orders;
import com.tap.Model.Restaurant;
import com.tap.Model.Users;
import com.tap.utiliy.HibernateUtil;

public class OrderDAOIMP implements OrderDAO {

	@Override
	public Orders saveOrder(Orders order,int id,int userId) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        Session session = null;
	        try {
	            session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	          Users user=    session.get(Users.class,userId);
	          Restaurant restaurant=session.get(Restaurant.class,id);
	            order.setRestaurant(restaurant);
	            order.setUserId(user);
	            session.persist(order);
	            transaction.commit();
	            return order;
	        } catch (Exception e) {
	            if (transaction != null && transaction.getStatus().canRollback()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (session != null) session.close();
	        }
		return null;
	}
	

}
