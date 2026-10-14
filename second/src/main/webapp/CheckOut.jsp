<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Checkout</title>
  <style>
    body {
      font-family: 'Roboto', sans-serif;
      margin: 0;
      padding: 0;
      background: linear-gradient(135deg, #74ebd5, #ACB6E5);
      min-height: 100vh;
    }

    .container {
      max-width: 600px;
      width: 90%;
      margin: 50px auto;
      background-color: #fff;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
    }

    h1 {
      text-align: center;
      margin-bottom: 30px;
      color: #333;
    }

    .checkout-form {
      display: flex;
      flex-direction: column;
    }

    label {
      margin-top: 15px;
      margin-bottom: 5px;
      font-weight: 600;
    }

    textarea,
    select {
      padding: 12px;
      font-size: 16px;
      border-radius: 8px;
      border: 1px solid #ccc;
      resize: vertical;
      width: 100%;
      box-sizing: border-box;
    }

    textarea {
      min-height: 120px;
    }

    button {
      margin-top: 25px;
      padding: 14px;
      font-size: 18px;
      background-color: #28a745;
      color: white;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    button:hover {
      background-color: #218838;
    }

    @media (max-width: 480px) {
      .container {
        padding: 20px;
      }

      button {
        font-size: 16px;
        padding: 12px;
      }
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Checkout</h1>
    <form action="CheckOutSevlet" method="post" class="checkout-form" >

      <label for="address">Delivery Address</label>
      <textarea id="address" placeholder="Enter your full address..." name="addre" required></textarea>

      <label for="payment">Payment Mode</label>
      <select id="payment"  name="paym"required>
        <option value="" disabled selected name="paym">Select Payment Mode</option>
        <option value="cod" name="paym">Cash on Delivery</option>
        <option value="upi" name="paym">UPI</option>
        <option value="card" name="paym">Credit/Debit Card</option>
        <option value="netbanking" name="paym">Net Banking</option>
      </select>
      <input type="text" name="status"value="delievery" hidden>

    <button type="submit">Submit Order</button>
    </form>
  </div>
</body>
</html>
    