
package td.servlet.td5 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * TD 5 - Creation et initialisation de la session
 *  
 * @author Laurent GUERIN 
 * 
 */
public class SessionInit extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	//--- Requete GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        process(request, response);
    }

    //--- Requete POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SessionInit</title>");
        out.println("</head>");
        out.println("<body>");

        //--- Récupération de la session
        HttpSession session = request.getSession(); // Récupération de la session ou création si inexistante
        if (session == null)
        {
        	// Ne se produit jamais  
        	// Utile uniquement pour :  request.getSession(false);
            out.println("<h2>ERREUR : impossible d'obtenir une session ! </h2>");
        }
        else
        {
            //--- Mise en session d'un entier
            Integer entier = new Integer(12);
            session.setAttribute("entier", entier); 

            //--- Mise en session d'une chaîne
            String chaine = "message en session";
            session.setAttribute("chaine", chaine);

            out.println("<h2>Session initialisée </h2>");
        }

        out.println(" </body>");
        out.println("</html>");
        
    }
}