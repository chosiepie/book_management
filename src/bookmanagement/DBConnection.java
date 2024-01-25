package bookmanagement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String pass = "123456";
			String url ="jdbc:mysql://localhost:3306/mybook";
			
			con = DriverManager.getConnection(url, user, pass);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
	

}
