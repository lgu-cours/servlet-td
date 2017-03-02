package td.servlet.httpunit;

public abstract class GenericHttpIT {

	private final static String HOST = "localhost" ;
	private final static String PORT = "8080" ;
	private final static String WEBAPP = "servlet-td" ;
	
	protected String buildURL(String uri ) {
		return "http://" + HOST + ":" + PORT + "/" + WEBAPP + "/" + uri ;
	}
}
