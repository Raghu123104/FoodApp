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

import com.tap.DAOIMP.RestaurantDAOIMP;
import com.tap.Model.Restaurant;
import com.tap.Model.Users;

/**
 * Servlet implementation class AdminRestaurantServlet
 */
@WebServlet("/AdminRestaurantServlet")
public class AdminRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestaurantDAOIMP r;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	        Users user = (Users) session.getAttribute("currentUser");
	     Users user2 =r.getAllRestaurantsByAdminId(user.getUserid());
	     List<Restaurant> li=user2.getRestaurant();
	      request.setAttribute("resta",li);
	     String typ= request.getParameter("typ");
	      
	     if(typ.equals("view")) {
	    	 
	    	 request.setAttribute("view","go");
	    RequestDispatcher rd=   request.getRequestDispatcher("Restaurant.jsp");
	    
	        rd.forward(request, response);
	     }
	     else {
	    	 if(typ.equals("addItem")) {
	    	 RequestDispatcher rd=   request.getRequestDispatcher("Restaurant.jsp");
		        rd.forward(request, response);
		   }
	    	 
	     }
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		r=new RestaurantDAOIMP();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
