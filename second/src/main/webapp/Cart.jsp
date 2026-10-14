<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.Model.Cart ,com.tap.Model.CartItem" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Zomato-Style Cart</title>
  <style>
    body {
      margin: 0;
      font-family: 'Poppins', sans-serif;
      background: linear-gradient(to right, #ff4e50, #f9d423);
      color: #333;
      padding: 40px 10px;
    }

    .cart-container {
      max-width: 900px;
      margin: auto;
      background: #fff;
      border-radius: 20px;
      box-shadow: 0 15px 35px rgba(0, 0, 0, 0.15);
      padding: 40px;
    }

    h1 {
      text-align: center;
      font-size: 2.7em;
      color: #ff4e50;
      margin-bottom: 40px;
    }

    .cart-item {
      background: #fff6f0;
      border: 2px solid #ffd0c0;
      border-radius: 15px;
      padding: 25px;
      margin-bottom: 25px;
      transition: transform 0.2s ease;
      display: flex;
      gap: 20px;
      align-items: center;
    }

    .cart-item:hover {
      transform: scale(1.02);
      box-shadow: 0 6px 20px rgba(0,0,0,0.08);
    }

    .cart-item img {
      width: 120px;
      height: 120px;
      object-fit: cover;
      border-radius: 12px;
      border: 2px solid #ffd0c0;
    }

    .cart-item-details {
      flex: 1;
    }

    .cart-item-details h3 {
      margin: 0 0 12px;
      font-size: 20px;
      color: #d33;
    }

    .cart-item-details p {
      margin: 4px 0;
      color: #555;
    }

    .quantity-controls {
      display: flex;
      align-items: center;
      gap: 15px;
      margin: 15px 0;
    }

    .quantity-btn {
      background: #ff6f61;
      color: white;
      border: none;
      padding: 8px 14px;
      font-size: 18px;
      border-radius: 50%;
      cursor: pointer;
      transition: background 0.3s;
    }

    .quantity-btn:hover {
      background: #e55347;
    }

    .quantity-btn:disabled {
      background: #ccc;
      cursor: not-allowed;
    }

    .remove-btn {
      background: #dc3545;
      color: white;
      border: none;
      padding: 10px 20px;
      border-radius: 8px;
      cursor: pointer;
      margin-top: 10px;
      font-weight: bold;
      transition: background 0.3s;
    }

    .remove-btn:hover {
      background: #c82333;
    }

    .cart-summary {
      background: #fff0e0;
      padding: 25px;
      border-radius: 15px;
      text-align: center;
      border: 2px dashed #ffb199;
    }

    .cart-summary h2 {
      margin: 0;
      font-size: 24px;
      color: #ff4e50;
    }

    .checkout-btn {
      background: #28a745;
      color: white;
      border: none;
      padding: 14px 40px;
      border-radius: 50px;
      cursor: pointer;
      font-size: 18px;
      margin-top: 25px;
      font-weight: bold;
      transition: background 0.3s;
    }

    .checkout-btn:hover {
      background: #218838;
    }

    .continue-shopping {
      background: #343a40;
      color: white;
      padding: 12px 30px;
      border-radius: 50px;
      margin-top: 15px;
      display: inline-block;
      text-decoration: none;
      transition: background 0.3s;
    }

    .continue-shopping:hover {
      background: #23272b;
    }

    .empty-cart {
      text-align: center;
      color: #888;
      padding: 50px;
      background: #fff;
      border-radius: 16px;
    }
  </style>
</head>
<body>
  <div class="cart-container">
    <h1>Your Food Cart</h1>

    <!-- Cart Items -->
    <%! int total=0;%>
    <%
    int grandTotal=0;
    Cart cart=(Cart)session.getAttribute("cart");
    Integer restId=(Integer)session.getAttribute("RestaurantId");
    int  tId=restId;
    if(cart!=null&&!cart.getItems().isEmpty())
    {
      for(CartItem item:cart.getItems().values())
      {
        grandTotal=grandTotal+item.getTotalAmount();
    %>
    <div class="cart-item">
      <!-- Added image -->
      <img src="<%=item.getImage()%>" alt="<%=item.getName()%>">
      
      <div class="cart-item-details">
        <h3>Item Name: <%=item.getName()%></h3>
        <p style="color:red;">Price: <%=item.getPrice() %></p>

        <div class="quantity-controls">
          <form action="CartServlet" method="post">
            <input type="hidden" name="menu_id" value="<%=item.getId()%>">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="quantity" value="1">
            <input type="hidden" name="restaurant_id" value="<%=item.getRestaurantId()%>">
            <button type="submit" class="quantity-btn">-</button>
          </form>

          <p><%=item.getQuantity()%></p>

          <form action="CartServlet" method="post">
            <input type="hidden" name="menu_id" value="<%=item.getId()%>">
            <input type="hidden" name="action" value="add"/>
            <input type="hidden" name="quantity" value="1"/>
            <input type="hidden" name="restaurant_id" value="<%=tId%>">
            <button type="submit" class="quantity-btn">+</button>
          </form>
        </div>

        <form action="CartServlet" method="post">
          <input type="hidden" name="menu_id" value="<%=item.getId()%>"/>
          <input type="hidden" name="action" value="remove"/>
          <input type="hidden" name="restaurant_id" value= "<%=tId%>">
          <button type="submit" class="remove-btn">Remove</button>
          <p>Total amount <%=item.getTotalAmount()%></p>
        </form>
      </div>
    </div>
    <%
      }
    }
    %>

    <div class="cart-summary">
      <h2 style="background-color:cyan"><i>GrandTotal</i> <%=grandTotal%></h2>
      <a href="CheckOut.jsp"><button class="checkout-btn">Proceed to Checkout</button></a><br/>
      <a href="GetMenuServlet?restaurantId=<%=(Integer)session.getAttribute("RestaurantId")%>" class="continue-shopping">← Continue Shopping</a>
    </div>
  </div>
</body>
</html>
