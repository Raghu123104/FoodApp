<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.Model.Users" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard | Foodie World</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
  <style>
    body {
      font-family: 'Poppins', sans-serif;
      margin: 0;
      background: linear-gradient(135deg, #ff6f61, #ff9966);
      color: #fff;
    }
    header {
      background: rgba(0,0,0,0.6);
      padding: 1rem 2rem;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    header h1 {
      margin: 0;
      font-size: 1.8rem;
      font-weight: 600;
    }
    nav a {
      color: #fff;
      margin-left: 20px;
      text-decoration: none;
      font-weight: 500;
    }
    .dashboard {
      padding: 2rem;
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
      gap: 2rem;
    }
    .card {
      background: #fff;
      color: #333;
      border-radius: 15px;
      padding: 2rem;
      text-align: center;
      box-shadow: 0 8px 20px rgba(0,0,0,0.2);
      transition: transform 0.2s ease;
    }
    .card:hover {
      transform: translateY(-10px);
    }
    .card h2 {
      margin-bottom: 1rem;
      font-size: 1.5rem;
      color: #ff6f61;
    }
    .card a {
      display: inline-block;
      margin-top: 1rem;
      padding: 10px 20px;
      background: #ff6f61;
      color: #fff;
      border-radius: 8px;
      text-decoration: none;
      font-weight: 500;
      transition: background 0.3s ease;
    }
    .card a:hover {
      background: #ff4b2b;
    }
    footer {
      margin-top: 2rem;
      text-align: center;
      padding: 1rem;
      background: rgba(0,0,0,0.6);
    }
  </style>
</head>
<body>
<%
    Users currentUser = (Users) session.getAttribute("currentUser");
    if(currentUser == null || !"Admin".equals(currentUser.getRole())) {
        response.sendRedirect("login.jsp"); // security check
        return;
    }
%>

  <header>
    <h1>Admin Dashboard</h1>
    <nav>
      <span>Welcome, <%= currentUser.getName() %></span>
      <a href="LogoutServlet">Logout</a>
    </nav>
  </header>

  <section class="dashboard">
    <div class="card">
      <h2>Add Restaurant</h2>
      <p>Create a new restaurant profile with details and images.</p>
      <a href="AdminRes.jsp">Go</a>
    </div>

    <div class="card">
      <h2>View My Restaurants</h2>
      
      <p>See the list of restaurants you have added and manage them.</p>
      <a href="AdminRestaurantServlet?typ=view">Go</a>
    </div>

    <div class="card">
      <h2>Add items</h2>
      
      <p>Check performance, number of orders, and customer feedback.</p>
      <a href="AdminRestaurantServlet?typ=addItem">Coming Soon</a>
    </div>
  </section>

  <footer>
    <p>&copy; 2025 Foodie World. Admin Panel</p>
  </footer>

</body>
</html>
