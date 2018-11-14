package td.servlet.td3 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD 3 
 * @author Laurent GUERIN 
 * 
 */

public class HelloParam extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String lang = null ;
    
	@Override
    public void init() throws ServletException {
        ServletConfig servletConfig = getServletConfig();
        if ( servletConfig != null ) {
            String langConfig = servletConfig.getInitParameter("lang");
            if ( langConfig != null ) {
                lang = langConfig.toUpperCase() ;                
            }
            else {
                lang = "FR" ;
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
        out.println("  <title>HelloParam</title>");
        out.println(" </head>");
        out.println(" <body>");
        
        out.println("<h4> Lang (instance)  = " + lang + "</h4>");

        //--- Récupération du nom ( paramètre de la requête )
        String paramNom = request.getParameter("nom") ;
        if ( paramNom == null ) {
            paramNom = "";
        }

        //--- Récupération de la langue ( paramètre de la requête )
        String paramLang = request.getParameter("lang") ;
        if ( paramLang == null ) {
            paramLang = lang ;
        }
        else {
            paramLang = paramLang.toUpperCase() ;
        }
        out.println("<h4> Nom (param)  = " + paramNom + "</h4>");
        out.println("<h4> Lang (param)  = " + paramLang + "</h4>");
        
        String hello = "???" ;
        if ( paramLang != null ) {
            if ( paramLang.equals("FR")) {
                hello = "Bonjour";
            }
            else if ( paramLang.equals("EN")) {
                hello = "Hello";
            }
        }
        else {
            hello = "Hello / Bonjour ";            
        }
        out.println("<h1>" + hello + " " + paramNom + " ! </h1>");
        
        out.println(" <ul>");
        out.println(" <li> getRequestURL() : " + request.getRequestURL() );
        out.println(" <li> getContextPath() : " + request.getContextPath() );
        out.println(" </ul>");
        out.println(" </body>");
        out.println("</html>");
    }
}