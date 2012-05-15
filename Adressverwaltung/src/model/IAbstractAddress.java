package model;

public interface IAbstractAddress {
	
	public boolean isDirty();
	public void setDirty(boolean dirty);
	public void clean();	
	public String getName();
	public void setName(String name);
	public String getEmailaddress();
	public void setEmailaddress(String emailaddress);
	public IAbstractAddress clone();
}
