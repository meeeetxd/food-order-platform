<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="Model.Item" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<link rel="stylesheet" href="css/cartStyles.css">
</head>
<body>
	<div class="navbar">
        <div class="navbar-brand">
            <a href="home.jsp">Food Orders</a>
        </div>
        <ul class="navbar-menu">
            <li><a href="browse">Browse Items</a></li>
            <li><a href="cart">Cart</a></li>
            <li><a href="logout">Logout</a></li>
        </ul>
    </div>
    
    <div class="main-section">
        <h1>Your Cart</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>Item Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Item> cartItems = (List<Item>) request.getAttribute("cartItems");
                    if (cartItems != null && !cartItems.isEmpty()) {
                        for (Item item : cartItems) {
                %>
                <tr>
                    <td><%= item.getItemName() %></td>
                    <td>₹ <%= item.getItemPrice() %></td>
                    <td><%= item.getStock() %></td>
                    <td>₹ <%= Double.parseDouble(item.getItemPrice()) * Integer.parseInt(item.getStock()) %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4">Your cart is empty.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <div class="total-summary">
            <h2>Summary</h2>
            <p>Total Amount: ₹ <%= request.getAttribute("totalAmount") %></p>
            <p>Service Tax (5%): ₹ <%= request.getAttribute("serviceTax") %></p>
            <p>Delivery Charge: ₹ <%= request.getAttribute("deliveryCharge") %></p>
            <h3>Final Amount: ₹ <%= request.getAttribute("finalAmount") %></h3>
        </div>

        <div class="action-buttons">
            <button class="button">Proceed to Checkout</button>
            <a href="browse" class="button">Continue Shopping</a>
        </div>
    </div>

    <div class="footer">
        <p>&copy; 2024 Food Orders. All Rights Reserved.</p>
    </div>
</body>
</html>