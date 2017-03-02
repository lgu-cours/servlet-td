package td.servlet.td1 ;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * TD 1 
 * @author Laurent GUERIN 
 * 
 */
public class Hello extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	//--- Http GET method 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException
	{
		process(request, response);
	}

	//--- Http POST method 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException
	{
		process(request, response);
	}
	
	
	/**
	 * Méthode qui permet de traiter de la même façon les requêtes http GET et POST 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void process(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException
	{
		// Type MIME de la réponse 
		response.setContentType("text/html");
		
		// Flux d'écriture pour générer la réponse
		PrintWriter out = response.getWriter();
		
		// Ecriture de la page HTML  
        out.println("<html>");
        out.println(" <head>");
        out.println("  <title>Hello</title>");
        out.println(" </head>");
        out.println(" <body>");
		
		out.println("<h1>Hello world ! </h1>");
		out.println("<h1>getServletName() : " + getServletName() + "</h1>");
		out.println("<h1>URI  : " + request.getRequestURI() + "</h1>");
		
        out.println(" </body>");
        out.println("</html>");
		
	}

}
