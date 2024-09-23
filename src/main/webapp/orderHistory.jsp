<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Order" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
<link rel="stylesheet" href="css/homeStyle.css">
</head>
<body>
	<header class="navbar">
        <div class="navbar-brand">
            <a href="home.jsp">Food Orders</a>
        </div>
        <ul class="navbar-menu">
            <li><a href="BrowseItemsServlet">Browse Items</a></li>
            <li><a href="CartServlet">View Cart</a></li>
            <li><a href="OrderHistoryServlet">Order History</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </header>

    <section class="main-section">
        <h2>Your Order History</h2>

        <table border="1">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Status</th>
                    <th>Total Amount (INR)</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Order> orderHistory = (List<Order>) request.getAttribute("orderHistory");
                    if (orderHistory != null && !orderHistory.isEmpty()) {
                        for (Order order : orderHistory) {
                %>
                <tr>
                    <td><%= order.getOrderId() %></td>
                    <td><%= order.getOrderDate() %></td>
                    <td><%= order.getStatus() %></td>
                    <td>₹ <%= order.getTotalAmount() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4">You have no past orders.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </section>

    <footer class="footer">
        <p>&copy; 2024 Food Orders. All Rights Reserved.</p>
    </footer>
    
</body>
</html>