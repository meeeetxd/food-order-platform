package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import DAO.UserDAO;
import Model.User;
import Utility.Database;

/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        
        try {
        	Connection conn = Database.initializeDatabase();
        	UserDAO userDAO = new UserDAO(conn);
        	
        	if(userDAO.registration(user)) {
        		response.sendRedirect("login.jsp");
        	}else {
        		response.sendRedirect("register.jsp?error=Registration Failed");
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        	response.sendRedirect("register.jsp?error=Database error");
        }
        
		doGet(request, response);
	}

}
