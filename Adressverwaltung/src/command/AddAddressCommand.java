package command;

import model.BeanFactory;
import model.IAbstractAddress;

public class AddAddressCommand implements Command {
	private IAbstractAddress address;
	
	public AddAddressCommand(IAbstractAddress address) {
		this.address = address;
	}

	@Override
	public void execute() {
		BeanFactory.getAddressListBean().add(address);
		System.out.println(BeanFactory.getAddressListBean());
	}

	@Override
	public void undo() {
		BeanFactory.getAddressListBean().remove(address);
	}

}
