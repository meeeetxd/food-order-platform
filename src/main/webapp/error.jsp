<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="error-container">
        <h1>Something went wrong!</h1>
        <p>An error occurred while processing your request.</p>
        
        <h3>Error Details:</h3>
        <p><%= request.getAttribute("errorMessage") %></p>
        
        <a href="home.jsp">Go Back to Home</a>
    </div>
</body>
</html>