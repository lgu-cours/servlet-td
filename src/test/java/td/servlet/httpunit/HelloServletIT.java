package td.servlet.httpunit;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

import static org.junit.Assert.*;

/**
 * Maven will NOT run this test because is not in the convention <br>
 * - Test* <br>
 * - *Test <br>
 * - *TestCase <br>
 */
public class HelloServletIT extends GenericHttpIT {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
    public void test1() throws Exception {
        WebConversation     conversation = new WebConversation();
        String url = buildURL("Hello");
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
        
        //--- Content as XML DOM
        Document dom = response.getDOM();
        NodeList headElements = dom.getElementsByTagName("head");
        System.out.println(headElements.getLength() ) ;
        assertEquals(1, headElements.getLength() );
        
//        WebForm loginForm = response.getForms()[0];
//        request = loginForm.getRequest();
//        request.setParameter( "name", "master" );
//        response = conversation.getResponse( request );
//        assertTrue( "Login not accepted", 
//                   response.getText().indexOf( "You made it!" ) != -1 );
//        assertEquals( "Page title", "Top Secret", response.getTitle() );
    } 
}
