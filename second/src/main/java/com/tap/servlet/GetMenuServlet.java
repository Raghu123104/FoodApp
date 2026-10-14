package com.tap.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.tap.DAOIMP.MenuDAOIMP;
import com.tap.Model.Menu;

/**
 * Servlet implementation class GetMenuServlet
 */
@WebServlet("/GetMenuServlet")
public class GetMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDAOIMP m;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		m=new MenuDAOIMP();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id=Integer.parseInt(request.getParameter("restaurantId"));
		List<Menu>li=  m.getItemsByRestaurantId(id);
		if(li==null) {
			response.setContentType("text/html");
			response.getWriter().println("heeloo");
			return;
		}
		request.setAttribute("menu", li);
		request.getRequestDispatcher("Menu.jsp").forward(request, response);
		
		  
	}                             
	           

	
}
