package view.decorator;

import model.IAbstractAddress;

public class DirtyDecorator extends AbstractDecorator {
	
	private static final long serialVersionUID = -1750981549596157062L;
	IAbstractAddress address;

	public DirtyDecorator(IAbstractAddress address) {
		super(address);
		this.address = address;
	}
	
	@Override
    public String toString() {
		if (address.isDirty()){
            return ">"+super.toString();
		}
		return super.toString();
    }

}