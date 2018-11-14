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
public class Cadre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
        System.out.println("init : Servlet Cadre ");
    }

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        process(request, response);
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
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
    
    private void includeResource(String uri, HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException {
        if ( uri != null) {
            //--- Passage d'objet par la requête
            request.setAttribute("param", uri); // Stockage de l'objet en tant qu'attribut de requête

            //--- Inclusion du contenu 
            RequestDispatcher rd = request.getRequestDispatcher(uri);
            if (rd != null) {
                System.out.println("Avant INCLUDE " + uri );
                rd.include(request, response);
                System.out.println("Après INCLUDE");
            }
            else {
                throw new RuntimeException("Cannot get RequestDispatcher");
            }
        }
        else {
            throw new IllegalArgumentException("Invalid URI");
        }
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ressourceAInclure = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //--- Entête de page
        header ( out );
        
        //--- Récupération du nom ( paramètre de la requête )
        String paramContenu = request.getParameter("contenu");
        if (paramContenu != null) {

            if (paramContenu.equals("1")) {               
                ressourceAInclure = "/Contenu1"; // URL mappée sur la Servlet "Contenu"
            }
            else if (paramContenu.equals("2")) {
                ressourceAInclure = "/Contenu2"; // Autre URL également mappée sur la Servlet "Contenu"
            }
        }

        String part = request.getParameter("part");
        if (part != null) {
            if (part.equals("1")) {
                ressourceAInclure = "/part1"; 
            }
            else if (part.equals("2")) {
                ressourceAInclure = "/part2"; 
            }
        }
//            if (ressourceAInclure != null) {
//                //--- Passage d'objet par la requête
//                request.setAttribute("param", ressourceAInclure); // Stockage de l'objet en tant qu'attribut de requête
//
//                //--- Inclusion du contenu 
//                RequestDispatcher rd = request.getRequestDispatcher(ressourceAInclure);
//                if (rd != null)
//                {
//                    System.out.println("Avant INCLUDE " + ressourceAInclure );
//                    rd.include(request, response);
//                    System.out.println("Après INCLUDE");
//                }
//                else
//                {
//                    out.println("<h2>Erreur : Request Dispatcher = null ! </h2>");
//                }
//            }
//            else
//            {
//                out.println("<h2>Erreur : Numéro de page incorrect ! </h2>");
//            }
        
        if ( ressourceAInclure != null ) {
        	// Stockage des objets à transmettre (dans attribut de requête)
        	request.setAttribute("param", ressourceAInclure); 
        	includeResource(ressourceAInclure, request, response);
        }
        
        //--- Pied de page
        footer ( out );
    }
}