import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DatabaseConnection {
	
	Connection conn=null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionURL="jdbc:mysql://127.0.0.1:3306/apothiki";
			String username="root";
			String password="test123";
			Connection conn=DriverManager.getConnection(connectionURL,username,password);
			
			
			JOptionPane.showMessageDialog(null,"Connection Successful" );
			System.out.println(conn);
			return conn;
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e );
			return null;
		}
	}
}
