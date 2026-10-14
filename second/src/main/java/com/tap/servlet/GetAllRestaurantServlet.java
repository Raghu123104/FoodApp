package com.tap.servlet;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.tap.DAOIMP.RestaurantDAOIMP;
import com.tap.Model.Restaurant;

/**
 * Servlet implementation class GetAllRestaurantServlet t
 * This is for Customer Servlet -- loading the all the restaurants
 */
@WebServlet("/GetAllRestaurantServlet")
public class GetAllRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	RestaurantDAOIMP r;
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		r=new RestaurantDAOIMP();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Restaurant>li=	r.getAllRestaurants();
		req.setAttribute("resta",li);
		 RequestDispatcher rd=req.getRequestDispatcher("Restaurant.jsp");
		 rd.forward(req, resp);
	}
 



}
