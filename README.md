"# food-order-platform" 
**Overview:**
This project is a dynamic web-based food ordering platform built using Java Servlets, JSP (Java Server Pages), and MySQL. It allows users to browse available food items, manage their cart, place orders, and view their order history. The platform supports multiple users, session management, and displays real-time stock and price information.

**Features:**
User Registration & Login: Users can register, log in, and maintain sessions.
Item Browsing: Browse available food items categorized by type (meals, snacks, beverages).
Cart Management: Add items to a cart, update quantities, and view the final amount.
Checkout: Review the cart, apply service tax, and place orders.
Order History: Users can view their past orders.
Security: Users are authenticated using sessions.
Technologies Used
Java: Servlets, JSP
MySQL: Database for storing user details, items, orders, and cart details.
Tomcat Server: Web application server for running servlets and JSP.
HTML/CSS: For front-end design.
JSTL: Used in JSP for tag-based programming.

**Project Structure**

FoodOrderingPlatform/
│
├── src/
│   ├── Controller/
│   │   ├── BrowseItemsServlet.java
│   │   ├── CartServlet.java
│   │   ├── OrderHistoryServlet.java
│   │   ├── CheckoutServlet.java
│   │   └── LoginServlet.java
│   │   └── RegisterServlet.java
│   │
│   ├── Model/
│   │   ├── User.java
│   │   ├── Item.java
│   │   ├── Order.java
│   │   └── Cart.java
│   │
│   ├── Utility/
│   │   └── Database.java
│   │
├── WebContent/
│   ├── css/
│   │   └── style.css
│   ├── home.jsp
│   ├── login.jsp
│   ├── register.jsp
│   ├── displayItems.jsp
│   ├── orderHistory.jsp
│   ├── cart.jsp
│   └── checkout.jsp
│
├── WEB-INF/
│   ├── web.xml
│   └── lib/
│
└── README.md

**Setup Instructions**

**Prerequisites**
JDK 17 or above
Apache Tomcat 10.x
MySQL 8.x
Eclipse IDE (or any other Java IDE like IntelliJ or NetBeans)

Step-by-Step Setup
Clone the Repository:
git clone https://github.com/your-repo/food-ordering-platform.git
Database Setup:

Create a MySQL database named FoodOrderingDB.

Use the following SQL script to create the required tables:

CREATE DATABASE FoodOrderingDB;
USE FoodOrderingDB;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
);

CREATE TABLE items (
    itemid INT AUTO_INCREMENT PRIMARY KEY,
    itemName VARCHAR(255),
    itemPrice DECIMAL(10,2),
    category VARCHAR(255),
    stock INT
);

CREATE TABLE orders (
    orderId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT,
    orderDate DATE,
    totalAmount DECIMAL(10,2),
    status VARCHAR(50),
    FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE cart (
    cartId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT,
    itemId INT,
    quantity INT,
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (itemId) REFERENCES items(itemid)
);
Insert sample data into items and users tables as needed.

**Configure Database Connection:**

Edit the Database.java file in the Utility package to match your MySQL credentials.

private static final String URL = "jdbc:mysql://localhost:3306/FoodOrderingDB";
private static final String USER = "root";
private static final String PASSWORD = "your-password";
Configure Tomcat in Eclipse:

Right-click the project in Eclipse and go to Properties > Project Facets. Ensure Dynamic Web Module and Java are selected.
In Server tab, add Apache Tomcat 10.x.
Right-click the project, choose Run As > Run on Server, and select Tomcat.

**Run the Project:**

Open the project in your browser using http://localhost:8080/FoodOrderingPlatform/.
You should see the login page.

**Usage**

Login/Register: Navigate to http://localhost:8080/FoodOrderingPlatform/ and log in or register.
Browse Items: View all available food items categorized by meals, snacks, or beverages.
Add to Cart: Select items and add them to your cart.
View Cart: Check your cart contents and the total amount, including applicable service tax.
Checkout: Confirm your order and place it.
Order History: Review your past orders.

**Servlet Overview**

BrowseItemsServlet: Fetches and displays available items from the database.
CartServlet: Manages items in the user's cart, allows adding/removing items.
OrderHistoryServlet: Displays past orders for the logged-in user.
CheckoutServlet: Handles the checkout process and finalizes orders.
LoginServlet and RegisterServlet: Manage user authentication and registration.

**Future Enhancements**

Payment Gateway Integration: Adding support for real payments.
Admin Module: To manage items, users, and orders.
User Profile Management: Allow users to update their profile and address information.

**Contact**
For any issues or questions, feel free to reach out to meethilpatel92@gmail.com.
