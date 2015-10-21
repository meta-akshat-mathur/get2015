package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connutil.ConnectionUtil;

import java.sql.*;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username, password, email;
		username = request.getParameter("userName").toString();
		password = request.getParameter("password").toString();
		email = request.getParameter("eMailID").toString();
		String query = "SELECT * FROM Registration";
		Connection con = null;
		int isInsert = 0;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		ResultSet rs = null;
		con = conUtil.getConnection();
		boolean usernameExist = false;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			String existUserName;
			while (rs.next()) {
				existUserName = rs.getString("userName");
				if (existUserName.equals(username)) {
					usernameExist = true;
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (usernameExist == true) {
			out.print("User Name already exist");
		} else {
			try {
				query = "INSERT INTO Registration VALUES('" + username + "','"
						+ password + "','" + email + "')";

				try {
					stmt = con.createStatement();
					isInsert = stmt.executeUpdate(query);
					if (isInsert != 0) {
						out.print("Data Inserted Successfully ..");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					/* close connection */
					try {
						if (con != null) {
							con.close();
						}
						if (stmt != null) {
							stmt.close();
						}

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			} catch (Exception e) {
				out.print("Can't insert");
			}
		}
		out.print("<br><a href='Form.jsp'>Go to home.........</a>");
	}
}
