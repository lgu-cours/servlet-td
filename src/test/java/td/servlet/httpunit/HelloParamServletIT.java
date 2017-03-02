package td.servlet.httpunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

/**
 * Maven will NOT run this test because is not in the convention <br>
 * - Test* <br>
 * - *Test <br>
 * - *TestCase <br>
 */
public class HelloParamServletIT extends GenericHttpIT {

	@Test
    public void testFR() throws Exception {
        WebConversation     conversation = new WebConversation();
        String url = buildURL("HelloParam?nom=toto");
        System.out.println("TEST : URL = " + url );
        WebRequest  request = new GetMethodWebRequest( url );
        WebResponse response = conversation.getResponse( request );

        System.out.println( "Http code = " + response.getResponseCode() ); 
        assertEquals(200, response.getResponseCode() );

        //--- Content type
        System.out.println("ContentType = " + response.getContentType());
        assertEquals("text/html", response.getContentType() );

        //--- Headers
        for ( String hn : response.getHeaderFieldNames() ) {
        	System.out.println(" . " + hn + " = " + response.getHeaderField(hn));
        }
        
        //--- Content as text 
        String text = response.getText();        
        System.out.println(text);
        assertTrue(text.contains("<h1>Bonjour toto"));
    } 

	@Test
    public void testEN() throws Exception {
        WebConversation     conversation = new WebConversation();
        String url = buildURL("HelloParam?nom=toto&lang=EN");
        System.out.println("TEST : URL = " + url );
        WebRequest  request = new GetMethodWebRequest( url );
        WebResponse response = conversation.getResponse( request );

        System.out.println( "Http code = " + response.getResponseCode() ); 
        assertEquals(200, response.getResponseCode() );

        //--- Content type
        System.out.println("ContentType = " + response.getContentType());
        assertEquals("text/html", response.getContentType() );

        //--- Content as text 
        String text = response.getText();        
        System.out.println(text);
        assertTrue(text.contains("<h1>Hello toto"));
        
    } 
}
