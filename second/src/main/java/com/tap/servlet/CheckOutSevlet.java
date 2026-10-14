package com.tap.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tap.DAOIMP.CartItemsDAOIMP;
import com.tap.DAOIMP.MenuDAOIMP;
import com.tap.DAOIMP.OrderDAOIMP;
import com.tap.DAOIMP.RestaurantDAOIMP;
import com.tap.Model.Cart;
import com.tap.Model.CartItem;
import com.tap.Model.CartItems;
import com.tap.Model.Menu;
import com.tap.Model.Orders;
import com.tap.Model.Restaurant;
import com.tap.Model.Users;

/**
 * Servlet implementation class CheckOutSevlet
 */
@WebServlet("/CheckOutSevlet")
public class CheckOutSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantDAOIMP r;
	private OrderDAOIMP o;
	private MenuDAOIMP m;
	private CartItemsDAOIMP c;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public CheckOutSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		r=new RestaurantDAOIMP();
		o=new OrderDAOIMP();
		m=new MenuDAOIMP();
		c=new CartItemsDAOIMP();
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String status=request.getParameter("status");
    String payment=request.getParameter("paym");
    
   HttpSession session=request.getSession();
   Users user=(Users)session.getAttribute("currentUser");
   Integer restaurantId=(Integer)session.getAttribute("RestaurantId");
   Cart cart=(Cart)session.getAttribute("cart");
   Orders order=null;
   
   int grandTotal=0;
   if(cart!=null&&restaurantId!=null&&!cart.getItems().isEmpty()) {
   for(CartItem ci:cart.getItems().values()) {
	   
	  grandTotal=grandTotal+ci.getTotalAmount();
	  
   }
//    Restaurant restaurant =r.getRestaurantById(restaurantId);
    order=new Orders(grandTotal,status,payment);  
//    order.setRestaurant(restaurant);
//    order.setUserId(user);
   order= o.saveOrder(order,restaurantId,user.getUserid());
   for(CartItem ci:cart.getItems().values()) {
	   
	     int itemId=ci.getId();
	     Menu menu= m.getItemByMenuId(itemId);
	     String itemName=ci.getName();
	     int quantity=ci.getQuantity();
	     int price=ci.getPrice();
	     int totalAmount=ci.getTotalAmount();
	     String image=ci.getImage();
	     CartItems cartItems=new CartItems(itemName,quantity,price, totalAmount,image);
//	    cartItems.setOrder(order);
//	    cartItems.setMenu(menu);
	    c.saveCart(cartItems,itemId,order.getOrderId());
	    
	     
	  }
   }
   if(cart.getItems().isEmpty()) {
	   response.sendRedirect("error.jsp");
   }
   else {
		session.removeAttribute("cart");
		session.setAttribute("order",order);
		response.sendRedirect("confirm.jsp");
		}
   
		
		
		
	}

}
