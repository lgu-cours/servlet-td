
package td.servlet.td6 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD 6 - Forward vers une ressource du serveur 
 *  
 * @author Laurent GUERIN 
 * 
 */
@WebServlet("/route/*")
public class Route extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
        System.out.println("init : Servlet ForwardToPage ");
    }
    
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

    private void printMessage( HttpServletResponse response, String sMsg ) 
    		throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println(" <head>");
        out.println("  <title>Message</title>");
        out.println(" </head>");
        out.println(" <body>");

        out.println(sMsg);    

        out.println(" </body>");
        out.println("</html>");
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

        String pathInfo = request.getPathInfo() ; 
        System.out.println("pathInfo = " + pathInfo);
        if (pathInfo == null) {
            printMessage(response, "<h2>Erreur : indiquer le path identifiant la ressource </h2>"); 
        }
        else {
        	if ( pathInfo.startsWith("/page/") ) {
        		routeToPage(request, response);
        	}
        	else if ( pathInfo.startsWith("/servlet/") ) {
        		routeToservlet(request, response);
        	}
        	else {
        		printMessage(response,"<h2>Type de route incorrect ! </h2>");
        	}
        }
    }
    
    private void routeToPage(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String pathInfo = request.getPathInfo() ; 
        if ( pathInfo.endsWith("/1") ) {
        	Tooling.forward("/page1.html", request, response);
        }
        if ( pathInfo.endsWith("/2") ) {
        	Tooling.forward("/page2.html", request, response);
        }
        else {
    		printMessage(response,"<h2>No page incorrect ! </h2>");
        }
    }

    private void routeToservlet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String pathInfo = request.getPathInfo() ; 
        if ( pathInfo.endsWith("/hello") ) {
        	Tooling.forward("/Hello", request, response);
        }
        else {
    		printMessage(response,"<h2>No page incorrect ! </h2>");
        }
    }

}