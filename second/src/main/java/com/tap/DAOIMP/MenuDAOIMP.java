package com.tap.DAOIMP;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;

import com.tap.DAO.MenuDAO;
import com.tap.Model.Menu;
import com.tap.Model.Restaurant;
import com.tap.utiliy.HibernateUtil;

public class MenuDAOIMP  implements MenuDAO{

	@Override
	public void addItem(Menu item,int id) {
		// TODO Auto-generated method stub
		
		 Transaction transaction = null;
	        Session session = null;
	        try {
	            session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            Restaurant res=session.get(Restaurant.class,id);
	            item.setRestaurant(res);
	            session.persist(item);
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
	public List<Menu> getItemsByRestaurantId(int id) {
		
		Transaction transaction = null;
        Session session = null;
        List<Menu>menu=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql="from Restaurant where restaurantId=:restId";
            Query<Restaurant>query= session.createQuery(hql,Restaurant.class);
            query.setParameter("restId",id);
            Restaurant res=query.uniqueResult();
            transaction.commit();
            if(res!=null) {
            menu= res.getMenu();
            }
            
           
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return menu;
	}

	@Override
	public Menu getItemByMenuId(int id) {
		 Transaction transaction = null;
	        Session session = null;
	        Menu menu=null;
	        try {
	            session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            menu=session.get(Menu.class,id);
	            transaction.commit();
	            
	        } catch (Exception e) {
	            if (transaction != null && transaction.getStatus().canRollback()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (session != null) session.close();
		
	}
	        return menu;
	}
	       
	
	
	

}
