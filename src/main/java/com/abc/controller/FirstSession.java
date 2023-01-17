package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Collecting request parameters from request object
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");

		//
		HttpSession session = request.getSession();
		session.setAttribute("cid", cid);
		session.setAttribute("cname", cname);

		RequestDispatcher rd = request.getRequestDispatcher("/Form2.html");
		rd.forward(request, response);
		
	}
	

}
