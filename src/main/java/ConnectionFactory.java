import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/despesas";
	private String username = "root";
	private String password = "mysql@123";
	
	public Connection connect() throws ClassNotFoundException {
		try {			
			Class.forName(driver);
			Connection connect = DriverManager.getConnection(url, username, password);	
			return connect;
		} catch(SQLException e ) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
