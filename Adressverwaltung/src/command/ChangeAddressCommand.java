package command;

import model.spring.AbstractAddress;
import model.spring.AddressList;

public class ChangeAddressCommand implements Command {
	
	private AbstractAddress oldAddress;
	private AbstractAddress newAddress;

	public ChangeAddressCommand(AbstractAddress oldAddress,
			AbstractAddress newAddress) {
		this.oldAddress = oldAddress;
		this.newAddress = newAddress;
	}

	@Override
	public void execute() {
		AddressList addressList = AddressList.getInstance();
		newAddress.setDirty(true);
		addressList.set(addressList.indexOf(oldAddress), newAddress);
		addressList.benachrichtigen();
	}

	@Override
	public void undo() {
		AddressList addressList = AddressList.getInstance();
		addressList.set(addressList.indexOf(newAddress), oldAddress);
		addressList.benachrichtigen();
	}
	

}
