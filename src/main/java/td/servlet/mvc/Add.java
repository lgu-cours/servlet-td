package td.servlet.mvc ;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * TD 8 - Add with forward to view
 *  
 * @author Laurent GUERIN 
 * 
 */
@WebServlet(urlPatterns="/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		
    	double d1 = paramValue(request, "p1" );
    	double d2 = paramValue(request, "p2" );
    	double result = d1 + d2 ;
    	System.out.println( " result = " + result + " ( " + d1 + " + " + d2 + " ) ");
    	
    	request.setAttribute(Const.RESULT, result);
    	System.out.println( " forward... " );
    	
    	String type = request.getParameter("type") ;
    	if ( type != null && "JSON".equalsIgnoreCase(type) ) {
    		Util.forwardByURI("/add-view-json", request, response);    		
    		//forwardByName("add-view-json", request, response);    		
    	}
    	else {
    		//forwardByURI("/add-view-html", request, response);    		
    		Util.forwardByName("add-view-html", request, response);    		
    	}
	}
	
    private double paramValue(HttpServletRequest request, String name ) {
    	String value = request.getParameter(name);
    	if ( value == null ) {
    		throw new IllegalArgumentException( "No parameter '" + name + "'" );
    	}
    	double d = 0 ;
    	try {
			d = Double.parseDouble(value);
		} catch (NumberFormatException e) {
    		throw new IllegalArgumentException ( "Parameter " + name + " invalid value " + value );
		}
		return d ;
    }
    
}
