package gui;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.*;

public class GUI extends JFrame {
	
	final Font normalfont = new Font("Candara",Font.BOLD,20);
	final Date date = new Date(System.currentTimeMillis());
	final String dateString = date.toString().substring(0, 10) + date.toString().substring(24,29);
	final String timeString = date.toString().substring(11, 19);
	final Border border = new LineBorder(Color.BLACK);
	
	private JPanel homePanel,callPanel,smsPanel,internetPanel;
	private JRadioButton homeRB,callRB,smsRB,internetRB;	
	private ButtonGroup group;
	private JMenuBar menuBar;
	
	public GUI() {
		super("Credit Counter");
		String spaces="";
		for (int i = 0; i < 12; i++) {spaces+=" ";}
		homePanel = new HomePanel();
		callPanel = new CallPanel();//new FlowLayout());
		smsPanel = new MessagePanel();
		internetPanel = new InternetPanel();
		
		menuBar = new JMenuBar();
		homeRB = new JRadioButton("Home"+spaces,true);
		callRB = new JRadioButton("Call"+spaces,false);
		smsRB = new JRadioButton("SMS"+spaces,false);
		internetRB = new JRadioButton("Internet"+spaces,false);
		group = new ButtonGroup();
		group.add(homeRB);group.add(callRB);
		group.add(smsRB);group.add(internetRB);
		
		homeRB.addItemListener(new PanelChangeListener(homePanel,this));
		callRB.addItemListener(new PanelChangeListener(callPanel,this));
		smsRB.addItemListener(new PanelChangeListener(smsPanel,this));
		internetRB.addItemListener(new PanelChangeListener(internetPanel,this));
		
		homeRB.setFont(normalfont);homeRB.setBackground(Color.LIGHT_GRAY);
		callRB.setFont(normalfont);callRB.setBackground(Color.GREEN);
		smsRB.setFont(normalfont);smsRB.setBackground(Color.YELLOW);
		internetRB.setFont(normalfont);internetRB.setBackground(Color.RED);
		
		menuBar.add(homeRB);menuBar.add(callRB);
		menuBar.add(smsRB);menuBar.add(internetRB);
		
		setJMenuBar(menuBar);
		setVisible(true);
		setContentPane(homePanel);
		setLocation(600,300);
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private class PanelChangeListener implements ItemListener{
		private JPanel panel;
		private JFrame frame;
	
		public PanelChangeListener(JPanel panel, JFrame frame) {
			this.panel = panel;
			this.frame = frame;
		}
		@Override
		public void itemStateChanged(ItemEvent event) {
			frame.remove(frame.getContentPane());
			frame.setContentPane(panel);
			frame.validate();
		}
		
	}
	
}
