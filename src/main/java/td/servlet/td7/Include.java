package td.servlet.td7 ;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Include extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

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
	
	private void process( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Include</title>");
        out.println("</head>");
        out.println("<body>");

		out.println("<hr>");
		out.println("<h2>Début de servlet Include.java</h2>");
		out.println("<hr>");
		
		//--- 1er Include
		RequestDispatcher rd1 = request.getRequestDispatcher("/include1.html");
		if ( rd1 != null ) {
			rd1.include(request,response);	
			rd1.include(request,response);	
		}
		
		out.println("<hr>");
		out.println("<h2>Milieu de servlet Include.java</h2>");
		out.println("<hr>");

		//--- 2ème Include
		RequestDispatcher rd2 = request.getRequestDispatcher("/include2.html");
		if ( rd2 != null ) {
			rd2.include(request,response);	
		}

		out.println("<hr>");
		out.println("<h2>Fin de servlet Include.java</h2>");
		out.println("<hr>");
		
        out.println(" </body>");
        out.println("</html>");
	}
}
