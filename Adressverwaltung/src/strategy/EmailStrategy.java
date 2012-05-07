package strategy;

import model.spring.AbstractAddress;

public class EmailStrategy implements Strategy {

	@Override
	public void send(AbstractAddress address) {
		System.out.println("Email to: " + address.toString());
	}

}
