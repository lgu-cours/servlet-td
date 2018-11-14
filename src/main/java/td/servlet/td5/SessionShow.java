
package td.servlet.td5 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * TD SESSION - Affichage des attributs de la session 
 *  
 * @author Laurent GUERIN 
 * 
 */
public class SessionShow extends HttpServlet {
	
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>SessionShow</title>");
        out.println("</head>");
        out.println("<body>");
        
        //--- Récupération de la session 
        HttpSession session = request.getSession(false);
        if ( session == null ) {
            out.println("<h2>La session n'existe pas</h2>");
        }
        else {
            out.println("<h2>Session trouvée</h2>");

            //--- Récupération de l'attribut de type "Integer" par son nom  
            Integer entier = (Integer) session.getAttribute("entier");
            if ( entier != null ) {
                out.println("<h4>'entier' = " + entier.intValue() + "</h4>");                
            }
            else {
                out.println("<h4>'entier' non trouvé ! </h4>");                                
            }
            
            //--- Récupération de l'attribut de type "String" par son nom  
            String s = (String) session.getAttribute("chaine");
            if ( s != null ) {
                out.println("<h4>'chaine' = " + s + "</h4>");
            }
            else {
                out.println("<h4>'chaine' non trouvé ! </h4>");                                
            }
        }

        out.println(" </body>");
        out.println("</html>");
   }
}