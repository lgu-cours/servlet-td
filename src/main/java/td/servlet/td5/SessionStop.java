package td.servlet.td5 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * TD SESSION - Fin de la session 
 *  
 * @author Laurent GUERIN 
 * 
 */
public class SessionStop extends HttpServlet {

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
        out.println("<title>SessionStop</title>");
        out.println("</head>");
        out.println("<body>");

        //--- Récupération de la session
        HttpSession session = request.getSession(false);
        if (session == null) {
            out.println("<h2>Aucune session active ! </h2>");
        }
        else {
            session.invalidate();
            out.println("<h2>Session invalidée. </h2>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}