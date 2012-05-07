package view.decorator;

import model.spring.AbstractAddress;

public class DirtyDecorator extends AbstractDecorator {

	private static final long serialVersionUID = 5766724679012962296L;

	public DirtyDecorator(AbstractAddress address) {
		super(address);
	}
	
	@Override
    public String toString() {
		if (address.isDirty()){
            return ">"+super.toString();
		}
		return super.toString();
    }

}
