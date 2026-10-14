<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Signup - Foodie App</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #ff9966, #ff5e62);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        .container {
            background: #fff;
            padding: 40px;
            border-radius: 14px;
            box-shadow: 0 10px 20px rgba(0,0,0,0.2);
            width: 90%;
            max-width: 700px;
        }

        h1 {
            background: linear-gradient(to right, #ff9966, #ff5e62);
            color: white;
            padding: 15px;
            border-radius: 12px;
            text-align: center;
        }

        .error {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }

        form {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }

        form div.full {
            grid-column: span 2;
        }

        label {
            font-weight: 600;
        }

        input, textarea, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 8px;
            border: 1px solid #ccc;
        }

        button {
            grid-column: span 2;
            padding: 12px;
            background: linear-gradient(to right, #ff9966, #ff5e62);
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background: linear-gradient(to right, #e96b40, #ff3c3c);
        }

        .login-link {
            text-align: center;
            margin-top: 20px;
        }

        .login-link a {
            color: #ff5e62;
            text-decoration: none;
            font-weight: bold;
        }

    </style>
</head>
<body>
<div class="container">
    <h1>🍽️ Foodie App</h1>

    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
        <div class="error"><%= error %></div>
    <% } %>

    <form action="HelloServlet" method="post">
        <div>
            <label>Name</label>
            <input type="text" name="name" required>
        </div>

        <div>
            <label>Username</label>
            <input type="text" name="username" required>
        </div>

        <div>
            <label>Email</label>
            <input type="email" name="email" required>
        </div>

        <div>
            <label>Phone</label>
            <input type="text" name="phoneNumber" required>
        </div>

        <div class="full">
            <label>Address</label>
            <textarea name="address" rows="3" required></textarea>
        </div>

        <div>
            <label>Role</label>
            <select name="role" required>
                <option value="customer">Customer</option>
                <option value="admin">Admin</option>
            </select>
        </div>

        <div>
            <label>Password</label>
            <input type="password" name="password" required>
        </div>

        <button type="submit">Sign Up</button>
    </form>

    <div class="login-link">
        Already have an account? <a href="Login.jsp">Login</a>
    </div>
</div>
<h1>This is done</h1>
</body>
</html>
