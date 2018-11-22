
package td.servlet.td6 ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TD - Add View
 *  
 * @author Laurent GUERIN 
 * 
 */
@WebServlet("/addview")
public class AddView extends HttpServlet {
	
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

    private void process(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add result (view)</title>");
        out.println("</head>");
        out.println("<body>");

        //--- Récupération du resultat 
        Integer result = (Integer) request.getAttribute("result");
        if ( result != null ) {
        	out.println("<h2>Result = " + result + "</h2>");
        }
        else {
        	out.println("<h2>No result :-( </h2>");
        }

        out.println("</body>");
        out.println("</html>");
    }

}