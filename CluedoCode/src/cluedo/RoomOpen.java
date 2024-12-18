package cluedo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class RoomOpen implements ActionListener{
	Random rand = new Random();
	String roomName;
	int roomNum;
	boolean hasWeaponClue = rand.nextBoolean();
	boolean hasPersonClue = rand.nextBoolean();
	
	JFrame roomFrame;
	JButton exit;
	
	String doorOpen;

	
	String noClue = "You look around. No clues found so far.";
	private String roomClueStore, weaponClueStore, personClueStore;
	
	public RoomOpen(String roomName, int roomNum) {
		
		
		doorOpen = "doorEnter.wav";
				
		this.roomNum = roomNum;
		this.roomName = roomName;
		initializeUI();
		
	}
	
	public void initializeUI() {
		roomFrame = new JFrame(roomName);
		roomFrame.setSize(600, 300);
		roomFrame.setLocationRelativeTo(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 600, 300);
		
		panel1.setLayout(new GridLayout(4, 1));
		
		roomClueStore = GameRun.generate.getRoomClue(roomNum);
		JLabel roomClue = new JLabel(roomClueStore);
		JLabel weaponClue = new JLabel();
		JLabel personClue = new JLabel();
		exit = new JButton("BACK");
		

		if(hasWeaponClue) {
			weaponClueStore = GameRun.generate.getWeaponClue(roomNum);
			weaponClue.setText(weaponClueStore);
		}
		else {
			weaponClue.setText(noClue);
		}
	
		
		if(hasPersonClue) {
			personClueStore = GameRun.generate.getPersonClue(roomNum);
			personClue.setText("A person was here! " + personClueStore);
		}
		else {
			personClue.setText(noClue);
		}
			
		panel1.add(roomClue);
		panel1.add(weaponClue);
		panel1.add(personClue);
		panel1.add(exit);
		
		roomFrame.add(panel1);
		
		exit.addActionListener(this);
		
		roomFrame.setDefaultCloseOperation(roomFrame.DISPOSE_ON_CLOSE);
		roomFrame.setVisible(true);
	}

	public String getWeaponClueStore() {
		return weaponClueStore;
	}

	public String getPersonClueStore() {
		return personClueStore;
	}
	
	public String getRoomClueStore() {
		return roomClueStore;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		roomFrame.dispose();
	}
}
