package com.cbs.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnect {
  
	public static Connection getConnection() throws Exception{
		
		
		
		String url = "jdbc:mysql://127.0.0.1:3306/cbs";
		String id = "root";
		String pwd = "sudarsan";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		
		
		
		return con;
		
	}

}
