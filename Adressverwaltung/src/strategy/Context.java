package strategy;

import model.IAbstractAddress;
import model.IAddressList;

public class Context {
	
	private Strategy strategy;
	 
    // Constructor
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
 
    public void sendtoAddress(IAddressList addresslist) {
    	for (IAbstractAddress address : addresslist) {
			strategy.send(address);
		}
    }
}
