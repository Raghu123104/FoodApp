<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Order Confirmation</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to top, #b2ebf2, #ffffff);
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            overflow: hidden;
        }

        .confirmation-message {
            text-align: center;
            padding-top: 60px;
        }

        h1 {
            color: #2e7d32;
            font-size: 3rem;
            margin-bottom: 10px;
        }

        p {
            font-size: 1.2rem;
            color: #333;
            margin-bottom: 20px;
        }

        .btn {
            background-color: #388e3c;
            color: white;
            padding: 12px 30px;
            border: none;
            border-radius: 25px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .btn:hover {
            background-color: #2e7d32;
            transform: scale(1.05);
        }

        /* Animation Area */
        .animation-container {
            position: relative;
            height: 200px;
            background: #f5f5f5;
            width: 100%;
            border-top: 4px dashed #aaa;
            overflow: hidden;
        }

        .bike-man {
            width: 160px;
            height: 100px;
            position: absolute;
            bottom: 20px;
            animation: ride 7s linear infinite;
        }

        .bike {
            width: 100%;
            height: 100%;
            background: url('images/bicycle.jpg') no-repeat center;
            background-size: contain;
            filter: drop-shadow(3px 4px 4px rgba(0,0,0,0.4));
        }

        @keyframes ride {
            0% {
                left: -180px;
            }
            100% {
                left: 110%;
            }
        }

        .road {
            position: absolute;
            bottom: 0;
            height: 30px;
            width: 100%;
            background: #444;
            background-image: repeating-linear-gradient(
                to right,
                #ccc,
                #ccc 20px,
                #444 20px,
                #444 40px
            );
            animation: moveRoad 1s linear infinite;
        }

        @keyframes moveRoad {
            0% { background-position-x: 0; }
            100% { background-position-x: 40px; }
        }

    </style>
</head>
<body>

    <!-- Top Message -->
    <div class="confirmation-message">
        <h1>✅ Order Confirmed!</h1>
        <p>Your order is on the way. A delivery hero is bringing it to you 🚴‍♂️</p>
        <form action="HomeServlet">
            <button type="submit" class="btn">Back to Home</button>
        </form>
    </div>

    <!-- Bottom Animation Area -->
    <div class="animation-container">
        <div class="bike-man">
            <div class="bike"></div>
        </div>
        <div class="road"></div>
    </div>

</body>
</html>
    