<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.Item" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Items - Food Orders</title>
<link rel="stylesheet" href="css/displayItemsStyle.css">
</head>
<body>
	<!-- Navbar -->
    <nav class="navbar">
        <div class="navbar-brand">
            <a href="home.jsp">Food Orders</a>
        </div>
        <ul class="navbar-menu">
            <li><a href="BrowseItemsServlet">Browse Items</a></li>
            <li><a href="CartServlet">View Cart</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </nav>
    <!-- Navbar -->
    
    <!-- Header -->
    <header class="header">
        <h1>Browse Available Items</h1>
        <p>Find and add items to your cart for a delicious in-flight experience.</p>
    </header>
    <!-- Header -->
    
    <!-- Main Section to Display Items -->
    <section class="main-section">
        <h2>Available Items</h2>
        <form action = "BrowseItemsServlet" method="post">
        <div class="items-container">
            <%
                List<Item> itemList = (List<Item>) request.getAttribute("itemList");
                if (itemList != null && !itemList.isEmpty()) {
                    for (Item item : itemList) {
            %>
            <div class="item-card">
                <img src="images/<%= item.getItemName().replaceAll(" ", "_") %>.jpg" alt="<%= item.getItemName() %>" class="item-image">
                <h3><%= item.getItemName() %></h3>
                <p>Category: <%= item.getCategory() %></p>
                <p>Price: ₹<%= item.getItemPrice() %></p>
                <p>Stock: <%= item.getStock() %> available</p>
                <form action="AddToCartServlet" method="post">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <button type="submit" class="button">Add to Cart</button>
                </form>
            </div>
            <%
                    }
                } else {
            %>
            <p>No items available.</p>
            <%
                }
            %>
        </div>
        </form>
    </section>
	<!-- Main Section to Display Items -->
	
    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2024 Food Orders. All rights reserved.</p>
    </footer>
    <!-- Footer -->
</body>
</html>