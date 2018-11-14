package td.servlet.td4 ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD SEND ERROR 
 * HTTP 418 : I'm a teapot 
 * 
 * @author Laurent GUERIN 
 * 
 */
@WebServlet( urlPatterns={"/cafe", "/coffee"} )
public class Cafe extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	//--- Requete GET
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        process(request, response);
    }

    //--- Requete POST
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	// Just for fun !
        response.sendError(418); //--- Code HTTP 418 : "I'm a teapot" 
    }
}