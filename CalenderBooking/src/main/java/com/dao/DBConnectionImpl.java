package com.dao;

import java.sql.*;

public class DBConnectionImpl implements DBConnection{

	public Connection getDBConnection() {
		Connection con = null;
		String dbUser = "root";
		String dbPass = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduleBooking?useSSL=false", dbUser, dbPass);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
