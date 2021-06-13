package com.wipro.bus.util;
import java.sql.*;
public class DBUtil {
	private static Connection con=null;
	
	public  Connection getDBConnection()
	{
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String s="jdbc:mysql://localhost:3306/blue_bus";
		con=DriverManager.getConnection(s,"root","Harshith@123");
		}
		catch(Exception e)
		{
			
		}
		return con;
		
	}
	

}
