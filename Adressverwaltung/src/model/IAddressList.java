package model;

import model.spring.AbstractAddress;

public interface IAddressList {
	public void subscribe(AddressListSubscriber subscriber);
	public void unsubscribe(AddressListSubscriber subscriber);
	public boolean add(AbstractAddress address);
	public boolean remove(AbstractAddress address);
	public void benachrichtigen();
	public void save();
	public void load();
}
