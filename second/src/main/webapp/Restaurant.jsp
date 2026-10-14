<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, com.tap.Model.Restaurant,com.tap.Model.Users" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Restaurants | Foodie World</title>
  <link rel="stylesheet" href="styles.css" />
</head>
<body>
<% Users user=(Users)session.getAttribute("currentUser");
   String role=user.getRole();
   String s=null;
   if(role.equals("customer")){
	   s="GetMenuServlet";
   }
   else{
	   String r=(String)request.getAttribute("view");
	   if(r==null){
	   s="Input.jsp";
	   }
	   else{
		   s="#";
	   }
   }
    %>

  <header>
    <h1>Foodie World</h1>
    <nav>
      <a href="#">Home</a>
      <a href="#">Restaurants</a>
      <a href="#">About</a>
      <a href="#">Contact</a>
    </nav>
  </header>

  <section class="restaurant-section">
    <h2>Our Top Restaurants</h2>
    <div class="restaurant-container">
    <%
        List<Restaurant>li=(List<Restaurant>)request.getAttribute("resta");
        for(Restaurant dhoni:li)
        {
        	
        

        %>
      <a href="<%=s.toString() %>?restaurantId=<%= dhoni.getRestaurantId()%>">
      <div class="restaurant-card">
      
       <!-- <img src="https://images.unsplash.com/photo-1552566626-52f8b828add9?auto=format&fit=crop&w=600&q=80" alt="Urban Spice" />-->
       
       <!--  <p>Image path: 
       <%= dhoni.getImage() %></p>-->
       <img src="<%=dhoni.getImage()%>" alt="Urban Spice" />
        <div class="restaurant-info">
          <h3><%=dhoni.getName() %></h3>
          <p>Modern Indian cuisine with a twist.</p>
          <span>📍<%=dhoni.getAddress() %></span>
        </div>
      </div>
      </a>
      <%
      
      }
      %>

      

    </div>
  </section>

  <footer>
    <p>&copy; 2025 Foodie World. All rights reserved.</p>
  </footer>

</body>
</html>