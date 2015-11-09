package com.vehiclemanagement.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper {

	private static ResultSet resultSet = null;
	private static Statement statement = null;

	public static ResultSet executeQuery(String query) {

		Connection con = ConnectionUtil.getConnection();
		System.out.println("con is" + con);
		try {
			statement = con.createStatement();
			System.out.println("statement is" + statement);
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSet;
	}

	public int executeUpdateQueryUsingStatement(String query) {
		int checkUpdate = 0;
		Connection connection = null;
		Statement statement = null;
		connection = ConnectionUtil.getConnection();
		try {
			statement = connection.createStatement();
			checkUpdate = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				ConnectionUtil.closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return checkUpdate;
	}
}
