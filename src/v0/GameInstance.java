package v0;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import java.util.*;

public class GameInstance extends JFrame implements ActionListener, KeyListener{

	private JPanel mainPanel;
	private JPanel optionsPanel;
	private JPanel optionsPanel2;
	private boolean useFirstOptionsPanel;
	private JTextArea mainLabel;
	int curIndex;
	private int optionsIndex;
	private Player player;
	private OptionHandler OpHand;
	
	
	public GameInstance(Player player, OptionHandler OH){
		super();
		this.player = player;
		OpHand = OH;
		
		addKeyListener(this);
		setTitle("Welcome to mdRPG!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800,300));
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		
		mainPanel.setLayout(new BorderLayout());
		
		
		

		mainLabel = new JTextArea();
		
		
		
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setOpaque(true);
		mainLabel.setBackground(Color.BLACK);
		mainLabel.setFont(Font.decode("Comic Sans MS-Plain-14"));
		mainLabel.setLineWrap(true);
		mainLabel.setEnabled(false);
		mainLabel.setFocusable(false);
		
		mainPanel.add(mainLabel, BorderLayout.NORTH);
		
		optionsPanel = new JPanel(); 
		optionsPanel2 = new JPanel();
		useFirstOptionsPanel = false;
		
		for (int i=0; i<OpHand.getOGAt(curIndex).getNumOptions();i++){
			OptionButton o = new OptionButton(OpHand.getOGAt(curIndex).getOptionAt(i));
			o.addActionListener(this);
			o.addKeyListener(this);
			if (o.getOption().getItemReq() != null){
				if (! player.checkInventory(o.getOption().getItemReq())){
					o.setEnabled(false);
				}
			}
			optionsPanel.add(o);
		}
		mainLabel.setText(OpHand.getGroupDisplayAt(curIndex));
		optionsIndex = 0;
		
		
		
		mainPanel.add(optionsPanel, BorderLayout.CENTER);
		
		setLocation(800,200);
		setAlwaysOnTop(true);
		
		
		
		setAutoRequestFocus(true);
		playOGSounds();
	}
	
	public void run(){
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (player.checkInventoryItem("ChangeClass") != null){
			player.setPRole(player.checkInventoryItem("ChangeClass").getIgnore());
		}
		OptionButton oB = (OptionButton)e.getSource();
		Option o = oB.getOption();
		if (o.getItemToAdd() != null){
			player.addToInventory(o.getItemToAdd());
		}
		MP3Handler.playMP3(o.getSoundName()+".mp3");
		
		curIndex += o.getShift();
		updateOptionButtons();
		System.out.println(o.getDialogue());
		
	}
	
	public void updateOptionButtons(){
		
		
		for (int i=0; i<OpHand.getOGAt(curIndex).getNumOptions();i++){
			OptionButton o = new OptionButton(OpHand.getOGAt(curIndex).getOptionAt(i));
			o.addActionListener(this);
			o.addKeyListener(this);
			if (o.getOption().getItemReq() != null){
				if (! player.checkInventory(o.getOption().getItemReq())){
					o.setEnabled(false);
				}
			}
			if (useFirstOptionsPanel){
				optionsPanel.add(o);
			} else {
				optionsPanel2.add(o);
			}
		}
		if (useFirstOptionsPanel){
			mainPanel.add(optionsPanel, BorderLayout.CENTER);
			optionsPanel.getComponent(0).requestFocusInWindow();
			optionsPanel2.removeAll();
			mainPanel.remove(optionsPanel2);
		} else {
			mainPanel.add(optionsPanel2, BorderLayout.CENTER);
			optionsPanel2.getComponent(0).requestFocusInWindow();
			optionsPanel.removeAll();
			mainPanel.remove(optionsPanel);
		}
		useFirstOptionsPanel = !useFirstOptionsPanel; 
		mainLabel.setText(OpHand.getGroupDisplayAt(curIndex));
		optionsIndex = 0;
		playOGSounds();
		
		pack();
	}
	
	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_RIGHT) {
			//System.out.println("YOU HIT RIGHT!");
			optionsIndex++;
			if (optionsIndex < 0){
				optionsIndex = 1;
			}
			if (!useFirstOptionsPanel){
				if (optionsIndex > optionsPanel.getComponentCount() - 1){
					optionsIndex = 0;
				}
				optionsPanel.getComponent(optionsIndex).requestFocusInWindow();
			} else {
				if (optionsIndex > optionsPanel2.getComponentCount() - 1){
					optionsIndex = 0;
				}
				optionsPanel2.getComponent(optionsIndex).requestFocusInWindow();
			}
			MP3Handler.playMP3(OpHand.getOGAt(curIndex).getOptionAt(optionsIndex).getNarratorSound()+".mp3");
			System.out.println(player.getPlayerRole());
			System.out.println(player.isMale());
			
		}
		if (code == KeyEvent.VK_LEFT) {
			//System.out.println("YOU HIT LEFT!");
			optionsIndex--;
			if (!useFirstOptionsPanel){
				if (optionsIndex > optionsPanel.getComponentCount() - 1){
					optionsIndex = optionsPanel.getComponentCount() -2;
				}
				if (optionsIndex < 0){
					optionsIndex = optionsPanel.getComponentCount() - 1;
				}
				optionsPanel.getComponent(optionsIndex).requestFocusInWindow();
			} else {
				if (optionsIndex > optionsPanel2.getComponentCount() - 1){
					optionsIndex = optionsPanel2.getComponentCount() -2;
				}
				if (optionsIndex < 0){
					optionsIndex = optionsPanel2.getComponentCount() - 1;
				}
				optionsPanel2.getComponent(optionsIndex).requestFocusInWindow();
			}
			MP3Handler.playMP3(OpHand.getOGAt(curIndex).getOptionAt(optionsIndex).getNarratorSound()+".mp3");
			
		}
		if (code == KeyEvent.VK_SPACE){
			//System.out.println("YOU HIT SPACE");
		}
		if (code == KeyEvent.VK_BACK_SPACE){
			System.out.println("YOU HIT BACKSPACE");
			for (String s: OpHand.getOGAt(curIndex).getSoundNames()){
				MP3Handler.playMP3(s+".mp3");
			}
		}
		//System.out.println("SOMETHING HAPPENED");
	}
	
	public void keyReleased(KeyEvent e){
		
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void playOGSounds(){
		for (String s: OpHand.getOGAt(curIndex).getSoundNames()){
			MP3Handler.playMP3(s+".mp3");
		}
	}
}
