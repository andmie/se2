package model;

public interface IPostalAddress {
	public String getStrasse();
	public void setStrasse(String strasse);
	public String getHausnummer();
	public void setHausnummer(String hausnummer);
	public String getPlz();
	public void setPlz(String plz);
	public String getOrt();
	public void setOrt(String ort);
	public String toString();
}
