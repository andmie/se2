package model.spring;

import model.IEmailonlyAddress;


public class EmailonlyAddress extends AbstractAddress implements IEmailonlyAddress{

	private static final long serialVersionUID = -9062158637768953074L;

	public EmailonlyAddress () {
		init();
	}

	private void init() {
		this.setName("");
		this.setEmailaddress("");
	}

	@Override
	public String toString() {
		return this.getName() +" "+ this.getEmailaddress();
	}
}
