
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

        //--- R�cup�ration du nom ( param�tre de la requ�te )
        String paramPage = request.getParameter("page");
        if (paramPage == null)
        {
            printMessage(response, "<h2>Erreur d'utilisation : indiquer le num�ro de page ! </h2>"); 
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
            	//  Aucune �criture dans le flux de r�ponse, 
            	//  La g�n�ration de la r�ponse est totalement d�l�gu�e � la ressource "destination"
                RequestDispatcher rd = request.getRequestDispatcher(destination);
                if (rd != null)
                {
                    System.out.println("Avant le FORWARD");
                    rd.forward(request, response); // On fait suivre � une autre ressource
                    System.out.println("Apr�s le FORWARD");
                }
                else
                {
                    printMessage(response,"<h2>Erreur : Request Dispatcher = null ! </h2>");
                }
            }
            else
            {
                printMessage(response,"<h2>Num�ro de page incorrect ! </h2>");
            }
        }
    }
}