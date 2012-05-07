package command;

import model.AbstractAddress;
import model.AddressList;

public class RemoveAddressCommand implements Command {
	private AbstractAddress address;
	private int index;
	
	public RemoveAddressCommand(int index) {
		this.address = AddressList.getInstance().get(index);
		this.index = index;
	}

	@Override
	public void execute() {
		AddressList.getInstance().remove(address);
	}

	@Override
	public void undo() {
		AddressList.getInstance().add(address);
	}

}
