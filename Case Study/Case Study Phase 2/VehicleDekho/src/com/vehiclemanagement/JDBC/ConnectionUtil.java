package com.vehiclemanagement.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/vehiclemanagement";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";

	public static Connection getConnection() {
		/* register driver */
		Connection con = null;
		/* open connection */
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}