package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import Model.Item;
import Utility.Database;

/**
 * Servlet implementation class BrowseItemsServlet
 */
@WebServlet("/BrowseItemsServlet")
public class BrowseItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowseItemsServlet() {
        super();
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
		List<Item> itemList = new ArrayList<>();
		
		
		try {
			Connection connection = Database.initializeDatabase();
			Statement stmt = connection.createStatement();
			
			String query = "select * from items";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getInt("itemid"));
                item.setItemName(rs.getString("itemName"));
                item.setItemPrice(rs.getString("itemPrice"));
                item.setCategory(rs.getString("category"));
                item.setStock(rs.getString("stock"));
                itemList.add(item);
			}
			request.setAttribute("itemList", itemList);
			request.getRequestDispatcher("displayItems.jsp").forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occured whil retrieving items available");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		//doGet(request, response);
	}

}
