package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.spring.AbstractAddress;

public class EmailonlyAddressView extends AbstractAddressView {

	private static final long serialVersionUID = -4882384242295026045L;

	private JTextField nameTextField;
	private JTextField emailaddressTextField;
	
	public EmailonlyAddressView(AbstractAddress address) {
		super(address);
		initabstract();
		populateFields();
	}
	
	@Override
	public void retrieveFields() {
		address.setName(nameTextField.getText());
		address.setEmailaddress(emailaddressTextField.getText());
	}
	
	@Override
	public void populateFields() {
		nameTextField.setText(address.getName());
		emailaddressTextField.setText(address.getEmailaddress());
	}

	@Override
	public JPanel createPanel() {
		JPanel upperPanel = new JPanel();
		upperPanel.setBorder(BorderFactory.createTitledBorder("Addressinformationen"));
		upperPanel.setLayout(new GridLayout(2,2,5,5));
		
		JLabel nameLabel = new JLabel("Name");
		nameTextField = new JTextField();
		
		JLabel emailaddressLabel = new JLabel("Emailadresse");
		emailaddressTextField = new JTextField();
		
		upperPanel.add (nameLabel);
		upperPanel.add (nameTextField);
		upperPanel.add (emailaddressLabel);
		upperPanel.add (emailaddressTextField);
		
		return upperPanel;
	}

}
