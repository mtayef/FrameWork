package unitTestCase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ValidateDatabase {
	
	static String host = "localhost";
	static String port = "3306";
	
	@Test
	public static void validateDataBase() throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver loaded");
		
		Connection con = DriverManager.getConnection
		("jdbc:mysql://" + host + ":" + port + "/school", "root", "root");
		
		System.out.println("Connected to DB");
		
		Statement st= con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from students");
		
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
	}

}
