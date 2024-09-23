package Utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private static final String URL = "jdbc:mysql://localhost:3306/FoodOrderingDB";
    private static final String USER = "root";
    private static final String PASSWORD = "meet21";
    
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

