package com.ssd.tour.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configs {
	
public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
		
		String connURL = "jdbc:mysql://localhost:3306/pvmstbooking";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connURL, "b27bd715e3b7e6", "28e05a89");
		return conn;
	}

}
