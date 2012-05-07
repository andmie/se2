package model.spring;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import model.AddressListSubscriber;
import model.BeanFactory;
import model.IAbstractAddress;
import model.IAddressList;

public class AddressList extends LinkedList<IAbstractAddress> implements IAddressList, Serializable{
	private static String filename = "address_system.dat";
	private static final long serialVersionUID = -8436170099085318899L;
	private volatile static AddressList instance = null;
	
	private LinkedList<AddressListSubscriber> subscribers = new LinkedList<AddressListSubscriber>();
	
	private AddressList(){
		super();
	}
	
	public static AddressList getInstance() {
        if (instance == null) {
        	synchronized(AddressList.class){
        		if (instance == null) {
        			instance = new AddressList();
        		}
        	}
        }
        return instance;
    }
	
	public void subscribe(AddressListSubscriber subscriber) {
        subscribers.add(subscriber);
	}
	public void unsubscribe(AddressListSubscriber subscriber) {
		subscribers.remove(subscriber);
	}
	public boolean add(IAbstractAddress address)
	{	
	        super.add(address);
	        this.benachrichtigen();
	        return true;
	}
	public boolean remove(IAbstractAddress address)
	{
		super.remove(address);
		this.benachrichtigen();
		return true;
	}
	public void benachrichtigen()
	{
	        for(AddressListSubscriber subscriber : subscribers){
	        	subscriber.benachrichtige();
	        }
	}
	
	public void save() {
		try {
			final FileOutputStream fos = new FileOutputStream(filename);
			final ObjectOutputStream out = new ObjectOutputStream(fos);
			System.out.println(BeanFactory.getAddressListBean().getElementAt(0).getClass());
			out.writeObject((AddressList)BeanFactory.getAddressListBean());
			out.close();

			for (final IAbstractAddress address : BeanFactory.getAddressListBean()){
				address.clean();
			}
			BeanFactory.getAddressListBean().benachrichtigen();
		} catch (final IOException ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void load() {
		@SuppressWarnings("unused")
		AddressList addressList = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
		    fis = new FileInputStream(filename);
		    in = new ObjectInputStream(fis);
		    List<AbstractAddress> addresses = (List<AbstractAddress>) in.readObject();
		    
		    AddressList.getInstance().clear();
		    AddressList.getInstance().addAll(addresses);

		    benachrichtigen();
		 }
		catch(IOException ex){
		   ex.printStackTrace();
		}
		catch(ClassNotFoundException ex){
		   ex.printStackTrace();
		}
		
	}

	@Override
	public int indexOf(IAbstractAddress oldAddress) {
		return super.indexOf(oldAddress);
	}

	@Override
	public void set(Object indexOf, IAbstractAddress newAddress) {
		super.set((Integer) indexOf, newAddress);
		
	}

	@Override
	public IAbstractAddress getElementAt(int index) {
		return super.get(index);
	}
}
