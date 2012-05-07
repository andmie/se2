package command;

import model.BeanFactory;
import model.IAbstractAddress;

public class RemoveAddressCommand implements Command {
	private IAbstractAddress address;
	
	public RemoveAddressCommand(int index) {
		this.address = BeanFactory.getAddressListBean().get(index);
	}

	@Override
	public void execute() {
		BeanFactory.getAddressListBean().remove(address);
	}

	@Override
	public void undo() {
		BeanFactory.getAddressListBean().add(address);
	}

}
