package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import Model.Order;
import Model.OrderHistory;
import Utility.Database;

/**
 * Servlet implementation class orderHistory
 */
@WebServlet("/OrderHistoryServlet")
public class orderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public orderHistory() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
        
        // Ensure user is logged in
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        int userId = (Integer) session.getAttribute("userId");

        List<OrderHistory> orderHistory = new ArrayList<>();
        
        try {
        	Connection conn = Database.initializeDatabase();
        		String query = "SELECT * FROM orders WHERE userId = ?";
        		PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, userId);
        		
                ResultSet rs = statement.executeQuery();
                
                while (rs.next()) {
                    OrderHistory order = new OrderHistory();
                    order.setOrderId(rs.getInt("orderId"));
                    order.setItemName(rs.getString("itemName"));
                    order.setOrderDate(rs.getDate("orderDate"));
                    order.setQuantity(rs.getInt("quantity"));
                    order.setPrice(rs.getDouble("totalPrice"));

                    orderHistory.add(order);
        	}
                request.setAttribute("orderHistory", orderHistory);
                request.getRequestDispatcher("orderHistory.jsp").forward(request, response);
        	
        }catch(Exception e) {
        	e.printStackTrace();
        	response.sendRedirect("error.jsp");
        }
        
		doGet(request, response);
	}

}
