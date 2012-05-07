package model.spring;
import java.io.Serializable;

import model.IAbstractAddress;

public class AbstractAddress implements IAbstractAddress, Serializable, Cloneable{
	
	private static final long serialVersionUID = 6780532528672421304L;
	private transient boolean dirty = true;
	
	private String name;
	private String emailaddress;
	
	public boolean isDirty() {
        return dirty;
	}
	
	public void setDirty(boolean dirty) {
	        this.dirty = dirty;
	}
	
	public void clean() {
		dirty = false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	
	public AbstractAddress clone() {
		try {
			return (AbstractAddress)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
	
}
