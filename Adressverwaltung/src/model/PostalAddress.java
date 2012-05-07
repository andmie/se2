package model;

public class PostalAddress extends AbstractAddress{

	private static final long serialVersionUID = 2859543943396233532L;
	
	private String strasse, hausnummer, plz, ort;

	public PostalAddress(){
		init();
	}
	
	private void init() {
		this.setName("");
		this.setEmailaddress("");
		this.setHausnummer("");
		this.setOrt("");
		this.setPlz("");
		this.setStrasse("");
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.getEmailaddress() + " " + this.getStrasse() + " " + this.getHausnummer() + " "+ this.getPlz() + " " + this.getOrt(); 
	}
	

}
