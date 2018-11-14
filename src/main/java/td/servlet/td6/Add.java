
package td.servlet.td6 ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD - Add Controller
 *  
 * @author Laurent GUERIN 
 * 
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        String paramA = request.getParameter("a");
        String paramB = request.getParameter("b");
        if ( paramB == null || paramA == null ) {
        	throw new IllegalArgumentException("a and b expected");
        }
        
        // Compute...
        int r = 0 ;
        try {
        	int a = Integer.parseInt(paramA);
        	int b = Integer.parseInt(paramB);
        	r = a + b ;
        }
        catch ( NumberFormatException e) {
        	throw new IllegalArgumentException("invalid arg (not integer)");
        }
        
        // Store result in request scope
        Integer result = new Integer(r);
        request.setAttribute("result", result);
        
        // Forward to view
        Tooling.forward("/addview", request, response);
    }

}