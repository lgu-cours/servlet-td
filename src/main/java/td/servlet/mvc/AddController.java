package td.servlet.mvc ;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Add "CONTROLLER" : compute then forward to view
 *  
 * @author Laurent GUERIN 
 * 
 */
@WebServlet(urlPatterns="/add")
public class AddController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//--- Http GET method 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		process(request, response);
	}

	//--- Http POST method 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Step 1 : Get input parameters
    	double p1 = getParamValue(request, "p1" );
    	double p2 = getParamValue(request, "p2" );
    	System.out.println( " input parameters : " + p1 + " + " + p2 );
    	
    	// Step 2 : Call the service 
    	AddService service = new AddService();
    	AddModel model = service.add(p1, p2);
    	System.out.println( " result = " + model.getResult() );
    	
    	// Step 3 : Store the result "MODEL" in the REQUEST scope
    	request.setAttribute(Const.RESULT, model);
    	System.out.println( " forward... " );
    	
    	// Step 4 : Forward to the "VIEW"
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
	
    private double getParamValue(HttpServletRequest request, String name ) {
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
