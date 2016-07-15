package v0;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Tester {

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Welcome to mdRPG!");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(400,200));
		JPanel mainPanel = new JPanel();
		mainFrame.setContentPane(mainPanel);
		
		mainPanel.setLayout(new BorderLayout());
		
		Player p = new Player(true, 1);
			
		String[] a = {"Ping","Pong"};
	
		
		JLabel stats = new JLabel("Prepare for a New Quest, Player "+p.getPlayerRole()+"!");
		
		stats.setHorizontalAlignment(SwingConstants.CENTER);
		stats.setForeground(Color.WHITE);
		stats.setOpaque(true);
		stats.setBackground(Color.BLACK);
		stats.setFont(Font.decode("Comic Sans MS-Plain-14"));
		
		



		mainPanel.add(stats, BorderLayout.NORTH);
		
		
		mainFrame.pack();
		mainFrame.setLocation(800,200);
		mainFrame.setVisible(true);
	}

}
