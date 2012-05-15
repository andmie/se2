package test;

import view.decorator.DirtyDecorator;
import model.spring.EmailonlyAddress;
import junit.framework.TestCase;

public class ModelTest extends TestCase {
        private EmailonlyAddress address;

        protected void setUp() throws Exception {
            super.setUp();
            address = new EmailonlyAddress();
            address.setName("Test");
            address.setEmailaddress("test@test.de");
            address.setDirty(true);
        }
        
        public void testWithDecorator() {
            DirtyDecorator decorator = new DirtyDecorator(address);
            assertTrue("dirty with decorator", decorator.toString().equals(">Test test@test.de")); 
            //alternativ mit assertEquals:
            // assertEquals("dirty with decorator", ">Test test@test.de", decorator.toString());
            address.setDirty(false);
            assertTrue("not dirty with decorator", decorator.toString().equals("Test test@test.de"));
        }
        public void testWithoutDecorator() {
            assertTrue("dirty without decorator", address.toString().equals("Test test@test.de")); 
            address.setDirty(false);
            assertTrue("not dirty wihtout decorator", address.toString().equals("Test test@test.de"));
        } 
        
        protected void tearDown() throws Exception {
            super.tearDown();
            address = null;
        }
}