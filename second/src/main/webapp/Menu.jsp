<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, com.tap.Model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foodie App - Menu</title>
    <style>
        body {
            font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            margin: 0;
            background: linear-gradient(135deg, #ff6347, #ffa500);
            overflow-x: hidden;
        }
        .menu-container {
            max-width: 800px;
            margin: 2rem auto;
            background-color: rgba(255, 255, 255, 0.95);
            padding: 2.5rem;
            border-radius: 12px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
            backdrop-filter: blur(10px);
        }
        .menu-header {
            text-align: center;
            margin-bottom: 2rem;
        }
        .menu-header img {
            width: 100%;
            max-height: 200px;
            object-fit: cover;
            border-radius: 8px;
            margin-bottom: 1rem;
        }
        .menu-header img.error {
            background-color: #f0f0f0;
            color: #666;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 1rem;
        }
        .menu-header h1 {
            color: #2c3e50;
            font-size: 2rem;
            font-weight: 600;
            margin: 0.5rem 0;
        }
        .menu-header p {
            color: #34495e;
            font-size: 1rem;
            line-height: 1.5;
        }
        .menu-section {
            margin-top: 2rem;
        }
        .menu-section h2 {
            color: #2c3e50;
            font-size: 1.5rem;
            font-weight: 600;
            margin-bottom: 1rem;
        }
        .menu-item {
            display: flex;
            align-items: center;
            padding: 1rem;
            border-bottom: 1px solid #e0e0e0;
            transition: background-color 0.3s ease;
        }
        .menu-item:hover {
            background-color: #f9f9f9;
        }
        .menu-item img {
            width: 80px;
            height: 80px;
            object-fit: cover;
            border-radius: 8px;
            margin-right: 1rem;
        }
        .menu-item img.error {
            background-color: #f0f0f0;
            color: #666;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 0.8rem;
        }
        .menu-item-details {
            flex: 1;
        }
        .menu-item-details h3 {
            color: #34495e;
            font-size: 1.2rem;
            margin: 0;
        }
        .menu-item-details p {
            color: #666;
            font-size: 0.9rem;
            margin: 0.5rem 0 0;
        }
        .menu-item-price {
            color: #ff6347;
            font-size: 1.1rem;
            font-weight: 500;
            margin-right: 1rem;
        }
        .menu-item button {
            padding: 0.5rem 1rem;
            background: linear-gradient(90deg, #ff6347, #ffa500);
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 0.9rem;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .menu-item button:hover {
            background: linear-gradient(90deg, #e5533d, #e69500);
            transform: scale(1.05);
        }
        .menu-item button:active {
            transform: scale(0.95);
        }
        .error-message {
            color: #d32f2f;
            text-align: center;
            margin-top: 1rem;
            font-size: 0.9rem;
            display: none;
        }
        .nav-links {
            text-align: center;
            padding: 1rem;
        }
        .nav-links a {
            color: white;
            margin: 0 1rem;
            text-decoration: none;
            font-size: 1rem;
            font-weight: 500;
        }
        .nav-links a:hover {
            color: #e5533d;
            text-decoration: underline;
        }
        @media (max-width: 480px) {
            .menu-container {
                margin: 1rem;
                padding: 1.5rem;
                max-width: 90%;
            }
            .menu-header h1 {
                font-size: 1.5rem;
            }
            .menu-section h2 {
                font-size: 1.3rem;
            }
            .menu-item {
                flex-direction: column;
                align-items: flex-start;
            }
            .menu-item img {
                width: 100%;
                height: 100px;
                margin-bottom: 0.5rem;
            }
            .menu-item-price {
                margin: 0.5rem 0;
            }
            .menu-item button {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <nav class="nav-links">
        <a href="GetAllRestaurantServlet">Restaurants</a>
        <a href="Cart.jsp">Cart</a>
        <a href="Signup.jsp" onclick="logout()">Logout</a>
    </nav>
    <% 
    List<Menu>li=(List<Menu>)request.getAttribute("menu");
    %>
    <div class="menu-container">
        <div class="menu-header">
            <img src="https://images.unsplash.com/photo-1517248135467-4c7edcad34c4" 
                 alt="Savor Delight Restaurant" 
                 onerror="this.src='https://via.placeholder.com/800x200?text=Image+Not+Available'; this.classList.add('error');">
            <h1 id="restaurant-name">Savor Delight Menu</h1>
            <p>Authentic Italian cuisine with a modern twist. Enjoy our handcrafted dishes.</p>
        </div>
        <div class="menu-section">
            <h2>Menu</h2>
       <%
       
       for(Menu dhoni:li)
       {
    	   
       
       %>  
            
            <div class="menu-item">
            
               <%-- <img src="data:image/webp;base64,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" 
                     alt="Margherita Pizza" 
                     onerror="this.src='https://via.placeholder.com/80x80?text=Image+Not+Available'; this.classList.add('error');">
                  --%>
                 
                
                 <img src="<%=dhoni.getImage()%>" 
     alt="Pizza" 
     onerror="this.src='https://via.placeholder.com/100?text=Missing'" 
     />
                 
                <div class="menu-item-details">
                    <h3><%=dhoni.getItemName()%></h3>
                    <p><%=dhoni.getDescription() %>
                    <p>Classic pizza with fresh mozzarella, basil, and tomato sauce.</p>
                </div>
                <div class="menu-item-price"><%=dhoni.getPrice()%></div>
                <form action="CartServlet" method="post">
                <input type="hidden" name="menu_id"value="<%=dhoni.getMenuId()%>">
                <input type="hidden" name="quantity" value="1">
                <input type="hidden" name="restaurant_id" value="<%=dhoni.getRestaurant().getRestaurantId()%>">
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Add To CART">
                </form>
            </div>
            
          <%
       }
          %>  
          <h1>Hello</h1>
            
            
    </div>
</div>

</body>
</html>