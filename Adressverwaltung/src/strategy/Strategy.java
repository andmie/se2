package strategy;

import model.spring.AbstractAddress;

public interface Strategy {
	void send(AbstractAddress address); 
}
