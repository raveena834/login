package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginservlet() {
		super();
	}

	// doPost() method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("raveena")&& password.equals("123456")) {
			session.setAttribute("username", username);
			response.sendRedirect("welcome");
		}
		
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			out.println("<font color=red>Password is wrong.</font>");
			rd.include(request, response);
		}
		out.close();
	}
}

