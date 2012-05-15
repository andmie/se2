package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.BeanFactory;
import model.IAbstractAddress;

import command.AddAddressCommand;
import command.ChangeAddressCommand;
import command.Command;
import command.InvokeHistory;

public abstract class AbstractAddressView extends JFrame{

	private static final long serialVersionUID = 4218303237851924952L;
	
	//Create objects
	protected IAbstractAddress address;
	protected IAbstractAddress oldaddress;
	
	private JPanel upperPanel;
	private JButton speicherButton;
	
	//Constructor
	public AbstractAddressView(IAbstractAddress address) {
		this.address = address.clone();
		this.oldaddress = address;
	}

	protected void initabstract() {
		
		//Layout configuration
		setResizable(false);
		setVisible(true);
		setTitle("Address");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Create Panel (Factory Method Pattern)
		upperPanel = createPanel();
		this.add (upperPanel,BorderLayout.CENTER);

		//Create Button "Hinterlegen"
		speicherButton = new JButton("Hinterlegen");
		speicherButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				retrieveFields();
				// Abfrage ob die Addresse geaendert wird
				// oder ob eine neue Addresse hinzugefuegt
				// werden soll.
				int index = BeanFactory.getAddressListBean().indexOf(oldaddress);
				Command command = null;
				if (index != -1) {
					//Adresse wurde geaendert
					command = new ChangeAddressCommand(oldaddress, address);
					//System.out.println("geändert");
				} else {
					//Eine neue Adresse wurde erstellt
					//System.out.println("hinzufügen von: "+address.toString());
					command = new AddAddressCommand(address);
					//System.out.println(AddressList.getInstance().toString());
				}
				
				if (command != null) {
					//Command ausfuehren und auf den Stapel legen.
					command.execute();
					InvokeHistory.getInstance().push(command);
				}
				
				Container container = (Container) e.getSource();
				while (!((container = container.getParent()) instanceof JFrame));
				((JFrame) container).setVisible(false);
				((JFrame) container).dispose();
			}
		});
		this.add (speicherButton, BorderLayout.SOUTH);
		
		this.pack();
	}

	public abstract void retrieveFields();
	public abstract void populateFields();
	public abstract JPanel createPanel();
}
