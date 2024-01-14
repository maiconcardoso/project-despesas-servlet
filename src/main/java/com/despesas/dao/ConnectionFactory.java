package com.despesas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class ConnectionFactory {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/despesas?useTimeZone=true&serverTimeZone=UTC";
	private String username = "root";
	private String password = "root";
	
	public Connection connect() throws ClassNotFoundException, SQLException {
		Connection connect = null;
		
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection(url, username, password);
			return connect;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
