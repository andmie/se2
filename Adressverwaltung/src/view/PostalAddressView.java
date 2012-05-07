package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.IPostalAddress;

public class PostalAddressView extends AbstractAddressView{

	private static final long serialVersionUID = 6218175708585088153L;
	
	private JTextField nameTextField;
	private JTextField strasseTextField;
	private JTextField hausnummerTextField;
	private JTextField plzTextField;
	private JTextField ortTextField;
	private JTextField emailaddressTextField;
	

	public PostalAddressView(IPostalAddress address) {
		super(address);
		System.out.println("Postal: "+this.address);
		initabstract();
		populateFields();
	}

	@Override
	public void retrieveFields() {
		((IPostalAddress) address).setName(nameTextField.getText());
		((IPostalAddress) address).setEmailaddress(emailaddressTextField.getText());
		((IPostalAddress) address).setStrasse(strasseTextField.getText());
		((IPostalAddress) address).setHausnummer(hausnummerTextField.getText());
		((IPostalAddress) address).setPlz(plzTextField.getText());
		((IPostalAddress) address).setOrt(ortTextField.getText());
	}

	@Override
	public void populateFields() {
		nameTextField.setText(address.getName());
		emailaddressTextField.setText(address.getEmailaddress());
		strasseTextField.setText(((IPostalAddress) address).getStrasse());
		hausnummerTextField.setText(""+((IPostalAddress) address).getHausnummer());
		plzTextField.setText(""+((IPostalAddress) address).getPlz());
		ortTextField.setText(((IPostalAddress) address).getOrt());
	}

	@Override
	public JPanel createPanel() {
		JPanel upperPanel = new JPanel();
		upperPanel.setBorder(BorderFactory.createTitledBorder("Addressinformationen"));
		upperPanel.setLayout(new GridLayout(6, 2, 5, 5));
		
		JLabel nameLabel = new JLabel("Name");
		nameTextField = new JTextField();
		
		JLabel emailaddressLabel = new JLabel("Emailadresse");
		emailaddressTextField = new JTextField();
		
		JLabel strasseLabel = new JLabel("Strasse");
		strasseTextField = new JTextField();
		
		JLabel hausnummerLabel = new JLabel("Hausnummer");
		hausnummerTextField = new JTextField();
		
		JLabel plzLabel = new JLabel("PLZ");
		plzTextField = new JTextField();
		
		JLabel ortLabel = new JLabel("Ort");
		ortTextField = new JTextField();
		
		upperPanel.add (nameLabel);
		upperPanel.add (nameTextField);
		upperPanel.add(emailaddressLabel);
		upperPanel.add(emailaddressTextField);
		upperPanel.add (strasseLabel);
		upperPanel.add (strasseTextField);
		upperPanel.add (hausnummerLabel);
		upperPanel.add (hausnummerTextField);
		upperPanel.add (plzLabel);
		upperPanel.add (plzTextField);
		upperPanel.add (ortLabel);
		upperPanel.add (ortTextField);
		
		return upperPanel;
	}

}
