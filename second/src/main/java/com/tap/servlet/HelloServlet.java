package com.tap.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import second.User;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tap.DAOIMP.userDAOIMP;
import com.tap.Model.Users;
import com.tap.utiliy.HibernateUtil;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	userDAOIMP ui;
	
	private static final long serialVersionUID = 1L;
       
    
    public HelloServlet() {
        super();
    }
    @Override
	public void init(ServletConfig config) throws ServletException {
		ui=new userDAOIMP();
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String userid = request.getParameter("userid");
//	    String name = request.getParameter("name");
//	    String password = request.getParameter("password");

	    // Create User entity
//	    User user = new User();
//	    user.setUserId(Integer.parseInt(userid));
//	    user.setName(name);
//	    user.setPassword(password);
		String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        
        
        List<Users> li=ui.findByUsernameOrEmail(username, email);
        if(!li.isEmpty()) {
         request.setAttribute("error", "User already exists with this username or email!");      
         RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
          rd.forward(request, response);
          
        }
        else {
        	Users u=new Users(name,username, password, email,  phone, address,role);
        	ui.saveUser(u);
        	response.sendRedirect("Login.jsp");
        	
        }
        
        
        
        
        
        
        
        
        
        
        
        
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            // 3. Check for duplicate user
//            // -----------------------------
//            Query<Users> query = session.createQuery(
//                    "FROM Users WHERE username = :username OR email = :email",
//                    Users.class
//            );
//
//            query.setParameter("username", username);
//            query.setParameter("email", email);
//
//            List<Users> existingUsers = query.getResultList();
//
//            if (!existingUsers.isEmpty()) {
//                // -----------------------------
//                // Duplicate found → return to signup.jsp
//                // -----------------------------
//                request.setAttribute("error", "User already exists with this username or email!");
//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response);
//                System.out.println("the code is executing after forwared---->");
//                return; // Stop further execution
//                
//            }
//
//            Users u=new Users(name,username, password, email,  phone, address,role);
//            
//
//            session.persist(u);
//            tx.commit();
//            response.sendRedirect("Login.jsp");
//
////            response.getWriter().println("Signup successful! Please <a href='login.jsp'>login</a>.");
//
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//            response.getWriter().println("Error during signup: " + e.getMessage());
//        } finally {
//            session.close();
//        }
        
       
//       Users u=new Users(name,username, password, email,  phone, address,role);
      
		
	    
//	    SessionFactory factory = new Configuration().configure().buildSessionFactory();
//	    Session session = factory.openSession();
//	    Transaction tx = session.beginTransaction();
//
////	    session.persist(user); // Inserts user into DB
//
//	    tx.commit();
//	    session.close();
//	    factory.close();

	    // Respond to client
//	    response.getWriter().println("User saved successfully: " + name);
	}
	

}
