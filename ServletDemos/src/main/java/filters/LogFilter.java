package filters;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LogFilter
 */
public class LogFilter extends HttpFilter {
       
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("------------------------------------------------------");
        System.out.println(" init method is called in " + this.getClass().getName());
        System.out.println("------------------------------------------------------");
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println(" doFilter method is called in " + this.getClass().getName() + "\n\n");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		String ipAddress = request.getRemoteAddr();
		
		System.out.println("IP " + ipAddress + ", Time "+ new Date().toString() + "\n\n");
		
		// display request url ex: login, welcome, adduser etc...
		
		String uri2 = request.getScheme() + "://" +   // "http" + "://
	             request.getServerName() +       // "myhost"
	             ":" +                           // ":"
	             request.getServerPort() +       // "8080"
	             request.getRequestURI() +       // "/people"
	             "?" +                           // "?"
	             request.getQueryString();       // "lastname=Fox&age=30"
		
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		
		System.out.println("URI " + uri );
		if(uri.equalsIgnoreCase("/servlets/loginservlet") || uri.equalsIgnoreCase("/servlets/logoutservlet") ) {
			System.out.println("--- Accessing Login/Logout ---");
		} else {
			System.out.println("--- Accessing inner pages");
			String userName = (String) session.getAttribute("username");
			if(userName==null)
			{
				System.out.println("Username not found");
			} else {
				System.out.println("user logged in");
			}
			
		}
		
		chain.doFilter(request, response);
	}	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------------------");
        System.out.println(" destroy method is called in " + this.getClass().getName());
        System.out.println("------------------------------------------------------");
	}
	
	

}
