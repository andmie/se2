package view.decorator;

import model.spring.AbstractAddress;

public class AbstractDecorator extends AbstractAddress {

	private static final long serialVersionUID = 6257084352616795877L;

	protected AbstractAddress address = null;
    
    public AbstractDecorator(AbstractAddress address){
            this.address = address;
    }
    
    
    @Override
    public String toString() {
            return this.address.toString();
    }

    public AbstractAddress getDecorated() {
            return address;
    }

}
