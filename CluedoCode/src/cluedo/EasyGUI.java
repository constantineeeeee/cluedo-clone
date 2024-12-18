package cluedo;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

public class EasyGUI implements MouseListener, MouseMotionListener{
	private static JFrame frame;
	private EasyMainBoardDrawingPanel drawingPanel;
	
	private int width = 1280, height = 768;
	
	private MusicHandling music = new MusicHandling();
	private URL bgMusic = getClass().getResource("/mainBoardsong.wav");
	private URL bgMusic1= getClass().getResource("/highRoundMusic.wav");
	
	private RoomOpen currentRoom;
	private DetectiveSheet dSheetWin = new DetectiveSheet();
	
	private ArrayList<String> roomClueStorage = new ArrayList<String>();
	private ArrayList<String> weaponClueStorage = new ArrayList<String>();
	private ArrayList<String> personClueStorage = new ArrayList<String>();
			
	public EasyGUI() {
		music.setFile(bgMusic);
		music.playLoop();
		initializeUI();
	}
	
	public void initializeUI() {
		frame = new JFrame("CLUEDO");
		getFrame().setSize(width, height);
		getFrame().setLocationRelativeTo(null);
		getFrame().setLayout(null);
		getFrame().setResizable(false);
		
		drawingPanel = new EasyMainBoardDrawingPanel();
		drawingPanel.setBounds(0, 0, width, height);
		
		getFrame().add(drawingPanel);
		
		drawingPanel.addMouseListener(this);
		drawingPanel.addMouseMotionListener(this);
				
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setVisible(true);
	}
	

	public void mouseClicked(MouseEvent e) {
		//Conservatory
		if(e.getX() >= 573 && e.getX() <= 573+126 && e.getY() >= 86 && e.getY() <= 86+14) {
			currentRoom = new RoomOpen("Conservatory", 0);
			roomClueStorage.add(currentRoom.getRoomClueStore());
			personClueStorage.add(currentRoom.getPersonClueStore());
			weaponClueStorage.add(currentRoom.getWeaponClueStore());
			
		}
		//Billiard Room BR
		else if(e.getX() >= 612 && e.getX() <= 643 && e.getY() >= 240 && e.getY() <= 324) {
			currentRoom = new RoomOpen("Billiard Room", 1);
			roomClueStorage.add(currentRoom.getRoomClueStore());
			personClueStorage.add(currentRoom.getPersonClueStore());
			weaponClueStorage.add(currentRoom.getWeaponClueStore());
		}
		//Library
		else if(e.getX() >= 571 && e.getX() <= 571+139 && e.getY() >= 469 && e.getY() <= 469+26) {
			currentRoom = new RoomOpen("Library", 2);
			roomClueStorage.add(currentRoom.getRoomClueStore());
			personClueStorage.add(currentRoom.getPersonClueStore());
			weaponClueStorage.add(currentRoom.getWeaponClueStore());
		}
		//Study
		else if(e.getX() >= 602 && e.getX() <= 699 && e.getY() >= 663 && e.getY() <= 683) {
			currentRoom = new RoomOpen("Study", 3);
			roomClueStorage.add(currentRoom.getRoomClueStore());
			personClueStorage.add(currentRoom.getPersonClueStore());
			weaponClueStorage.add(currentRoom.getWeaponClueStore());
		}
		//Ball Room
		else if(e.getX() >= 808 && e.getX() <= 950 && e.getY() >= 144 && e.getY() <= 172) {
			currentRoom = new RoomOpen("Ballroom", 4);
			roomClueStorage.add(currentRoom.getRoomClueStore());
			personClueStorage.add(currentRoom.getPersonClueStore());
			weaponClueStorage.add(currentRoom.getWeaponClueStore());
		}
		//Hall
		else if(e.getX() >= 859 && e.getX() <= 926 && e.getY() >= 625 && e.getY() <= 644) {
			currentRoom = new RoomOpen("Hall", 5);
			roomClueStorage.add(currentRoom.getRoomClueStore());
			personClueStorage.add(currentRoom.getPersonClueStore());
			weaponClueStorage.add(currentRoom.getWeaponClueStore());
		}
		//Kitchen
		else if(e.getX() >= 1049 && e.getX() <= 1178 && e.getY() >= 137 && e.getY() <= 164) {
			currentRoom = new RoomOpen("Kitchen", 6);
			roomClueStorage.add(currentRoom.getRoomClueStore());
			personClueStorage.add(currentRoom.getPersonClueStore());
			weaponClueStorage.add(currentRoom.getWeaponClueStore());
		}
		//Dining Room
		else if(e.getX() >= 1085 && e.getX() <= 1123 && e.getY() >= 358 && e.getY() <= 443) {
			currentRoom = new RoomOpen("Dining Room", 7);
			roomClueStorage.add(currentRoom.getRoomClueStore());
			personClueStorage.add(currentRoom.getPersonClueStore());
			weaponClueStorage.add(currentRoom.getWeaponClueStore());
		}
		//Lounge
		else if(e.getX() >= 1068 && e.getX() <= 1168 && e.getY() >= 645 && e.getY() <= 664) {
			currentRoom = new RoomOpen("Lounge", 8);
			roomClueStorage.add(currentRoom.getRoomClueStore());
			personClueStorage.add(currentRoom.getPersonClueStore());
			weaponClueStorage.add(currentRoom.getWeaponClueStore());
		}
		
		
		if(e.getX() >= 819 && e.getX() <= 819+124 &&e.getY() >= 293 + 43 && e.getY() <= 293 + 41+43 ) {
			
			dSheetWin = new DetectiveSheet();
			
			for(int i = 0; i < weaponClueStorage.size(); i++) {
				dSheetWin.addWeaponClue(weaponClueStorage.get(i));
			}
			for(int i = 0; i < roomClueStorage.size(); i++) {
				dSheetWin.addRoomClue(roomClueStorage.get(i));
			}
			for(int i = 0; i < personClueStorage.size(); i++) {
				dSheetWin.addPersonClue(personClueStorage.get(i));
			}
			
			dSheetWin.initializeUI();
		}
		
		if(e.getX() >= 819 && e.getX() <= 819+124 &&e.getY() >= 293 + 43*3 && e.getY() <= 293 + 41+43*3 ) {
			new HintSolution("Hint/Solution");
		}
		
		if(e.getX() >= 819 && e.getX() <= 819+124 &&e.getY() >= 293 + 43*2 && e.getY() <= 293 + 41+43*2 ) {
			new SolveMystery();
			if(GameRun.killCount == MainMenuScreen.difficulty - 3) {
				try {
					music.stop();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				music.setFile(bgMusic1);
				music.playLoop();
			}
		}
		
		if(e.getX() >= 819 && e.getX() <= 819+124 &&e.getY() >= 293 + 43*4 && e.getY() <= 293 + 41+43*4 ) {
			MainMenuScreen mms = new MainMenuScreen();
			mms.stopSong();
			mms.setOpen(false);
		}
		drawingPanel.repaint();
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
		if(e.getX() >= 819 && e.getX() <= 819+124 &&e.getY() >= 293 + 43 && e.getY() <= 293 + 41+43 ) {
			drawingPanel.setDSheetImage(drawingPanel.dSheet1);
		}
		else {
			drawingPanel.setDSheetImage(drawingPanel.dSheet);
		}
		if(e.getX() >= 819 && e.getX() <= 819+124 &&e.getY() >= 293 + 43*2 && e.getY() <= 293 + 41+43*2 ) {
			drawingPanel.setSolveImage(drawingPanel.solve1);
		}
		else {
			drawingPanel.setSolveImage(drawingPanel.solve);
		}
		if(e.getX() >= 819 && e.getX() <= 819+124 &&e.getY() >= 293 + 43*3 && e.getY() <= 293 + 41+43*3 ) {
			drawingPanel.setHintImage(drawingPanel.hint1);
		}
		else {
			drawingPanel.setHintImage(drawingPanel.hint);
		}
		if(e.getX() >= 819 && e.getX() <= 819+124 &&e.getY() >= 293 + 43*4 && e.getY() <= 293 + 41+43*4 ) {
			drawingPanel.setMenuImage(drawingPanel.mainMenuHover);
		}
		else {
			drawingPanel.setMenuImage(drawingPanel.mainMenu);
		}
		
		//Library
		if(e.getX() >= 571 && e.getX() <= 571+139 && e.getY() >= 469 && e.getY() <= 469+26) {
			drawingPanel.setLibImage(drawingPanel.libHover);
		}
		else {
			drawingPanel.setLibImage(null);
		}
		
		//Conservatory
		if(e.getX() >= 573 && e.getX() <= 573+126 && e.getY() >= 86 && e.getY() <= 86+14) {
			drawingPanel.setConsImage(drawingPanel.consHover);
		}
		else {
			drawingPanel.setConsImage(null);
		}
		
		//Billiard Room BR
		if(e.getX() >= 612 && e.getX() <= 643 && e.getY() >= 240 && e.getY() <= 324) {
			drawingPanel.setBRImage(drawingPanel.brHover);
		}
		else {
			drawingPanel.setBRImage(null);
		}
		
		//Study
		if(e.getX() >= 602 && e.getX() <= 699 && e.getY() >= 663 && e.getY() <= 683) {
			drawingPanel.setStudyImage(drawingPanel.studyHover);
		}
		else {
			drawingPanel.setStudyImage(null);
		}
		
		//Ball Room
		if(e.getX() >= 808 && e.getX() <= 950 && e.getY() >= 144 && e.getY() <= 172) {
			drawingPanel.setballRoomImage(drawingPanel.ballRoomHover);
		}
		else {
			drawingPanel.setballRoomImage(null);
		}
		
		//Hall
		if(e.getX() >= 859 && e.getX() <= 926 && e.getY() >= 625 && e.getY() <= 644) {
			drawingPanel.setHallImage(drawingPanel.hallHover);
		}
		else {
			drawingPanel.setHallImage(null);
		}
		
		//Kitchen
		if(e.getX() >= 1049 && e.getX() <= 1178 && e.getY() >= 137 && e.getY() <= 164) {
			drawingPanel.setKitImage(drawingPanel.kitHover);
		}
		else {
			drawingPanel.setKitImage(null);
		}
		
		//Lounge
		if(e.getX() >= 1068 && e.getX() <= 1168 && e.getY() >= 645 && e.getY() <= 664) {
			drawingPanel.setloungeImage(drawingPanel.loungeHover);
		}
		else {
			drawingPanel.setloungeImage(null);
		}
		
		//Dining Room
		if(e.getX() >= 1085 && e.getX() <= 1123 && e.getY() >= 358 && e.getY() <= 443) {
			drawingPanel.setDRImage(drawingPanel.drHover);
		}
		else {
			drawingPanel.setDRImage(null);
		}
		drawingPanel.repaint();
	}

	public static JFrame getFrame() {
		return frame;
	}
}
