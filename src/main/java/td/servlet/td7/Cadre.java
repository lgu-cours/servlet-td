package td.servlet.td7 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD 7 
 *  
 * @author Laurent GUERIN 
 * 
 */
public class Cadre extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException
    {
        System.out.println("init : Servlet Cadre ");
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

    private void header(PrintWriter out) {
	    ServletConfig config = getServletConfig();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cadre</title>");
        out.println("</head>");
        
        out.println("<body>");
        out.println("<hr/>");
        out.println("Header </br>");
		out.println("ServletName = " + config.getServletName() + "</br>" );
        out.println("Ci-dessous le contenu demandé </br>");
        out.println("<hr/>");
    }

    private void footer(PrintWriter out) {
        out.println("<hr/>");
        out.println("Footer");
        out.println("<hr/>");
        out.println("</body>");
        out.println("</html>");
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String ressourceAInclure = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //--- Entête de page
        header ( out );
        
        //--- Récupération du nom ( paramètre de la requête )
        String paramPage = request.getParameter("page");
        if (paramPage == null)
        {
            out.println("<h2>Erreur : Pas de numéro de page ! </h2>");
        }
        else
        {

            if (paramPage.equals("1"))
            {               
                ressourceAInclure = "/Contenu1"; // URL mappée sur la Servlet "Contenu"
            }
            else if (paramPage.equals("2"))
            {
                ressourceAInclure = "/Contenu2"; // Autre URL également mappée sur la Servlet "Contenu"
            }

            if (ressourceAInclure != null)
            {
                //--- Passage d'objet par la requête
                request.setAttribute("param", ressourceAInclure); // Stockage de l'objet en tant qu'attribut de requête

                //--- Inclusion du contenu 
                RequestDispatcher rd = request.getRequestDispatcher(ressourceAInclure);
                if (rd != null)
                {
                    System.out.println("Avant INCLUDE " + ressourceAInclure );
                    rd.include(request, response);
                    System.out.println("Après INCLUDE");
                }
                else
                {
                    out.println("<h2>Erreur : Request Dispatcher = null ! </h2>");
                }
            }
            else
            {
                out.println("<h2>Erreur : Numéro de page incorrect ! </h2>");
            }
        }

        //--- Pied de page
        footer ( out );
    }
}