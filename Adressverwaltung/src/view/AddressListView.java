package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import command.CommandButtons;
import command.RemoveAddressCommand;

import model.AbstractAddress;
import model.AddressList;
import model.EmailonlyAddress;
import model.PostalAddress;
import strategy.Context;
import strategy.EmailStrategy;
import strategy.PostalStrategy;
import strategy.Strategy;
import view.decorator.AbstractDecorator;
import view.decorator.DirtyDecorator;

public class AddressListView extends JFrame implements model.AddressListSubscriber{

	private static final long serialVersionUID = 9022665654800795291L;
	private DefaultListModel listModel;
	private Context context;
	private Strategy strategy;

	public AddressListView() {
		init();
	}

	@SuppressWarnings("serial")
	private void init () {
		
		//Layout configuration
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Address-List");
		setLayout(new GridBagLayout());
		setResizable(false);

		//Add scrollpane
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0; 
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.weighty = 0.9;
		
		listModel = new DefaultListModel();
//		{
//            @Override
//            public AbstractAddress get(int index) {
//                    Object value = super.get(index);
//                    if (value instanceof AbstractDecorator){
//                            value = ((AbstractDecorator)value).getDecorated();
//                    }
//                    return (AbstractAddress) value;
//            }
//            
//            @Override
//            public AbstractAddress getElementAt(int index) {
//                    Object value = super.getElementAt(index);
//                    if (value instanceof AbstractDecorator){
//                            value = ((AbstractDecorator)value).getDecorated();
//                    }
//                    return (AbstractAddress) value;
//            }
//		};
		final JList list = new JList(listModel);
		JScrollPane scrollpane = new JScrollPane(list);
		scrollpane.setPreferredSize(new Dimension(this.getWidth(), 150));

	    this.add(scrollpane, constraints);
	    
	    //Add Button "Add EmailonlyAddress"
	    JButton addButtonemail = new JButton("Add EmailonlyAddress");
	    addButtonemail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AbstractAddress address = new EmailonlyAddress();
				new EmailonlyAddressView(address);
			}
		});
	    
	    constraints.weighty = 0.1; constraints.gridy = 1;
	    constraints.gridwidth = 1;
	    this.add(addButtonemail,constraints);
	    
	    //Add Button "Add PostalAddress"
	    JButton addButtonpostal = new JButton("Add PostalAddress");
	    addButtonpostal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AbstractAddress address = new PostalAddress();
				new PostalAddressView(address);
			}
		});
	    
	    constraints.weighty = 0.1; 
	    constraints.gridy = 1;
	    constraints.gridx = 1;
	    constraints.gridwidth = 1;
	    this.add(addButtonpostal,constraints);
	    
	    //Add Button "Addresse löschen"
	    JButton Buttondelete = new JButton("Addresse löschen");
	    Buttondelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Create Commandbutton and add Commands
		  		RemoveAddressCommand removeCommand = new RemoveAddressCommand(list.getSelectedIndex());
		  		CommandButtons.getInstance().setCommand(1,removeCommand);
		  		CommandButtons.getInstance().pressButton(1);
			}
		});
	    
	    constraints.weighty = 0.1; 
	    constraints.gridy = 1;
	    constraints.gridx = 2;
	    constraints.gridwidth = 1;
	    this.add(Buttondelete,constraints);
	    
	    //Adresse ändern
	    list.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		if (e.getClickCount() == 2) {
	    			int index = ((JList) e.getSource()).locationToIndex(e.getPoint());
	    	        if (index == -1)
	    	        	System.out.println("Sie haben nichts ausgewählt.");
	    	        else {
	    	        	AbstractAddress address = (AbstractAddress)listModel.getElementAt(index);
	    	        	
	    	        	if (address instanceof AbstractDecorator){
                            address = ((AbstractDecorator)address).getDecorated();
	    	        	}
	    	        	//Create View
	    	        	if (address instanceof model.PostalAddress){
	    	            	new PostalAddressView(address);
	    	            }
	    	            else{
	    	            	new EmailonlyAddressView(address);
	    	            }		  		
	    	        }
	    		}
	    	}
	    });
	    
	    //Add Button "Undo"
	    JButton undoButton = new JButton("Undo");
	    undoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CommandButtons.getInstance().undo();
			}
		});
	    
	    constraints.gridx = 3;
	    constraints.gridy = 1;
	    this.add(undoButton,constraints);
	    
	    //Add Button "Save all"
	    JButton saveButton = new JButton("Save all");
	    
	    saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				AddressList.getInstance().save();
			}
		});
	    
	    constraints.gridx = 2; 
	    constraints.gridy = 3;
	    this.add(saveButton,constraints);
	    
	  //Add Button "Load all"
	    JButton loadButton = new JButton("Load all");
	    
	    loadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddressList.getInstance().load();
				for (Iterator<AbstractAddress> it = AddressList.getInstance().iterator(); it.hasNext(); ){
                    AbstractAddress address = it.next();
                    address.setDirty(false);
				}
			}
		});
	    
	    constraints.gridx = 3; constraints.gridy = 3;
	    this.add(loadButton,constraints);
	    
	    //Add Radiobuttons for Strategy-Pattern
	    constraints.gridx = 0; 
	    constraints.gridy = 3;
	    constraints.gridwidth = 2;
	    JPanel strategyPanel = new JPanel();
	    strategyPanel.setBorder(BorderFactory.createTitledBorder("Strategie"));
	    strategyPanel.setLayout(new BoxLayout(strategyPanel, BoxLayout.X_AXIS));
	    final JRadioButton lowBudgetButton = new JRadioButton("Wenig Geld");
	    strategyPanel.add(lowBudgetButton);
	    final JRadioButton highBudgetButton = new JRadioButton("Viel Geld");
	    strategyPanel.add(highBudgetButton);
	    JButton sendButton = new JButton("Nachricht verschicken");
	    sendButton.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  	if (lowBudgetButton.isSelected()) {
	    		  	strategy = new EmailStrategy();
				} else if (highBudgetButton.isSelected()) {
					strategy = new PostalStrategy();
				} else {
					System.out.println("please select budget");
					return;
				}
	    	  	context = new Context(strategy);
	    	  	context.sendtoAddress(AddressList.getInstance());
	      }
	     });
	    strategyPanel.add(sendButton);

	    // Low- und High-Budget Buttons exclusiv verbinden
	    ButtonGroup group = new ButtonGroup();
	    group.add(lowBudgetButton);
	    group.add(highBudgetButton);
	    
	    this.add(strategyPanel,constraints);
	    this.pack();
	}
	
	private void refreshAddressList() {
		listModel.removeAllElements();
		for (AbstractAddress address : AddressList.getInstance()) {
			listModel.addElement(address.isDirty() ? new DirtyDecorator(address) : address);
		}
	}
	
	public void benachrichtige(){
		refreshAddressList();
	}
	
}
