package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CartServlet() {
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
		
		HttpSession session = request.getSession();
        List<Item> cartItems = (List<Item>) session.getAttribute("cartItems");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        // Calculate total amount and other charges
        double totalAmount = 0.0;
        for (Item item : cartItems) {
            totalAmount += Double.parseDouble(item.getItemPrice()) * Integer.parseInt(item.getStock()); // Stock holds quantity
        }

        double serviceTax = totalAmount * 0.05; // Example: 5% service tax
        double deliveryCharge = 50; // Example: Flat delivery charge
        double finalAmount = totalAmount + serviceTax + deliveryCharge;

        // Set attributes for JSP
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("totalAmount", totalAmount);
        request.setAttribute("serviceTax", serviceTax);
        request.setAttribute("deliveryCharge", deliveryCharge);
        request.setAttribute("finalAmount", finalAmount);

        // Forward to JSP
        request.getRequestDispatcher("cart.jsp").forward(request, response);
		doGet(request, response);
	}

}
