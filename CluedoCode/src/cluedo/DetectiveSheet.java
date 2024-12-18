package cluedo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class DetectiveSheet implements ActionListener{
	JFrame dSheetFrame = new JFrame("Detective's Sheet");
	JPanel panel1, panel2, panel3;
	JLabel roomHeader, weaponHeader, personHeader;
	JPanel roomCluesPanel, weaponCluesPanel, personCluesPanel;
	ImageIcon bg = new ImageIcon(this.getClass().getResource("roomOpenbg.png"));
	JButton back = new JButton("Back");
	
	Border line = BorderFactory.createLineBorder(Color.BLACK);
	
	private static ArrayList<String> roomClues = new ArrayList<String>();
	private static ArrayList<String> weaponClues = new ArrayList<String>();
	private static ArrayList<String> personClues = new ArrayList<String>();
	private int count = 0;
	
	public DetectiveSheet() {
		
	}
	
	public void initializeUI() {
		dSheetFrame.setSize(1280, 600);
		dSheetFrame.setLocationRelativeTo(null);
		dSheetFrame.setLayout(null);
		dSheetFrame.setResizable(false);
		dSheetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		roomCluesPanel = new JPanel();
		weaponCluesPanel = new JPanel();
		personCluesPanel = new JPanel();
		
		roomHeader = new JLabel("Room");
		weaponHeader = new JLabel("Weapon");
		personHeader = new JLabel("Person");
		
		roomHeader.setBorder(line);
		weaponHeader.setBorder(line);
		personHeader.setBorder(line);
		
		panel1.setBounds(0, 0, dSheetFrame.getWidth(), 50);
		panel1.setLayout(new GridLayout(1, 3));
		
		panel1.add(roomHeader);
		panel1.add(weaponHeader);
		panel1.add(personHeader);
		
		panel2.setBounds(0, 51, dSheetFrame.getWidth(), 499);
		panel2.setLayout(new GridLayout(1, 3));
		
		roomCluesPanel.setLayout(new GridLayout(10, 1));
		weaponCluesPanel.setLayout(new GridLayout(9, 1));
		personCluesPanel.setLayout(new GridLayout(20, 1));
		
		roomCluesPanel.setBorder(line);
		weaponCluesPanel.setBorder(line);
		personCluesPanel.setBorder(line);

		panel2.add(roomCluesPanel);
		panel2.add(weaponCluesPanel);
		panel2.add(personCluesPanel);
		
		int maxRoomSize = 9, maxWeaponsize = 8, maxPersonSize = 20;
		int roomSize = getRoomClues().size(), weaponSize = weaponClues.size(), personSize = getPersonClues().size();
		
		if(roomSize > 9) {
			roomSize = maxRoomSize;
		}
		if(weaponSize > 8) {
			roomSize = maxWeaponsize;
		}
		if(personSize > 20) {
			personSize = maxPersonSize;
		}
		
		for(int i = 0; i < weaponSize; i++) {
			weaponCluesPanel.add(new JLabel(weaponClues.get(i)));
		}
		for(int i = 0; i < roomSize; i++) {
			roomCluesPanel.add(new JLabel(getRoomClues().get(i)));
		}
		for(int i = 0; i < personSize; i++) {
			personCluesPanel.add(new JLabel(getPersonClues().get(i)));
		}
		
		back.setBounds(0, 500, dSheetFrame.getWidth(), 80);
		
		dSheetFrame.add(panel1);
		dSheetFrame.add(panel2);
		dSheetFrame.add(back);
		
		back.addActionListener(this);
		
		dSheetFrame.setVisible(true);
		
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public static void loadData() {
		for(int i = 0; i < saveLoadWin.roomFilehandler.getData().size(); i++) {
			for(int j = 0; j < getRoomClues().size(); j++) {
				if(saveLoadWin.roomFilehandler.getData().get(i) == getRoomClues().get(j)) {
					break;
				}
			}
			getRoomClues().add(saveLoadWin.roomFilehandler.getData().get(i));
			System.out.println(saveLoadWin.roomFilehandler.getData().get(i));
		}
		
		for(int i = 0; i < saveLoadWin.getWeaponFilehandler().getData().size(); i++) {
			for(int j = 0; j < weaponClues.size(); j++) {
				if(saveLoadWin.getWeaponFilehandler().getData().get(i) == weaponClues.get(j)) {
					break;
				}
			}
			weaponClues.add(saveLoadWin.getWeaponFilehandler().getData().get(i));
			System.out.println(saveLoadWin.getWeaponFilehandler().getData().get(i));
		}
		
		for(int i = 0; i < saveLoadWin.getPersonFilehandler().getData().size(); i++) {
			for(int j = 0; j < getPersonClues().size(); j++) {
				if(saveLoadWin.getPersonFilehandler().getData().get(i) == getPersonClues().get(j)) {
					break;
				}
			}
			getPersonClues().add(saveLoadWin.getPersonFilehandler().getData().get(i));
			System.out.println(saveLoadWin.getPersonFilehandler().getData().get(i));
		}
		
	}
	
	public void addRoomClue(String clue) {
		for(int k = 0; k < getRoomClues().size(); k++) {
			if(getRoomClues().get(k).equals(clue)) {
				return;
			}
		}
		
		if(clue == null) {
			return;
		}
		else {
			getRoomClues().add(clue);
			
			saveLoadWin.roomFilehandler.write(clue);
		}
	}
	public void addWeaponClue(String clue) {
		for(int k = 0; k < weaponClues.size(); k++) {
			if(weaponClues.get(k).equals(clue)) {
				return;
			}
		}
		
		if(clue == null) {
			return;
		}
		else {
			weaponClues.add(clue);
			saveLoadWin.getWeaponFilehandler().write(clue);
		}
	}
	public void addPersonClue(String clue) {
		for(int k = 0; k < getPersonClues().size(); k++) {
			if(getPersonClues().get(k).equals(clue)) {
				return;
			}
		}
		
		if(clue == null) {
			return;
		}
		else {
			getPersonClues().add(clue);

			saveLoadWin.getPersonFilehandler().write(clue);
		}
	}
	
	public void addRoomClueFromFile(ArrayList<String> clue) {
		String newClues[] = {};
		for(int k = 0; k < getRoomClues().size(); k++) {
			if(getRoomClues().get(k).equals(clue.get(k))) {
				continue;
			}
			for(int j = 0; j < clue.size(); j++) {
				if(getRoomClues().get(k).equals(clue.get(j))) {
					continue;
				}
			}
			newClues[k] = clue.get(k);
		}
		
		if(clue == null) {
			return;
		}
		else {
			for(int i = 0; i < newClues.length; i++) {
				getRoomClues().add(newClues[i]);
			}
		}
	}
	
	public void addWeaponClueFromFile(ArrayList<String> clue) {
		String newClues[] = {};
		for(int k = 0; k < weaponClues.size(); k++) {
			if(weaponClues.get(k).equals(clue.get(k))) {
				continue;
			}
			for(int j = 0; j < clue.size(); j++) {
				if(weaponClues.get(k).equals(clue.get(j))) {
					continue;
				}
			}
			newClues[k] = clue.get(k);
		}
		
		if(clue == null) {
			return;
		}
		else {
			for(int i = 0; i < newClues.length; i++) {
				weaponClues.add(newClues[i]);
			}
		}
	}
	
	public String getWeaponClue(int k) {
		return weaponClues.get(k);
	}
	
	public static ArrayList<String> getWeaponClues(){
		return weaponClues;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dSheetFrame.dispose();
	}

	public static ArrayList<String> getRoomClues() {
		return roomClues;
	}

	public static ArrayList<String> getPersonClues() {
		return personClues;
	}


}
