package model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanFactory {
	static ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
	
	 public static IAbstractAddress getAbstractAddressBean(){
	        return (IAbstractAddress)ctx.getBean("AbstractAddress");
	 }
	 public static IAddressList getAddressListBean(){
	         return (IAddressList)ctx.getBean("AddressList");
	 }
	 
	 public static IEmailonlyAddress getIEmailonlyAddressBean(){
	         return (IEmailonlyAddress)ctx.getBean("EmailonlyAddress");
	 }
	 
	 public static IPostalAddress getPostalAddressBean(){
	         return (IPostalAddress)ctx.getBean("PostalAddress");
	 }
}
