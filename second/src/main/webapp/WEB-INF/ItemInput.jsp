<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Item</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #74ebd5 0%, #ACB6E5 100%);
            margin: 0;
            padding: 0;
        }
        .form-container {
            width: 500px;
            background: #fff;
            margin: 50px auto;
            padding: 25px 30px;
            border-radius: 15px;
            box-shadow: 0px 8px 20px rgba(0,0,0,0.2);
            animation: fadeIn 0.6s ease-in-out;
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        label {
            font-weight: bold;
            margin-bottom: 6px;
            display: block;
            color: #444;
        }
        input[type="text"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 18px;
            border: 1px solid #ccc;
            border-radius: 8px;
            outline: none;
            transition: 0.3s;
        }
        input[type="text"]:focus,
        input[type="number"]:focus,
        textarea:focus {
            border-color: #6a5acd;
            box-shadow: 0 0 8px rgba(106, 90, 205, 0.4);
        }
        textarea {
            resize: none;
        }
        .form-check {
            margin-bottom: 18px;
        }
        .form-check label {
            display: inline-block;
            font-weight: normal;
            margin-left: 6px;
            color: #333;
        }
        button {
            width: 100%;
            background: linear-gradient(135deg, #6a5acd, #836fff);
            color: white;
            border: none;
            padding: 12px;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }
        button:hover {
            background: linear-gradient(135deg, #836fff, #6a5acd);
            transform: scale(1.03);
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Add New Item</h2>
    <form action="AddItemServlet" method="post">
    restaurantId
		itemName
		description
		price
		isAvailable
		image
       
        <!-- Hidden field (value from request attribute) -->
        <input type="hidden" name="hiddenValue" value="${param.restaurantId}">

        <!-- Item Name -->
        <label for="itemName">Item Name</label>
        <input type="text" id="itemName" name="itemName" placeholder="Enter item name" required>

        <!-- Description -->
        <label for="description">Description</label>
        <textarea id="description" name="description" rows="3" placeholder="Enter description" required></textarea>

        <!-- Price -->
        <label for="price">Price</label>
        <input type="number" id="price" name="price" placeholder="Enter price" required>

        <!-- Rating -->
        <label for="rating">Rating</label>
        <input type="number" id="rating" name="rating" step="0.1" min="0" max="5" placeholder="0 - 5" required>

        <!-- Availability -->
        <div class="form-check">
            <input type="checkbox" id="isAvailable" name="isAvailable" value="true">
            <label for="isAvailable">Available</label>
        </div>

        <!-- Image URL -->
        <label for="image">Image URL</label>
        <input type="text" id="image" name="image" placeholder="Enter image URL">

        <!-- Submit -->
        <button type="submit">Submit Item</button>
    </form>
</div>

</body>
</html>
