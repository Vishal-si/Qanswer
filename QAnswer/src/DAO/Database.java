package DAO;

import java.sql.Connection;
import java.sql.DriverManager;



public class Database {
	
	public static Connection getConn()
	{
		Connection conn=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QAnswer","root","root");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getName());
		}
		return conn;
		
	}

}
