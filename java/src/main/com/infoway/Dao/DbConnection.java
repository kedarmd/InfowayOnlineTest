package com.infoway.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","mayur");
		
		return con;
		
	}
}
