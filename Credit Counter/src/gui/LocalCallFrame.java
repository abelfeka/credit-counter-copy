package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LocalCallFrame extends JFrame {
	final private Border border = new LineBorder(Color.BLACK);
	final private Font normalFont = new Font("Candara",Font.PLAIN,20);
	final private int buttonHeight = 40;
	final private long policeNumber = 910128547L;
	final private long hospitalNumber = 911445588L;
	final private long homeNumber  = 911447893L;

	private JFrame callFrame;
	private JButton creditButton,callButton,endButton,addContact;
	private JPanel thisPanel,callPanel;
	private JTextField numberField,codeField;
	private JComboBox<String> dropdown;
	private HashMap<String,Long>contacts;
	private Vector<String> names;
	
	public LocalCallFrame() {this("");}

	public LocalCallFrame(String title) {
		super(title);
		setVisible(true);
		setSize(600,600);
		setLocation(0,300);
		int left = getInsets().left;
		int right = getSize().width-getInsets().right;
		int top = getInsets().top;
		int bottom = getSize().height-100;//getInsets().bottom;
		int maxWidth = getSize().width-getInsets().right-getInsets().left;
		int maxHeight = getSize().height-getInsets().top-getInsets().bottom;
	
		creditButton = new JButton("Credit Available");
		callButton = new JButton("CALL");
		endButton = new JButton("END");
		addContact = new JButton("Add Contact");
		thisPanel = new JPanel(null);
		codeField = new JTextField("+251");
		numberField = new JTextField();
		contacts = new HashMap<String, Long>();
		names = new Vector<String>();names.add("Contacts");
		//Sample Contacts
		names.add("Home");names.add("Police");names.add("Hospital");
		contacts.put("Hospital", hospitalNumber);
		contacts.put("Police", policeNumber);
		contacts.put("Home", homeNumber);
		dropdown = new JComboBox<String>(names);
	
		addContact.addActionListener(new AddContactListener(this));
		dropdown.addItemListener(new DropdownListener());
		callButton.addActionListener(new CallListener(this));
		
		creditButton.setFont(normalFont);creditButton.setBorder(border);
		callButton.setFont(normalFont);callButton.setBackground(Color.GREEN);
		endButton.setFont(normalFont);endButton.setBackground(Color.RED);
		callButton.setBorder(border);endButton.setBorder(border);
		numberField.setFont(normalFont);numberField.setBorder(border);
		codeField.setFont(normalFont);codeField.setBorder(border);
		addContact.setFont(normalFont);addContact.setBorder(border);
		codeField.setEditable(false);
		
		creditButton.setBounds(left,bottom,maxWidth-22,buttonHeight);
		callButton.setBounds(left+(maxWidth/2)-100,(bottom-buttonHeight-40),100,buttonHeight);
		endButton.setBounds(left+(maxWidth/2),(bottom-buttonHeight-40),100,buttonHeight);
		numberField.setBounds(left+(maxWidth/3),top+(maxHeight/2),200,buttonHeight);
		codeField.setBounds(left+(maxWidth/3)-60,top+(maxHeight/2),50,buttonHeight);
		addContact.setBounds(left+(maxWidth/3)+210,top+(maxHeight/2),140,buttonHeight);
		dropdown.setBounds(left+(maxWidth/3),top+100,200,buttonHeight);
		
		thisPanel.add(creditButton);thisPanel.add(callButton);thisPanel.add(endButton);
		thisPanel.add(numberField);thisPanel.add(codeField);thisPanel.add(addContact);
		thisPanel.add(dropdown);
		thisPanel.setBackground(Color.ORANGE);
		thisPanel.setBorder(border);

		setContentPane(thisPanel);
	
	}
	
	
	public class AddContactListener implements ActionListener {
		private JFrame frame;
	
		public AddContactListener(JFrame frame) {
			this.frame = frame;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			String numString = numberField.getText();
			String name="";
			Long number=null;
			try {
				 Long.parseLong(numString); 
			}catch(NumberFormatException nfe) {
				numString = recurseCatch();
			}finally {
				 while(numString.length()<4||numString.length()>10) {
						numString = (JOptionPane.showInputDialog(frame,"Please enter a number with the correct number of digits"));
				 }
				// while(numString.charAt(0)!='0'||numString.charAt(0)!='9') {
					//	numString = (JOptionPane.showInputDialog(frame,"Please enter a local phone number"));
				 //}
			}
			name = JOptionPane.showInputDialog(frame,"Please enter contact's name");
			number = new Long(numString);
			contacts.put(name, number);
			names.add(name);
			numberField.setText("");
		}
		public String recurseCatch() {
			long num = 0;
			try {
				num = Long.parseLong(JOptionPane.showInputDialog(frame,"Please enter a number"));
			}
			catch(NumberFormatException nfe) {
				recurseCatch();
			}
		
			return num+"";
		}
	}
	
	public class CallListener implements ActionListener{
		private JFrame frame;
		public CallListener(JFrame frame) {
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent event) {
			if(checkIfNumberLegal(numberField.getText())==true) {
				initializeCallFrame();
				frame.add(callFrame);
			}
			else {
				JOptionPane.showMessageDialog(frame, "Please enter a valid phone number");
			}
		}
		public void initializeCallFrame() {
			callFrame = new JFrame();
			callPanel = new JPanel(new GridLayout());
			callPanel.setBackground(Color.YELLOW);
			callFrame.setContentPane(callPanel);
			callFrame.setVisible(true);
			callFrame.setSize(300, 300);
			callFrame.setLocation(frame.getLocation().x+frame.getSize().width/2, frame.getLocation().y+frame.getSize().height/2);
			callFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	public class CreditAvailableListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	public class DropdownListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent event) {
			String text=(String)event.getItem();
			numberField.setText(""+contacts.get(text));
		}
	}
	
	public boolean checkIfNumberLegal(String num) {
		boolean check = true;
		if(num.length()<4 || num.length()>10) {
			check = false;
		}		
		else if(true) {
			
		}
		try {
			new Long(num);
		}catch(NumberFormatException nfe) {
			check = false;
		}
		
		return check;
	}
	
}
