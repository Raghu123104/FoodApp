package com.tap.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tap.DAOIMP.MenuDAOIMP;
import com.tap.Model.Cart;
import com.tap.Model.CartItem;
import com.tap.Model.Menu;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MenuDAOIMP m;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		m=new MenuDAOIMP();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Cart cart= (Cart)session.getAttribute("cart");
		Integer restaurantId=(Integer) session.getAttribute("RestaurantId");
		int restaurantId2=Integer.parseInt(request.getParameter("restaurant_id"));
		if(cart==null||restaurantId!=restaurantId2) {
			cart=new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("RestaurantId",restaurantId2);
		}
		String action=request.getParameter("action");

		if(action.equals("add")) {
			addMoreItems(request,response,cart);
			
		}
		 else if(action.equals("update"))
         {
      	  updateMoreItems(request,cart);
      	   
         }
         else if(action.equals("remove"))
         {
      	   
      	   removeMoreItems(request,cart);
         }
		response.sendRedirect("Cart.jsp");
		
		
	}
	private void addMoreItems(HttpServletRequest request, HttpServletResponse response,Cart cart)throws IOException{
		
		
		int menuId=Integer.parseInt(request.getParameter("menu_id"));
		 Menu menu= m.getItemByMenuId(menuId);
//		 int id=menu.getMenuId();
		 int quantity=Integer.parseInt(request.getParameter("quantity"));
		 String name=menu.getItemName();
		 int price=menu.getPrice();
		 String image=menu.getImage();
		  int restId=menu.getRestaurant().getRestaurantId();
		  CartItem ci=new CartItem(menuId,name,price,quantity,restId,image);
		 cart.addItem(ci);
	}
	private void updateMoreItems(HttpServletRequest request,Cart cart) {
		
		int id=Integer.parseInt(request.getParameter("menu_id"));
		cart.updateItem(id);
	
	}
	private void removeMoreItems(HttpServletRequest request,Cart cart) {
		int id=Integer.parseInt(request.getParameter("menu_id"));
		cart.removeItem(id);
		
	}

}
