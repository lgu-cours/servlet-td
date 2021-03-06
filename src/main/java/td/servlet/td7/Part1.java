package td.servlet.td7 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD 7 
 *  
 * @author Laurent GUERIN 
 * 
 */
@WebServlet(urlPatterns="/part1")
public class Part1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
	    String param = (String) request.getAttribute("param");
	    
	    ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();
		out.println("<div style='background-color:yellow' >");
		out.println("<h1>Part 1</h1>");
		out.println("<h2> Param = " + param + "</h2> ");
		out.println("<h2> ServletName = " + config.getServletName() + "</h2> ");
		out.println("<br>");
		out.println("<h4>Request URI = " + request.getRequestURI() + "</h4>");
		out.println("<h4>Servlet Path = " + request.getServletPath() + "</h4>");
		out.println("<h4>Path Info = " + request.getPathInfo() + "</h4>");
		out.println("<h4>Path Translated = " + request.getPathTranslated() + "</h4>");
		out.println("<h4>Protocol = " + request.getProtocol() + "</h4>");
		out.println("</div>");
	}
}
