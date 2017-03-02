package td.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Maven will run this test because of the convention <br>
 * - Test* <br>
 * - *Test <br>
 * - *TestCase <br>
 */
public class MyTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		// OK
		assertTrue(true); 
	}

}
