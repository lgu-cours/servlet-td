package td.servlet.td7 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD 7 
 *  
 * @author Laurent GUERIN 
 * 
 */

public class Contenu extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	//--- Requete GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException
	{
		process(request, response);
	}
	//--- Requete POST 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException
	{
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException
	{
//		response.setContentType("text/html");
	    String sParam = (String) request.getAttribute("param");
	    
	    ServletConfig config = getServletConfig();
	    
	    
		PrintWriter out = response.getWriter();
		out.println("<div style='background-color:yellow' >");
		out.println("<h1>Servlet Contenu</h1>");
		out.println("<h2> Param = " + sParam + "</h2> ");
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
