package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class welcome
 */

public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		// request.getSession().removeAttribute("");
		// out.print("<h1>Welcome</h1>");
		/*
		 * HttpSession session = request.getSession();
		 * 
		 * if(session != null) { String username = (String)
		 * session.getAttribute("username"); out.print("Welcome");
		 * out.print("<br/><a href=\"logout\">Logout</a>"); } else {
		 * response.sendRedirect("login.jsp"); } out.close(); }
		 */
		PrintWriter pr = response.getWriter();

		HttpSession session = request.getSession();

		if (session != null) {
			String username = (String) session.getAttribute("username");
			pr.print("<h1>Welcome "+ username +" </h1>");
			pr.print("<br/><a href=\"logout\">Logout</a>");
		} else {
			response.sendRedirect("login.jsp");
		}
		pr.close();
	}
}
