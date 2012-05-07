package strategy;

import model.AbstractAddress;
import model.PostalAddress;

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
