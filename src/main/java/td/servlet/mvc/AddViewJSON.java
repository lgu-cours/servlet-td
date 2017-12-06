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
@WebServlet(name="add-view-json", urlPatterns="/add-view-json")
public class AddViewJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private static final String TEXT_CONTENT_TYPE = "text/plain";
//	private static final String XML_CONTENT_TYPE  = "text/xml";
//	private static final String HTML_CONTENT_TYPE = "text/html";
	private static final String JSON_CONTENT_TYPE = "application/json";	 // Official : IETF RFC-4627  

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
			printJSON(response, result);
		}
		else {
			throw new IllegalStateException("No result attribute");
		}
	}
	
    private void printJSON(HttpServletResponse response, double result ) 
    		throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    response.setContentType(JSON_CONTENT_TYPE);
    	out.println("{");
	    out.println("\"result\" : \"" + result + "\"  ");
	    out.println("}");    	    
    }
    
}
