package td.servlet.mvc ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Add "VIEW" with HTML result
 *  
 * @author Laurent GUERIN 
 * 
 */
@WebServlet(name="add-view-html", urlPatterns="/add-view-html") // URL is mandatory
public class AddViewHTML extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String HTML_CONTENT_TYPE = "text/html";

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
	    response.setContentType(HTML_CONTENT_TYPE);
    	out.println("<body>");
	    out.println("<h2>message  : " + model.getMessage() + " </h2>");
	    out.println("<h2>result  : " + model.getResult() + " </h2>");
	    out.println("</body>");    	    
    }
    
}
