package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/third")
public class ThirdSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Setting MIME Type
		response.setContentType("text/html");

		// Collecting request parameters from request object
		String cmobile = request.getParameter("cmobile");
		String cmail = request.getParameter("cmail");

		HttpSession session = request.getSession(false);
		session.setAttribute("cmobile", cmobile);
		session.setAttribute("cmail", cmail);

		// Take All the data from session object, prepare the data in the table format
		// and send the response
		Object cid = session.getAttribute("cid");
		Object cname = session.getAttribute("cname");
		Object cage = session.getAttribute("cage");
		Object caddress = session.getAttribute("caddress");
		Object mobile = session.getAttribute("cmobile");
		Object mail = session.getAttribute("cmail");

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Response</title></head>");
		out.println("<body style='background-color:pink'>");
		out.println("<h1 style='text-align:center; color:blue'>Employee Registration Page</h1>");
		out.println("<table border='1'  style='margin-left:auto; margin-right:auto'>");
		out.println("<tr><th>Key</th><th>Value</th></tr>");
		out.println("<tr><td>CID</td><td>" + cid + "</td></tr>");
		out.println("<tr><td>CNAME</td><td>" + cname + "</td></tr>");
		out.println("<tr><td>CAGE</td><td>" + cage + "</td></tr>");
		out.println("<tr><td>CAADRESS</td><td>" + caddress + "</td></tr>");
		out.println("<tr><td>CMOBILE</td><td>" + mobile + "</td></tr>");
		out.println("<tr><td>CMAIL</td><td>" + mail + "</td></tr>");
		out.println("<tr><td><input type='submit' value='register'></td></tr>");
		out.println("</table>");
		out.println("</body></html>");

		
		out.close();
	}

}
