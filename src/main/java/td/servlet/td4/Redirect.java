package td.servlet.td4 ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD 4
 *  
 * @author Laurent GUERIN 
 * 
 */
public class Redirect extends HttpServlet {

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
    	String contextPath = request.getContextPath();
    	System.out.println("contextPath = " + contextPath );
        //--- Récupération du nom ( paramètre de la requête )
        String sPage = request.getParameter("page");
        if (sPage == null) {
            //response.sendError(404); //--- Code HTTP 404 : "Page Not Found" 
            response.sendError(400); //--- Code HTTP 400 : "Bad request" 
        }
        else {
            if (sPage.equals("1")) {
            	//--- Code HTTP 302 renvoyé au navigateur => le navigateur va refaire un GET sur "/webapp-context/page1.html"
                response.sendRedirect(contextPath + "/page1.html");
            }
            else if (sPage.equals("2")) {
            	//--- Code HTTP 302 renvoyé au navigateur => le navigateur va refaire un GET sur "/webapp-context/page2.html"
                response.sendRedirect(contextPath + "/page2.html");
            }
            else if (sPage.startsWith("w") ) {
                response.sendRedirect("https://www.wikipedia.org/");
            }
            else {
                response.sendError(404);
            }
        }
    }
}