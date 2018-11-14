package td.servlet.td2 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD 2 
 * @author Laurent GUERIN 
 * 
 */
public class HelloConfig extends HttpServlet {
	
	private static final long serialVersionUID = -5476896409036627202L;
	
	/**
	 * Variable d'instance 
	 * Initialisée une seule fois dans la méthode init
	 * puis non modifiée, donc pas de problème d'accès concurrents ( thread safe )
	 */
	private String lang = null ; 
    
	@Override
    public void init() throws ServletException {
        System.out.println("init : Servlet HelloConfig ");
        
        ServletConfig config = getServletConfig();
        if ( config != null ) {
        	// Récupération du paramètre défini dans le fichier "web.xml"
            String sLang = config.getInitParameter("lang");
            if ( sLang != null ) {
                lang = sLang.toUpperCase() ;                
            }
            else {
                lang = "FR" ; // FR par défaut 
            }
        }
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

    private void process(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println(" <head>");
        out.println("  <title>HelloConfig</title>");
        out.println(" </head>");
        out.println(" <body>");
        
        out.println("<h2> Lang = " + lang + "</h2>");

        String hello = "???" ;
        if ( lang != null ) {
            if ( lang.equals("FR")) {
                hello = "Bonjour";
            }
            else if ( lang.equals("EN")) {
                hello = "Hello";
            }
            out.println("<h1>" + hello + "</h1>");
        }
        else {
            out.println("<h1>Erreur : lang = null ! </h1>");
        }

        out.println(" </body>");
        out.println("</html>");
    }
}