package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class MessagePanel extends JPanel{


	final Border border = new LineBorder(Color.BLACK);
	final Font normalFont = new Font("Candara",Font.PLAIN,20);
	final private int buttonHeight = 35;

	private JFrame localMessageFrame,internationalMessageFrame;
	private JButton localMessageB,internationalMessageB;
	private ButtonGroup group;
	
	public MessagePanel() {this(null);}
	
	public MessagePanel(LayoutManager layout) {
		
		super(layout);
		localMessageB = new JButton("Local Message");
		internationalMessageB = new JButton("International Message");
		group = new ButtonGroup();
		group.add(localMessageB);group.add(internationalMessageB);
	
		localMessageB.setFont(normalFont);localMessageB.setBorder(border);
		internationalMessageB.setFont(normalFont);internationalMessageB.setBorder(border);
		localMessageB.setBounds(0,0,240,buttonHeight);internationalMessageB.setBounds(237,0,240,buttonHeight);
	
		add(localMessageB);
		add(internationalMessageB);
		
		setBackground(Color.ORANGE);
		setBorder(border);
	}
	
	private class MessageTypeListener implements ActionListener{
		private final String local = "Local Message";
		private final String international = "International Message";
		
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton) event.getSource();
			String text = button.getText();
			if(text.equals(local)) {
				localMessageFrame = null;// new LocalMessageFrame(local);
			}
			else if(text.equals(international)) {
				internationalMessageFrame = null;// new InternationalMessageFrame(international);
			}
		}
		
	}
}
