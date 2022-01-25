package org.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String loginId = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(String.format("username:%s,password:%s", loginId, password));
		// todo validate cridentals
		RequestDispatcher rd = request.getRequestDispatcher("productmenu.html");

		rd.include(request, response);
		out.close();
	}

}
