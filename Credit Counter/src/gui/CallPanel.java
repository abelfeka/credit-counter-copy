package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CallPanel extends JPanel {

	final private Border border = new LineBorder(Color.BLACK);
	final private Font normalFont = new Font("Candara",Font.PLAIN,20);
	final private int buttonHeight = 35;

	private JFrame localCallFrame,internationalCallFrame;
	private JButton localCallB,internationalCallB;
	private ButtonGroup group;
	
	public CallPanel() {this(null);}
	
	public CallPanel(LayoutManager layout) {
		
		super(layout);
		localCallB = new JButton("Local Call");
		internationalCallB = new JButton("International Call");
		group = new ButtonGroup();
		group.add(localCallB);group.add(internationalCallB);
	
		localCallB.addActionListener(new CallTypeListener());
		internationalCallB.addActionListener(new CallTypeListener());
		
		localCallB.setFont(normalFont);localCallB.setBorder(border);
		internationalCallB.setFont(normalFont);internationalCallB.setBorder(border);
		localCallB.setBounds(0,0,240,buttonHeight);internationalCallB.setBounds(237,0,240,buttonHeight);
	
		add(localCallB);
		add(internationalCallB);
		
		setBackground(Color.ORANGE);
		setBorder(border);
	}
	
	private class CallTypeListener implements ActionListener{
		private final String local = "Local Call";
		private final String international = "International Call";
		
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton) event.getSource();
			String text = button.getText();
			if(text.equals(local)) {
				localCallFrame = new LocalCallFrame(local);
			}
			else if(text.equals(international)) {
				internationalCallFrame = new InternationalCallFrame(international);
			}
		}
		
	}
	
}
