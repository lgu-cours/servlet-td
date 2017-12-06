package td.servlet.mvc ;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * TD 8 - Add with JSON result
 *  
 * @author Laurent GUERIN 
 * 
 */
//@WebServlet(name="add-view-html", urlPatterns="/add-view-html")
@WebServlet(name="add-view-html", urlPatterns="/add-view-html") // URL is mandatory
public class AddViewHTML extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String HTML_CONTENT_TYPE = "text/html";

	//--- Http GET method 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		process(request, response);
	}

	//--- Http POST method 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Double result = (Double) request.getAttribute(Const.RESULT);
		
		if ( result != null ) {
			printView(response, result);
		}
		else {
			throw new IllegalStateException("No result attribute");
		}
	}
	
    private void printView(HttpServletResponse response, double result ) 
    		throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    response.setContentType(HTML_CONTENT_TYPE);
    	out.println("<body>");
	    out.println("<h2>result  : " + result + " </h2>");
	    out.println("</body>");    	    
    }
    
}
