<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h2>User Registration</h2>
	<form action = "RegisterServlet" method="post">
		Name: <input type="text" name="name" required><br>
		Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <button type="submit">Register</button>
	</form>
	<a href="login.jsp">Already have an account? Login</a>
</body>
</html>