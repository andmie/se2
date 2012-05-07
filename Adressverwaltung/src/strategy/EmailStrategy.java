package strategy;

import model.IAbstractAddress;

public class EmailStrategy implements Strategy {

	@Override
	public void send(IAbstractAddress address) {
		System.out.println("Email to: " + address.toString());
	}

}
