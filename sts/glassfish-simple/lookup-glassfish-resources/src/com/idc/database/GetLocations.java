package com.idc.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/*
http://localhost:4980/lookup-glassfish-resources/GetLocations
 */

@WebServlet("/GetLocations")
public class GetLocations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        InitialContext ctx = new InitialContext();
	        DataSource ds = (DataSource) ctx.lookup("jdbc/hes-pool");
	        Connection connection = ds.getConnection();
	        if (connection == null)
	        {
	            throw new SQLException("Error establishing connection!");
	        }
	        String query = "SELECT * FROM hes_db.hes_locations";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next())
	        {
	            System.out.println("Branch: "+rs.getString("branch"));
	        }
		}
		catch (NamingException e) {
			throw new RuntimeException(e);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
