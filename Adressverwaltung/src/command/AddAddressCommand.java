package command;

import model.spring.AbstractAddress;
import model.spring.AddressList;

public class AddAddressCommand implements Command {
	private AbstractAddress address;
	
	public AddAddressCommand(AbstractAddress address) {
		this.address = address;
	}

	@Override
	public void execute() {
		AddressList.getInstance().add(address);
	}

	@Override
	public void undo() {
		AddressList.getInstance().remove(address);
	}

}
