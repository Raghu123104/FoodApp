<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foodie App - Sign In</title>
    <style>
        body {
            font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: linear-gradient(135deg, #ff6347, #ffa500);
            overflow: hidden;
        }
        .signin-container {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 2.5rem;
            border-radius: 12px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 420px;
            backdrop-filter: blur(10px);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 2rem;
            font-size: 1.8rem;
            font-weight: 600;
            letter-spacing: 0.5px;
        }
        .form-group {
            margin-bottom: 1.5rem;
            position: relative;
        }
        label {
            display: block;
            margin-bottom: 0.5rem;
            color: #34495e;
            font-size: 0.9rem;
            font-weight: 500;
            transition: all 0.3s ease;
        }
        input {
            width: 100%;
            padding: 0.85rem;
            border: 1px solid #e0e0e0;
            border-radius: 6px;
            font-size: 1rem;
            background-color: #f9f9f9;
            transition: all 0.3s ease;
        }
        input:focus {
            outline: none;
            border-color: #ff6347;
            background-color: #fff;
            box-shadow: 0 0 8px rgba(255, 99, 71, 0.4);
            transform: translateY(-2px);
        }
        input:focus + label,
        input:not(:placeholder-shown) + label {
            transform: translateY(-1.5rem);
            font-size: 0.8rem;
            color: #ff6347;
        }
        button {
            width: 100%;
            padding: 0.85rem;
            background: linear-gradient(90deg, #ff6347, #ffa500);
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 1.1rem;
            font-weight: 500;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        button:hover {
            background: linear-gradient(90deg, #e5533d, #e69500);
            transform: scale(1.02);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
        }
        button:active {
            transform: scale(0.98);
        }
        .social-login {
            margin-top: 1.5rem;
            text-align: center;
        }
        .social-button {
            width: 100%;
            padding: 0.85rem;
            background-color: #f1f1f1;
            color: #333;
            border: 1px solid #ddd;
            border-radius: 6px;
            font-size: 1rem;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .social-button.google:hover {
            background-color: #e0e0e0;
            transform: scale(1.02);
        }
        .error-message {
            color: #d32f2f;
            text-align: center;
            margin-top: 1rem;
            font-size: 0.9rem;
            display: none;
        }
        .forgot-password {
            text-align: center;
            margin-top: 1.5rem;
        }
        .forgot-password a {
            color: #ff6347;
            text-decoration: none;
            font-size: 0.9rem;
            font-weight: 500;
        }
        .forgot-password a:hover {
            color: #e5533d;
            text-decoration: underline;
        }
        @media (max-width: 480px) {
            .signin-container {
                padding: 1.5rem;
                max-width: 90%;
            }
            h2 {
                font-size: 1.5rem;
            }
        }
    </style>
</head>
<body>
    <div class="signin-container">
        <h2>Foodie App - Sign In</h2>
        <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
      <div class="error"><%= error %></div>
    <% } %>
        <form action="LoginServlet" method="post"id="signin-form">
            <div class="form-group">
                <input type="email" id="username" name="email" placeholder=" " required>
                <label for="username">Email</label>
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" placeholder=" " required>
                <label for="password">Password</label>
            </div>
            <div class="error-message" id="error-message"></div>
           <a href="LoginServlet"></a> <button type="submit">Sign In</button>
            <div class="social-login">
                <button type="button" class="social-button google">Sign in with Google</button>
            </div>
            <div class="forgot-password">
                <a href="#">Forgot Password?</a>
            </div>
        </form>
    </div>
    
      
</body>
</html>