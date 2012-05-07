package view.decorator;

import java.io.Serializable;

import model.IAbstractAddress;

public abstract class AbstractDecorator implements IAbstractAddress, Serializable {
	
	private static final long serialVersionUID = -8608786096022101506L;

	private transient boolean dirty = true;
	
	protected IAbstractAddress address = null;
    
    public AbstractDecorator(IAbstractAddress address){
            this.address = address;
    }
    
    @Override
    public String toString() {
            return this.address.toString();
    }

    public IAbstractAddress getDecorated() {
            return address;
    }
    
	@Override
	public boolean isDirty() {
		return dirty;
	}
	@Override
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
		
	}
	@Override
	public void clean() {
		dirty = false;
		
	}
	@Override
	public String getName() {
		return null;
	}
	@Override
	public void setName(String name) {
		
	}
	@Override
	public String getEmailaddress() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmailaddress(String emailaddress) {
		// TODO Auto-generated method stub
		
	}
	
	public IAbstractAddress clone() {
		try {
			return (IAbstractAddress)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

}
