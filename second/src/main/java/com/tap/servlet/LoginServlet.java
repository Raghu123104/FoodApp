package com.tap.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tap.DAOIMP.userDAOIMP;
import com.tap.Model.Users;
import com.tap.utiliy.HibernateUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	userDAOIMP ui;
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ui=new userDAOIMP();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       

        try {
            
            // 3. Check for duplicate user
            // -----------------------------
         Users user=  ui.findByEmailAndPassword(email, password);

            if (user != null) {
                // ✅ Add user object to HttpSession
                HttpSession session1 = request.getSession();
                session1.setAttribute("currentUser", user);
                if(user.getRole().equals("Admin")) {
                	response.sendRedirect("AdminDash.jsp");
                }
                else {
               
                response.sendRedirect("GetAllRestaurantServlet");
                }
            } else {
               request.setAttribute("error", "Your Login Details are wrong");
               RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
               rd.forward(request, response);
               return;
            	
             }
        }
        catch (Exception e) {
            // ✅ Catch DB or DAO errors
            e.printStackTrace();
            request.setAttribute("error", "Something went wrong while logging in. Please try again later.");
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
	}
}


           

      

