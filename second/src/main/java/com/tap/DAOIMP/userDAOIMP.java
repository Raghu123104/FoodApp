package com.tap.DAOIMP;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tap.DAO.UserDAO;
import com.tap.Model.Users;
import com.tap.utiliy.HibernateUtil;



public class userDAOIMP  implements UserDAO{
	public void saveUser(Users user) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

  
    public List<Users> findByUsernameOrEmail(String username, String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Users> query = session.createQuery(
                    "FROM Users WHERE username = :username OR email = :email", 
                    Users.class
            );
            query.setParameter("username", username);
            query.setParameter("email", email);
            return query.getResultList();
        }
        catch (Exception e) {
            throw new RuntimeException("Error finding user by username/email", e);
        }

    }


	@Override
	public Users findByEmailAndPassword(String email, String password) {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 Query<Users> query = session.createQuery(
	                    "FROM Users WHERE email =:email AND password= :password",
	                    Users.class
	            );

	            
	            query.setParameter("email", email);
	            query.setParameter("password", password);
	            Users user = query.uniqueResult();
	            return user;
	            
	           
	        }
		 catch (Exception e) {
		        throw new RuntimeException("Error finding user by email/password", e);
	}
}
}
