package command;

import model.BeanFactory;
import model.IAbstractAddress;

public class ChangeAddressCommand implements Command {
	
	private IAbstractAddress oldAddress;
	private IAbstractAddress newAddress;

	public ChangeAddressCommand(IAbstractAddress oldAddress,
			IAbstractAddress newAddress) {
		this.oldAddress = oldAddress;
		this.newAddress = newAddress;
	}

	@Override
	public void execute() {
		newAddress.setDirty(true);
		BeanFactory.getAddressListBean().set(BeanFactory.getAddressListBean().indexOf(oldAddress), newAddress);
		BeanFactory.getAddressListBean().benachrichtigen();
	}

	@Override
	public void undo() {
		BeanFactory.getAddressListBean().set(BeanFactory.getAddressListBean().indexOf(newAddress), oldAddress);
		BeanFactory.getAddressListBean().benachrichtigen();
	}
	

}
