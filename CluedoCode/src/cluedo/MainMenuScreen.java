package cluedo;

import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;

public class MainMenuScreen implements MouseListener, MouseMotionListener{
	private JFrame frame;
	private MainMenuScreenDrawingPanel drawingPanel;
	private DifficultyPanel difficultyPanel;
	private boolean open = false;
	private URL song = getClass().getResource("/openingMusic.wav");
	private URL bgMusic = getClass().getResource("/mainBoardsong.wav");
	private static MusicHandling music, music2;
	static int difficulty;
	private static DoublyLinkedList dList = new DoublyLinkedList();
	private int[] numbers = {0, 1, 2, 3, 4};
	
	public MainMenuScreen() {
		
		drawingPanel = new MainMenuScreenDrawingPanel();
		music = new MusicHandling();
		music2 = new MusicHandling();
		
		getMusic().setFile(song);
		getMusic().playLoop();
		
		initializeUI();
	}
	
	public void initializeUI() {
		frame = new JFrame("Main Menu");
		frame.setSize(346, 265);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		drawingPanel.setBounds(0, 0, frame.getWidth()-15, frame.getHeight());
		

		difficultyPanel = new DifficultyPanel();
		difficultyPanel.setBounds(0, 0, 346, 265);
		difficultyPanel.addMouseListener(this);
		difficultyPanel.addMouseMotionListener(this);
		
		difficultyPanel.setVisible(false);
		difficultyPanel.setEnabled(false);
		
		frame.add(difficultyPanel);
		frame.add(drawingPanel);
		drawingPanel.addMouseListener(this);
		
		frame.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e) {		
			drawingPanel.setEnabled(false);
			drawingPanel.setVisible(false);
			
			difficultyPanel.setEnabled(true);
			difficultyPanel.setVisible(true);
			
			setOpen(true);
			
		
			if(open && e.getX() >= 0 && e.getX() <= 153 && e.getY() >= 0 && e.getY() <= 67) {
				difficulty = 3;
				GameRun.generate.generateAnswers(difficulty);

				if(HardGUI.getFrame() != null) {
					music2.setFile(song);
					music.setFile(bgMusic);
					try {
						music.stop();
						music2.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					HardGUI.getFrame().dispose();
				}
				if(MediumGUI.getFrame() != null) {
					music2.setFile(song);
					music.setFile(bgMusic);
					try {
						music.stop();
						music2.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					MediumGUI.getFrame().dispose();
				}
				if(EasyGUI.getFrame() != null) {
					music2.setFile(song);
					music.setFile(bgMusic);
					try {
						music.stop();
						music2.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					EasyGUI.getFrame().dispose();
				}
				
				new EasyGUI();
				
				try {
					getMusic().stop();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				setOpen(false);
				
				for(int i = 0; i < difficulty; i++) {
					if(i == GameRun.getChosenPerson()) {
						continue;
					}
					else{
						dList.add(i);
					}
				}
				
				saveLoadWin.getRoomFilehandler().createNewFile("roomClues", true);
				saveLoadWin.getWeaponFilehandler().createNewFile("weaponClues", true);
				saveLoadWin.getPersonFilehandler().createNewFile("personClues", true);

				saveLoadWin.getRoomFilehandler().clear("roomClues");
				saveLoadWin.getWeaponFilehandler().clear("weaponClues");
				saveLoadWin.getPersonFilehandler().clear("personClues");
				saveLoadWin.getAnswersFilehandler().clear("answers");
				
				frame.dispose();
			}
			else if(open && e.getSource() == difficultyPanel && e.getX() >= 0 && e.getX() <= 153 && e.getY() >= 78 && e.getY() <= 145) {
				difficulty = 4;
				GameRun.generate.generateAnswers(difficulty);

				if(HardGUI.getFrame() != null) {
					music2.setFile(song);
					music.setFile(bgMusic);
					try {
						music.stop();
						music2.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					HardGUI.getFrame().dispose();
				}
				if(MediumGUI.getFrame() != null) {
					music2.setFile(song);
					music.setFile(bgMusic);
					try {
						music.stop();
						music2.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					MediumGUI.getFrame().dispose();
				}
				if(EasyGUI.getFrame() != null) {
					music2.setFile(song);
					music.setFile(bgMusic);
					try {
						music.stop();
						music2.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					EasyGUI.getFrame().dispose();
				}
				
				new MediumGUI();
				
				try {
					getMusic().stop();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				setOpen(false);
				
				for(int i = 0; i < difficulty; i++) {
					if(i == GameRun.getChosenPerson()) {
						continue;
					}
					else{
						dList.add(i);
					}
				}
				
				saveLoadWin.getRoomFilehandler().createNewFile("roomClues", true);
				saveLoadWin.getWeaponFilehandler().createNewFile("weaponClues", true);
				saveLoadWin.getPersonFilehandler().createNewFile("personClues", true);
				
				saveLoadWin.getRoomFilehandler().clear("roomClues");
				saveLoadWin.getWeaponFilehandler().clear("weaponClues");
				saveLoadWin.getPersonFilehandler().clear("personClues");
				saveLoadWin.getAnswersFilehandler().clear("answers");
				
				
				frame.dispose();
			}
			else if(open && e.getSource() == difficultyPanel && e.getX() >= 0 && e.getX() <= 153 && e.getY() >= 159 && e.getY() <= 226) {
				difficulty = 5;
				GameRun.generate.generateAnswers(difficulty);

				if(HardGUI.getFrame() != null) {
					music2.setFile(song);
					music.setFile(bgMusic);
					try {
						music.stop();
						music2.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					HardGUI.getFrame().dispose();
				}
				if(MediumGUI.getFrame() != null) {
					music2.setFile(song);
					music.setFile(bgMusic);
					try {
						music.stop();
						music2.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					MediumGUI.getFrame().dispose();
				}
				if(EasyGUI.getFrame() != null) {
					music2.setFile(song);
					music.setFile(bgMusic);
					try {
						music.stop();
						music2.stop();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					EasyGUI.getFrame().dispose();
				}
				
				new HardGUI();
				
				try {
					getMusic().stop();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				setOpen(false);
				
				for(int i = 0; i < difficulty; i++) {
					if(i == GameRun.getChosenPerson()) {
						continue;
					}
					else{
						dList.add(i);
					}
				}
				
				
				saveLoadWin.getRoomFilehandler().createNewFile("roomClues", true);
				saveLoadWin.getWeaponFilehandler().createNewFile("weaponClues", true);
				saveLoadWin.getPersonFilehandler().createNewFile("personClues", true);

				saveLoadWin.getRoomFilehandler().clear("roomClues");
				saveLoadWin.getWeaponFilehandler().clear("weaponClues");
				saveLoadWin.getPersonFilehandler().clear("personClues");
				saveLoadWin.getAnswersFilehandler().clear("answers");
				
				
				frame.dispose();
			}
			else if(open && e.getSource() == difficultyPanel && e.getX() >= 178 && e.getX() <= 346 && e.getY() >= 43 && e.getY() <= 110) {
				new HowToPlay();
			}
			else if(e.getX() >= 178 && e.getX() <= 346 && e.getY() >= 123 && e.getY() <= 190) {
				new saveLoadWin();
			}			
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		if(e.getX() >= 0 && e.getX() <= 153 && e.getY() >= 0 && e.getY() <= 67) {
			difficultyPanel.setEasyImage(difficultyPanel.easy1);
		}
		else {
			difficultyPanel.setEasyImage(difficultyPanel.easy);
		}
		
		if(e.getX() >= 0 && e.getX() <= 153 && e.getY() >= 78 && e.getY() <= 145) {
			difficultyPanel.setMediumImage(difficultyPanel.medium1);
		}
		else {
			difficultyPanel.setMediumImage(difficultyPanel.medium);
		}
		
		if(e.getX() >= 0 && e.getX() <= 153 && e.getY() >= 159 && e.getY() <= 226) {
			difficultyPanel.setHardImage(difficultyPanel.hard1);
		}
		else {
			difficultyPanel.setHardImage(difficultyPanel.hard);
		}
		
		if(e.getX() >= 178 && e.getX() <= 346 && e.getY() >= 43 && e.getY() <= 110) {
			difficultyPanel.setHowToPlayImage(difficultyPanel.howToPlay1);
		}
		else {
			difficultyPanel.setHowToPlayImage(difficultyPanel.howToPlay);
		}
		
		if(e.getX() >= 178 && e.getX() <= 346 && e.getY() >= 123 && e.getY() <= 190) {
			difficultyPanel.setSaveImage(difficultyPanel.exit1);
		}
		else {
			difficultyPanel.setSaveImage(difficultyPanel.saveLoad);
		}
		
		difficultyPanel.repaint();
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public boolean getOpen() {
		return open;
	}
	
	public void stopSong() {
		try {
			getMusic().stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getDifficulty() {
		return difficulty;
	}

	public static DoublyLinkedList getdList() {
		return dList;
	}

	public static MusicHandling getMusic() {
		return music;
	}
	
}
