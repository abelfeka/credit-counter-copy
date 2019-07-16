package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class HomePanel extends JPanel {

	final Border border = new LineBorder(Color.BLACK);
	final Font normalFont = new Font("Candara",Font.PLAIN,20);
		
	private JTextField creditField;
	private JLabel creditAvailable;
	private JLabel enterCreditAvailable;
	private JLabel appName;
	private double credit;
	
	public HomePanel() {this(null);}
	
	public HomePanel(LayoutManager layout) {
		super(layout);

		creditField = new JTextField();
		CreditFieldListener cfl = new CreditFieldListener(this);
		creditField.addActionListener(cfl);

		enterCreditAvailable = new JLabel("Enter Credit:");
		appName = new JLabel("Credit Counter");
		creditAvailable = new JLabel();
		creditAvailable.setVisible(false);
		//TODO:Figure out a way to make the labels fluid/dynamic

		enterCreditAvailable.setBounds(80, 10,150,30);
		creditField.setBounds(195, 10,120,30);
		appName.setBounds(80, 150,350,50);
		creditAvailable.setBounds(110,40,300,30);

		appName.setFont(new Font("Candara",Font.BOLD,50));
		creditField.setFont(normalFont);
		enterCreditAvailable.setFont(normalFont);
		creditAvailable.setFont(normalFont);

		add(creditAvailable);
		add(enterCreditAvailable);
		add(creditField);
		add(appName);
		setBackground(Color.CYAN);
		setBorder(border);
	}
	private class CreditFieldListener implements ActionListener {
		private HomePanel homePanel;
		
		public CreditFieldListener(HomePanel homePanel) {
			this.homePanel = homePanel;
		}
		@Override
		public void actionPerformed(ActionEvent textField) {
			try {
				credit = Double.parseDouble(textField.getActionCommand());
				while(credit<0) {
					credit = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a positive number"));
				}
			}
			catch(NumberFormatException nfe) {
				credit = recurseCatch();
			}
				//enterCreditAvailable.setVisible(false);
				//creditField.setVisible(false);
				creditAvailable.setVisible(true);
				creditAvailable.setText("Credit Available = "+credit);
		}
		
		public double recurseCatch() {
			double dub = 0;
			try {
				dub = Double.parseDouble(JOptionPane.showInputDialog("Please enter a number"));
			}
			catch(NumberFormatException nfe) {
				recurseCatch();
			}
		
			return dub;
		}
		
	}//inner class end

	public double getCredit() {
		return credit;
	}
	
	
}
