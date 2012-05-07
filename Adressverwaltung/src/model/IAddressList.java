package model;

public interface IAddressList extends Iterable<IAbstractAddress>{
	public void subscribe(AddressListSubscriber subscriber);
	public void unsubscribe(AddressListSubscriber subscriber);
	public boolean add(IAbstractAddress address);
	public boolean remove(IAbstractAddress address);
	public void benachrichtigen();
	public void save();
	public void load();
	public int indexOf(IAbstractAddress oldAddress);
	public void set(Object indexOf, IAbstractAddress newAddress);
	public IAbstractAddress getElementAt(int index);
	public IAbstractAddress get(int index);
}
