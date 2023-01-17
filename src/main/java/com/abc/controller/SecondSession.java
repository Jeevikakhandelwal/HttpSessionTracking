package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				// Collecting request parameters from request object
				String cage = request.getParameter("cage");
				String caddress = request.getParameter("caddress");
				
				HttpSession session = request.getSession(false);
				session.setAttribute("cage", cage);
				session.setAttribute("caddress", caddress);

				RequestDispatcher rd = request.getRequestDispatcher("/Form3.html");
				rd.forward(request, response);
	}

}
