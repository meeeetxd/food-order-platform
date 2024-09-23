<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="Model.User" %>

<%
    HttpSession session1 = request.getSession(false);
    User user = (User) session1.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/homeStyles.css">
</head>
<body>
<!-- NAVBAR -->
	<nav class="navbar">
        <div class="navbar-brand">
            <a href="#">Food Orders</a>
        </div>
        <ul class="navbar-menu">
            <li><a href="BrowseItemsServlet">Browse Items</a></li>
            <li><a href="CartServlet">View Cart</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </nav>
<!-- NAVBAR -->

	    <!-- Header Section -->
    <header class="header">
        <h1>Welcome to Food Orders, <%= user.getUsername() %>!</h1>
        <p>Find your favorite meals and order them online.</p>
    </header>
		<!-- Header Section -->
		
		<!-- Main Content Section -->
    <section class="main-section">
        <h2>What would you like to do today?</h2>
        <div class="action-buttons">
            <a class="button" href="BrowseItemsServlet">Browse Items</a>
            <a class="button" href="CartServlet">View Cart</a>
            <a class="button" href="LogoutServlet">Logout</a>
        </div>
    </section>
    	<!-- Main Content Section -->
    	
    	<!-- Footer Section -->
    <footer class="footer">
        <p>&copy; 2024 Food Orders. All rights reserved.</p>
    </footer>
    	<!-- Footer Section -->
    	
</body>
</html>