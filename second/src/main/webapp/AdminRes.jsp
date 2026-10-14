<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Restaurant</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body { 
            font-family: 'Poppins', sans-serif; 
            margin: 0; 
            padding: 0; 
            background: linear-gradient(135deg, #43cea2, #185a9d); /* teal to blue */
            display: flex; 
            justify-content: center; 
            align-items: center; 
            min-height: 100vh; 
        }
        .container { 
            width: 90%; 
            max-width: 600px; 
            background: #fff; 
            padding: 40px; 
            box-shadow: 0 10px 30px rgba(0,0,0,0.2); 
            border-radius: 20px; 
            animation: fadeIn 1s ease-in-out; 
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-30px); }
            to { opacity: 1; transform: translateY(0); }
        }
        h2 { 
            text-align: center; 
            color: #185a9d; 
            margin-bottom: 25px; 
            font-weight: 600;
        }
        form { display: flex; flex-direction: column; gap: 20px; }

        /* Floating label input box */
        .input-group {
            position: relative;
        }
        .input-group input {
            width: 100%;
            padding: 14px 12px;
            border: 2px solid #ccc;
            border-radius: 10px;
            font-size: 1rem;
            outline: none;
            transition: 0.3s;
        }
        .input-group label {
            position: absolute;
            top: 50%;
            left: 12px;
            transform: translateY(-50%);
            color: #888;
            font-size: 0.95rem;
            pointer-events: none;
            transition: 0.3s;
            background: #fff;
            padding: 0 5px;
        }
        .input-group input:focus,
        .input-group input:valid {
            border-color: #43cea2;
            box-shadow: 0 0 8px rgba(67,206,162,0.5);
        }
        .input-group input:focus + label,
        .input-group input:valid + label {
            top: -8px;
            left: 10px;
            font-size: 0.8rem;
            color: #185a9d;
        }

        /* Checkbox style */
        .checkbox-label {
            display: flex;
            align-items: center;
            gap: 10px;
            font-size: 0.95rem;
            color: #444;
        }
        .checkbox-label input {
            width: 18px;
            height: 18px;
            accent-color: #43cea2;
        }

        /* File input style */
        .file-input {
            padding: 12px;
            border: 2px dashed #43cea2;
            border-radius: 10px;
            cursor: pointer;
            transition: 0.3s;
        }
        .file-input:hover {
            border-color: #185a9d;
            background: #f0f8ff;
        }

        /* Button style */
        button { 
            padding: 14px; 
            background: linear-gradient(135deg, #43cea2, #185a9d); 
            border: none; 
            border-radius: 12px; 
            color: #fff; 
            font-weight: bold; 
            cursor: pointer; 
            font-size: 1rem; 
            transition: transform 0.2s ease, background 0.3s ease; 
        }
        button:hover { 
            transform: scale(1.05);
            background: linear-gradient(135deg, #185a9d, #43cea2); 
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Add New Restaurant</h2>
    <form action="AddRestaurantServlet" method="post" enctype="multipart/form-data">
        
        <div class="input-group">
            <input type="text" name="name" required>
            <label>Name</label>
        </div>

        <div class="input-group">
            <input type="text" name="address" required>
            <label>Address</label>
        </div>

        <div class="input-group">
            <input type="text" name="phone">
            <label>Phone</label>
        </div>

        <div class="input-group">
            <input type="number" name="rating" min="0" max="5" value="0">
            <label>Rating</label>
        </div>

        <div class="input-group">
            <input type="text" name="cusineType">
            <label>Cuisine Type</label>
        </div>

        <label class="checkbox-label">
            <input type="checkbox" name="isActive" value="true" checked> Active
        </label>

        <div class="input-group">
            <input type="number" name="adminUserId" required>
            <label>Admin User ID</label>
        </div>

        <label>Upload Image</label>
        <input class="file-input" type="file" name="imageFile" accept="image/*">

        <button type="submit">➕ Add Restaurant</button>
    </form>
</div>

</body>
</html>
