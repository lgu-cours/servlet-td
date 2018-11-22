package td.servlet.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Utility class 
 * 
 * @author Laurent GUERIN 
 *
 */
public class Util {

    /**
     * Forward to another component identified by URI
     * @param uri
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void forwardByURI(String uri, HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {
    	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(uri); 
    	if ( rd != null ) {
        	rd.forward(request, response);
    	}
    	else {
    		throw new IllegalArgumentException("Cannot get RequestDispatcher for URI  '"+uri+"'" );
    	}
    }
    
    /**
     * Forward to another component identified by NAME
     * @param name
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void forwardByName(String name, HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {
    	RequestDispatcher rd = request.getServletContext().getNamedDispatcher(name);
    	if ( rd != null ) {
        	rd.forward(request, response);
    	}
    	else {
    		throw new IllegalArgumentException("Cannot get RequestDispatcher for name '"+name+"'" );
    	}
    }

    /**
     * Try to found a 'Double' object in the request scope
     * @param request
     * @param attributeName
     * @return
     */
    public static AddModel getModel(HttpServletRequest request, String attributeName) {
    	AddModel model = (AddModel) request.getAttribute(attributeName);
		if ( model != null ) {
			// OK attribute found 
			return model ; 
		}
		else {
			// ERROR : attribute not found in the request scope
			throw new IllegalStateException("Attribute '" + attributeName + "' not found in request");
		}
    }
}
