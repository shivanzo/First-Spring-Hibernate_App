package com.shivan.test.db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "root";
		String pass = "test123";
		String jdbcUrl = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Connecting to database : " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("SUCCESS ...!! ");
			
			myConn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}		
		
	}

}
