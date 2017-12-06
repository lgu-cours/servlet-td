package td.servlet.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {

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

}
