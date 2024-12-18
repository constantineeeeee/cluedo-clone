package cluedo;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class SolveMystery implements ActionListener{
	private String[] peopleNames = {"Person", "Miss Scarlett", "Colonel Mustard", 
									"Mrs. White", "Professor Plum", "Rev. Green"};
	
	private String[] roomNames = {"Room", "Conservatory", "Billiard Room", "Library", 
								  "Study", "Ball Room", "Hall", 
								  "Kitchen", "Dining Room", "Lounge"};
	private String[] weaponNames = {"Weapon", "Dagger", "Revolver", "Wrench", "Candlestick"};
	
	static Random rand = new Random();
	
	private JFrame frame;
	private JPanel panel1, panel2;
	private JButton submit, back;
	private JComboBox<String> people  = new JComboBox<String>(peopleNames);
	private JComboBox<String> rooms   = new JComboBox<String>(roomNames);
	private JComboBox<String> weapons = new JComboBox<String>(weaponNames);
	private String backButtonContent = "Skip";
	private URL soundEffect = getClass().getResource("/eliminate.wav");
	private URL winSound= getClass().getResource("/winSound.wav");
	private MusicHandling music = new MusicHandling();
	static DoublyLinkedList dList = MainMenuScreen.getdList();		
	
	
	public SolveMystery() {
		music.setFile(soundEffect);
		
		initializeUI();
	}
	
	public void initializeUI() {
		frame = new JFrame("Solve Mystery");
		frame.setSize(350, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		submit = new JButton("Submit");
		back   = new JButton(backButtonContent);
		
		panel1.setBounds(0, 0, frame.getWidth()-15, 299);
		panel1.setLayout(new GridLayout(3, 1));
		
		panel2.setBounds(0, 300, frame.getWidth()-15, 75);
		panel2.setLayout(new GridLayout(1, 2));
		
		panel1.add(rooms);
		panel1.add(weapons);
		panel1.add(people);
		
		panel2.add(back);
		panel2.add(submit);
		
		frame.add(panel1);
		frame.add(panel2);
		
		submit.addActionListener(this);
		back.addActionListener(this);
		
		if(GameRun.getRound()%2 == 0) {
			back.setEnabled(false);
		}
		else {
			back.setEnabled(true);
		}
		
		frame.setVisible(true);
	}

	public void setBackButtonContent(String backButtonContent) {
		this.backButtonContent = backButtonContent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			GameRun.addRound();
			frame.dispose();
		}
		else if(e.getSource() == submit) {	
			if(people.getSelectedIndex()-1 == GameRun.generate.getChosenPerson() && rooms.getSelectedIndex()-1 == GameRun.generate.getChosenRoom() && weapons.getSelectedIndex()-1 == GameRun.generate.getChosenWeapon()) {
				
				music.setFile(winSound);
				music.playOnce();
				new HintSolution("The Culprit Has Been Caught!");
			}
			else {				
				int randomNum = rand.nextInt(0, dList.listSize());
				System.out.println("RANDOM NUMBER: " + randomNum);
				int choosePerson = dList.get(randomNum);
				
				dList.deleteNodeAtGivenPos(randomNum);
				
				chooseElim(choosePerson);
				GameRun.addKill();
				music.playOnce();
				if(GameRun.killCount == MainMenuScreen.difficulty-1) {
					new HintSolution("The Culprit Managed to Escape!");
				}
			}
			GameRun.addRound();
			frame.dispose();
		}
	}
	
	public void chooseElim(int choosePerson) {
		if(choosePerson == 0) {
			EasyMainBoardDrawingPanel.setScarlettImage(EasyMainBoardDrawingPanel.xScarlett);
			MediumMainBoardDrawingPanel.setScarlettImage(MediumMainBoardDrawingPanel.xScarlett);
			HardMainBoardDrawingPanel.setScarlettImage(HardMainBoardDrawingPanel.xScarlett);
		}
		else if(choosePerson == 1) {
			EasyMainBoardDrawingPanel.setMustardImage(EasyMainBoardDrawingPanel.xMustard);					
			MediumMainBoardDrawingPanel.setMustardImage(MediumMainBoardDrawingPanel.xMustard);					
			HardMainBoardDrawingPanel.setMustardImage(HardMainBoardDrawingPanel.xMustard);					
		}
		else if(choosePerson == 2) {
			EasyMainBoardDrawingPanel.setWhiteImage(EasyMainBoardDrawingPanel.xWhite);					
			MediumMainBoardDrawingPanel.setWhiteImage(MediumMainBoardDrawingPanel.xWhite);					
			HardMainBoardDrawingPanel.setWhiteImage(HardMainBoardDrawingPanel.xWhite);					
		}
		else if(choosePerson == 3) {
			MediumMainBoardDrawingPanel.setPlumImage(MediumMainBoardDrawingPanel.xPlum);					
			HardMainBoardDrawingPanel.setPlumImage(HardMainBoardDrawingPanel.xPlum);					
		}
		else if(choosePerson == 4) {
			HardMainBoardDrawingPanel.setGreenImage(HardMainBoardDrawingPanel.xGreen);					
		}
	}
	
}
