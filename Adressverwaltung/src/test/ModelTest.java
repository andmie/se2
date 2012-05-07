package test;

import view.decorator.DirtyDecorator;
import model.spring.EmailonlyAddress;
import junit.framework.TestCase;

public class ModelTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testWithDecorator() {
        EmailonlyAddress address = new EmailonlyAddress();
        address.setName("Test");
        address.setEmailaddress("test@test.de");
        address.setDirty(true);
        DirtyDecorator decorator = new DirtyDecorator(address);
        assertTrue(decorator.toString().compareTo(">Test test@test.de") == 0); 
        address.setDirty(false);
        assertTrue(decorator.toString().compareTo("Test test@test.de") == 0);
	}
	public void testWithoutDecorator() {
		EmailonlyAddress address = new EmailonlyAddress();
        address.setName("Test");
        address.setEmailaddress("test@test.de");
        address.setDirty(true);
        assertTrue(address.toString().compareTo("Test test@test.de") == 0); 
        address.setDirty(false);
        assertTrue(address.toString().compareTo("Test test@test.de") == 0);
	}	
}
