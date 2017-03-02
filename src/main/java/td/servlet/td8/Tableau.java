package td.servlet.td8 ;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * TD 8 - Tableau HTML ou CSV 
 *  
 * @author Laurent GUERIN 
 * 
 */
public class Tableau extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	//--- Http GET method 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException
	{
		process(request, response);
	}

	//--- Http POST method 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException
	{
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	
	{
		String paramType = request.getParameter("type");
		if ( paramType == null ) {
			paramType = "html" ;
		}
		String type = paramType.toUpperCase();
		if ( "HTML".equals(type) ) {
			tableauHTML(request, response);
		}
		else if ( "XML".equals(type) ) {
			tableauXML(request, response);
		}
		else if ( "CSV".equals(type) ) {
			tableauCSV(request, response);
		}
		else {
			response.sendError(501) ; // Code Erreur HTTP 501 = Not Implemented 
		}
	}
	
	/**
	 * Tableau dans un page HTML 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void tableauHTML(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException
	{
		// Type MIME pour un flux HTML 
		response.setContentType("text/html");
		
		// Flux d'écriture pour générer la réponse
		PrintWriter out = response.getWriter();
		
		// Ecriture de la page HTML  
        out.println("<html>");
        out.println(" <head>");
        out.println("  <title>Tableau</title>");
        out.println(" </head>");
        out.println(" <body>");
		
		out.println("<h1>Le tableau : </h1>");

		out.println("<table border='1' >");
		
		//--- N Lignes
		for ( int ligne = 0 ; ligne < 20 ;ligne++ ) {
			out.print("<tr>");
			//--- N Colonnes
			for ( int c = 0 ; c < 10 ; c++ ) {
				out.print("<td>" + ligne + "." + c + "</td>");			
			}
			out.print("</tr>");
		}

		out.println("</table>");
				
        out.println(" </body>");
        out.println("</html>");
		
	}

	/**
	 * Génération d'un tableau en XML
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void tableauXML(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Type MIME pour un flux HTML
		response.setContentType("text/xml");

		// Flux d'écriture pour générer la réponse
		PrintWriter out = response.getWriter();

		// Prologue XML
		out.println("<?xml version=\"1.0\" ?>"); 
		
		// Contenu XML
		out.println("<tableau>");

		// --- N Lignes
		for (int ligne = 0; ligne < 20; ligne++) {
			out.print("<ligne>");
			// --- N Colonnes
			for (int c = 0; c < 10; c++) {
				out.print("<cellule>" + ligne + "." + c + "</cellule>");
			}
			out.print("</ligne>");
		}

		out.println("</tableau>");

	}
	
	/**
	 * Génération d'un tableau CSV pour Excel
	 * @param request
	 * @param response
	 * @param separateur
	 * @throws ServletException
	 * @throws IOException
	 */
	private void tableauCSV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// Type MIME application "Microsoft Excel"  
		response.setContentType("application/vnd.ms-excel"); 
		
		//--- Header HTTP qui indique le nom du fichier (optionnel)
		response.setHeader("Content-disposition", "attachment; filename=TableauCSV.xls" );

		String separateur = "\t" ; // Pour Excel : séparateur = TABULATION 
		
		// Flux d'écriture pour générer la réponse
		PrintWriter out = response.getWriter();
		
		// Ecriture en CSV  
		//--- N Lignes
		for ( int ligne = 0 ; ligne < 20 ;ligne++ ) {
			//--- N Colonnes
			for ( int c = 0 ; c < 10 ; c++ ) {
				if ( c > 0 ) {
					out.print(separateur) ;  // Séparateur de colonnes 
				}
				out.print( ligne + "." + c );	
			}
			out.println("");
		}
	}

}
