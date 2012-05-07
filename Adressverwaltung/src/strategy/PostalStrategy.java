package strategy;

import model.spring.AbstractAddress;
import model.spring.PostalAddress;

public class PostalStrategy implements Strategy {

	@Override
	public void send(AbstractAddress address) {
		if(address instanceof PostalAddress){
			System.out.println("Post to: " + address.toString());
		}
		else{
			System.out.println("Email to: " + address.toString());
		}
	}

}
