package td.servlet.mvc;

/**
 * Add "SERVICE" : simulate a service with input and result
 * 
 * @author Laurent GUERIN
 *
 */
public class AddService {

	public AddService() {
	}

	public AddModel add(double p1, double p2) {
		
		// Do the super computation
    	double result = p1 + p2 ;
    	String message = "OK everything works fine, input parameters : " + p1 + " and " + p2 ;
    	
    	// Build and return the model 
		return new AddModel(p1, p2, result, message);
	}

}
