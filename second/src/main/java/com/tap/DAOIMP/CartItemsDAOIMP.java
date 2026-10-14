package com.tap.DAOIMP;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tap.DAO.CartItemsDAO;
import com.tap.Model.CartItems;
import com.tap.Model.Menu;
import com.tap.Model.Orders;
import com.tap.utiliy.HibernateUtil;

public class CartItemsDAOIMP implements CartItemsDAO{

	@Override
	public void saveCart(CartItems cartItems,int itemId,int id) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Menu menu =session.get(Menu.class,itemId);
            Orders order=session.get(Orders.class, id);
            cartItems.setOrder(order);
            cartItems.setMenu(menu);
            session.persist(cartItems);
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
	

}
