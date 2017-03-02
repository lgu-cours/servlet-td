
package td.servlet.td6 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD 6 - Forward vers une ressource du serveur 
 *  
 * @author Laurent GUERIN 
 * 
 */
public class Forward extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException
    {
        System.out.println("init : Servlet Forward ");
    }
    
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

    private void printMessage( HttpServletResponse response, String sMsg ) throws IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println(" <head>");
        out.println("  <title>SessionInit</title>");
        out.println(" </head>");
        out.println(" <body>");

        out.println(sMsg);    

        out.println(" </body>");
        out.println("</html>");
        
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String destination = null;

        //--- Récupération du nom ( paramètre de la requête )
        String paramPage = request.getParameter("page");
        if (paramPage == null)
        {
            printMessage(response, "<h2>Erreur d'utilisation : indiquer le numéro de page ! </h2>"); 
        }
        else
        {
        	// Aiguillage vers la ressource de destination 
            if (paramPage.equals("1"))
            {
                destination = "/page1.html"; // Page web statique
            }
            else if (paramPage.equals("2"))
            {
                destination = "/page2.html"; // Page web statique
            }
            else if (paramPage.equals("hello"))
            {
                destination = "/Hello";  // Autre servlet 
            }

            if (destination != null)
            {
            	//  Aucune écriture dans le flux de réponse, 
            	//  La génération de la réponse est totalement déléguée à la ressource "destination"
                RequestDispatcher rd = request.getRequestDispatcher(destination);
                if (rd != null)
                {
                    System.out.println("Avant le FORWARD");
                    rd.forward(request, response); // On fait suivre à une autre ressource
                    System.out.println("Après le FORWARD");
                }
                else
                {
                    printMessage(response,"<h2>Erreur : Request Dispatcher = null ! </h2>");
                }
            }
            else
            {
                printMessage(response,"<h2>Numéro de page incorrect ! </h2>");
            }
        }
    }
}