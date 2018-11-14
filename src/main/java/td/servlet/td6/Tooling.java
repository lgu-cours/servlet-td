package td.servlet.td6;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tooling {
	
	public final static void forward(String destination, 
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
	    RequestDispatcher rd = request.getRequestDispatcher(destination);
	    if (rd != null) {
	        rd.forward(request, response); 
	    }
	    else {
	    	throw new IllegalStateException("Cannot get RequestDispatcher");
	    }
	}

}
