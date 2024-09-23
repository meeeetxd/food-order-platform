package DAO;
import Model.User;
import Utility.Database;
import java.sql.*;

public class UserDAO {
	private Connection conn;
	
	public UserDAO(Connection conn) {
		this.conn = conn;
	}
	public boolean registration(User user) throws SQLException{
		String query = "insert into Users (username,email,password,role) values(?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getPassword());
		stmt.setString(4, user.getRole());
		
		return stmt.executeUpdate() > 0;
	}
	
	public User loginUser(String email, String password) throws SQLException{
		String query = "select * from users where email = ? and password = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, email);
		stmt.setString(2, password);
		
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setUserid(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			return user;
			
		}
		return null;
	}
	
}
