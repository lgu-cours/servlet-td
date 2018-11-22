package td.servlet.mvc;

/**
 * Add "MODEL" 
 * 
 * @author Laurent GUERIN 
 *
 */
public class AddModel {

	private final double p1 ;
	private final double p2 ;
	private final double result ;
	private final String message ;
	
	public AddModel(double p1, double p2, double result, String message) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.result = result;
		this.message = message;
	}

	public double getP1() {
		return p1;
	}

	public double getP2() {
		return p2;
	}

	public double getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}
}
