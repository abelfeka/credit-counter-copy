package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class InternationalCallFrame extends JFrame {
	final Border border = new LineBorder(Color.BLACK);
	final Font normalFont = new Font("Candara",Font.PLAIN,20);

	private JButton creditButton;
	
	public InternationalCallFrame() {this("");}

	public InternationalCallFrame(String title) {
		super(title);
		
		creditButton = new JButton("Credit Available");
		creditButton.setFont(normalFont);
		
		add(creditButton);
		setBackground(Color.ORANGE);
		setVisible(true);
		setSize(600,600);
		setLocation(1100,300);
	}
}
