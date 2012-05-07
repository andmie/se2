package strategy;

import model.IAbstractAddress;
import model.IPostalAddress;

public class PostalStrategy implements Strategy {

	@Override
	public void send(IAbstractAddress address) {
		if(address instanceof IPostalAddress){
			System.out.println("Post to: " + address.toString());
		}
		else{
			System.out.println("Email to: " + address.toString());
		}
	}

}
