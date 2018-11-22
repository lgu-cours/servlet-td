package td.servlet.mvc ;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Add "VIEW" with JSON result
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
		
		// Try to get the "MODEL" 
		AddModel model = Util.getModel(request, Const.RESULT);
		
		// Print the "VIEW" using the "MODEL"
		printView(response, model);
	}
	
    private void printView(HttpServletResponse response, AddModel model ) 
    		throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    response.setContentType(JSON_CONTENT_TYPE);
    	out.println("{");
	    out.println("\"result\" : \"" + model.getResult() + "\"  ");
	    out.println("}");    	    
    }
    
}
