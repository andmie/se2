package strategy;

import model.spring.AbstractAddress;
import model.spring.AddressList;

public class Context {
	
	private Strategy strategy;
	 
    // Constructor
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
 
    public void sendtoAddress(AddressList addresslist) {
    	for (AbstractAddress address : addresslist) {
			strategy.send(address);
		}
    }
}
