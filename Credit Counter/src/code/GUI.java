package code;

import java.awt.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.*;

public class GUI extends JFrame {
	
	final Font ccfont = new Font("Candara",20,20);
	final Date date = new Date(System.currentTimeMillis());
	final String dateString = date.toString().substring(0, 10) + date.toString().substring(24,29);
	final String timeString = date.toString().substring(11, 19);
	final Border border = new LineBorder(Color.BLACK);
	
	private JPanel panel;
	private JLabel appName;
	private JButton creditButton;
	
	

	
	public GUI() {
		super("Credit Counter");
		panel = new JPanel(new GridLayout(1,1));
		appName = new JLabel("CREDIT-COUNTER");
		creditButton = new JButton("Calculate Credit Left");

		panel.setBorder(border);panel.setBackground(Color.ORANGE);
		appName.setFont(new Font("Candara",50,50));
		creditButton.setFont(ccfont);
		
		panel.add(appName);panel.add(creditButton);
		
		add(panel);
		setVisible(true);
		setLocation(300,300);
		setLayout(new FlowLayout());
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}

	
}
