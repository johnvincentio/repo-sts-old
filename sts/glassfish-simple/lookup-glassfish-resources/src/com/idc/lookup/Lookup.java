package com.idc.lookup;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
http://localhost:4980/lookup-glassfish-resources/Lookup
 */

@WebServlet("/Lookup")
public class Lookup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Starting...");
			InitialContext ic = new InitialContext();
			String my_string = (String) ic.lookup("resource/my_string");
			System.out.println("my_string "+my_string);
			boolean my_boolean_flag = (Boolean) ic.lookup("resource/my_boolean_flag");
			System.out.println("my_boolean_flag "+my_boolean_flag);

			double my_double = (Double) ic.lookup("resource/my_double");
			System.out.println("my_double "+my_double);

		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Ending...");
	}

}
