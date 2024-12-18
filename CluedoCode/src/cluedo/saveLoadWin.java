package cluedo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class saveLoadWin implements ActionListener{
	private JFrame frame;
	private JButton save, load;
	private JPanel panel;
	
	static FileHandler difficultyFilehandler = new FileHandler();
	static FileHandler roomFilehandler = new FileHandler();
	static FileHandler weaponFilehandler = new FileHandler();
	static FileHandler personFilehandler = new FileHandler();
	static FileHandler answersFilehandler = new FileHandler();
	
	public saveLoadWin() {
		
		initializeUI();
	}
	
	public void initializeUI() {
		frame = new JFrame("SAVE/LOAD");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		
		panel = new JPanel();
		save = new JButton("Save");
		load = new JButton("Load");
		
		panel.setBounds(0, 0, frame.getWidth()-15, frame.getHeight()-15);
		panel.setLayout(new GridLayout(1, 2));
		
		panel.add(save);
		panel.add(load);
		
		frame.add(panel);
		
		save.addActionListener(this);
		load.addActionListener(this);
		
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save) {
			
			getDifficultyFilehandler().clear("getDifficulty");
			getDifficultyFilehandler().createNewFile("getDifficulty", true);
			getDifficultyFilehandler().write(Integer.toString(MainMenuScreen.difficulty));

			getAnswersFilehandler().write(Integer.toString(GameRun.getChosenRoom()));
			getAnswersFilehandler().write(Integer.toString(GameRun.getChosenWeapon()));
			getAnswersFilehandler().write(Integer.toString(GameRun.getChosenPerson()));
						
			getRoomFilehandler().writerClose();
			getWeaponFilehandler().writerClose();
			getPersonFilehandler().writerClose();
			getDifficultyFilehandler().writerClose();
			getAnswersFilehandler().writerClose();
			
			frame.dispose();
		}
		else if(e.getSource() == load) {

			saveLoadWin.getRoomFilehandler().createNewFile("roomClues", true);
			saveLoadWin.getWeaponFilehandler().createNewFile("weaponClues", true);
			saveLoadWin.getPersonFilehandler().createNewFile("personClues", true);
			saveLoadWin.getDifficultyFilehandler().createNewFile("getDifficulty", true);
			saveLoadWin.getAnswersFilehandler().createNewFile("answers", true);
			
			getRoomFilehandler().read();
			getWeaponFilehandler().read();
			getPersonFilehandler().read();
			getDifficultyFilehandler().read();
			getAnswersFilehandler().read();
			
			GameRun.generate.setChosenRoom(Integer.parseInt(getAnswersFilehandler().getData().get(0)));
			GameRun.generate.setChosenWeapon(Integer.parseInt(getAnswersFilehandler().getData().get(1)));
			GameRun.generate.setChosenPerson(Integer.parseInt(getAnswersFilehandler().getData().get(2)));
			
			for(int i = 0; i < getDifficultyFilehandler().getData().size(); i++) {
				System.out.println(getDifficultyFilehandler().getData().get(i));
			}
			
			if(HardGUI.getFrame() != null) {
				HardGUI.getFrame().dispose();
			}
			if(MediumGUI.getFrame() != null) {
				MediumGUI.getFrame().dispose();
			}
			if(EasyGUI.getFrame() != null) {
				EasyGUI.getFrame().dispose();
			}
			
			if(getDifficultyFilehandler().getData().get(getDifficultyFilehandler().getLength()).equals("3")) {
				int difficulty = 3;
				new EasyGUI();
				
				for(int i = 0; i < difficulty; i++) {
					if(i == GameRun.getChosenPerson()) {
						continue;
					}
					else{
						MainMenuScreen.getdList().add(i);
					}
				}
				frame.dispose();
			}
			else if(getDifficultyFilehandler().getData().get(getDifficultyFilehandler().getLength()).equals("4")) {
				int difficulty = 4;
				new MediumGUI();
				
				for(int i = 0; i < difficulty; i++) {
					if(i == GameRun.getChosenPerson()) {
						continue;
					}
					else{
						MainMenuScreen.getdList().add(i);
					}
				}
				
				frame.dispose();
			}
			else if(getDifficultyFilehandler().getData().get(getDifficultyFilehandler().getLength()).equals("5")) {
				System.out.println("HERE");
				int difficulty = 5;
				new HardGUI();
				
				
				for(int i = 0; i < difficulty; i++) {
					if(i == GameRun.getChosenPerson()) {
						continue;
					}
					else{
						MainMenuScreen.getdList().add(i);
					}
				}
				frame.dispose();
			}
			
			try {
				MainMenuScreen.getMusic().stop();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		DetectiveSheet.loadData();
		
		getRoomFilehandler().readerClose();
		getWeaponFilehandler().readerClose();
		getRoomFilehandler().readerClose();
		
		
	}

	public static FileHandler getDifficultyFilehandler() {
		return difficultyFilehandler;
	}

	public static FileHandler getRoomFilehandler() {
		return roomFilehandler;
	}

	public static FileHandler getWeaponFilehandler() {
		return weaponFilehandler;
	}

	public static FileHandler getPersonFilehandler() {
		return personFilehandler;
	}

	public static FileHandler getAnswersFilehandler() {
		return answersFilehandler;
	}
}
