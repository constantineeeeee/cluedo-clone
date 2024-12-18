package cluedo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class EasyMainBoardDrawingPanel extends JPanel{
	BufferedImage bg, board, scarlett, mustard, white, plum, green, logo, dSheet, solve, hint, mainMenu;
	BufferedImage libHover, ballRoomHover, brHover, consHover, drHover, hallHover, kitHover, loungeHover, studyHover;
	BufferedImage dSheet1, solve1, hint1, mainMenuHover;
	BufferedImage dSheetImage, solveImage, hintImage, mainMenuImage;
	static BufferedImage xScarlett, xMustard, xWhite;
	static BufferedImage scarlettImage, mustardImage, whiteImage, plumImage;
	BufferedImage libImage, ballRoomImage, brImage, consImage, drImage, hallImage, kitImage, loungeImage, studyImage;
	int picWidth = 150, picHeight = 200, space = 50, startY = 20, startX = 60;
	int x, y;
	JPanel menuPanel;
	JLabel clogo;
	ImageIcon logo2 = new ImageIcon(this.getClass().getResource("clogo.png"));
	
	
	public EasyMainBoardDrawingPanel() {

		try {
			logo 	= ImageIO.read(this.getClass().getResource("clogo.png"));
			dSheet 	= ImageIO.read(this.getClass().getResource("dSheet0.png"));
			solve 	= ImageIO.read(this.getClass().getResource("solve0.png"));
			hint 	= ImageIO.read(this.getClass().getResource("hint0.png"));
			mainMenu= ImageIO.read(this.getClass().getResource("mainMenu0.png"));
			
			dSheet1 = ImageIO.read(this.getClass().getResource("dSheet1.png"));
			solve1 	= ImageIO.read(this.getClass().getResource("solve1.png"));
			hint1 	= ImageIO.read(this.getClass().getResource("hint1.png"));
			mainMenuHover= ImageIO.read(this.getClass().getResource("mainMenu1.png"));
			
			bg 		= ImageIO.read(this.getClass().getResource("background.jpg"));
			board 	= ImageIO.read(this.getClass().getResource("board2.png"));
			scarlett= ImageIO.read(this.getClass().getResource("MissScarlett.png"));
			mustard = ImageIO.read(this.getClass().getResource("ColMustard.png"));
			white 	= ImageIO.read(this.getClass().getResource("MrsWhite.png"));
			plum 	= ImageIO.read(this.getClass().getResource("ProfessorPlum.png"));
			green 	= ImageIO.read(this.getClass().getResource("RevGreen.png"));
			
			xScarlett 	= ImageIO.read(this.getClass().getResource("eliminatedScarlett.png"));
			xMustard	= ImageIO.read(this.getClass().getResource("eliminatedMustard.png"));
			xWhite 		= ImageIO.read(this.getClass().getResource("eliminatedWhite.png"));
			
			libHover= ImageIO.read(this.getClass().getResource("libHover.png"));
			ballRoomHover= ImageIO.read(this.getClass().getResource("ballRoomHover.png"));
			brHover = ImageIO.read(this.getClass().getResource("brHover.png"));
			consHover= ImageIO.read(this.getClass().getResource("consHover.png"));
			drHover = ImageIO.read(this.getClass().getResource("drHover.png"));
			hallHover= ImageIO.read(this.getClass().getResource("hallHover.png"));
			kitHover= ImageIO.read(this.getClass().getResource("kitHover.png"));
			loungeHover= ImageIO.read(this.getClass().getResource("loungeHover.png"));
			studyHover= ImageIO.read(this.getClass().getResource("studyHover.png"));
		}catch (IOException ex){
			System.out.println("Image not found");
		}
		
		dSheetImage = dSheet;
		solveImage 	= solve;
		hintImage 	= hint;
		mainMenuImage = mainMenu;
		
		scarlettImage = scarlett;
		mustardImage = mustard;
		whiteImage = white;
		
		libImage = null;
		ballRoomImage = null;
		brImage = null;
		consImage = null;
		drImage = null;
		hallImage = null;
		kitImage = null;
		loungeImage = null;
		studyImage = null;
	}
	
	public void createGameMenu() {
		menuPanel = new JPanel();

		menuPanel.setLayout(new GridLayout(5, 1));
		
		clogo = new JLabel();
		clogo.setIcon(logo2);
	}
	
	public void setDSheetImage(BufferedImage image) {
		dSheetImage = image;
	}
	public void setSolveImage(BufferedImage image) {
		solveImage = image;
	}
	public void setHintImage(BufferedImage image) {
		hintImage = image;
	}
	public void setMenuImage(BufferedImage image) {
		mainMenuImage = image;
	}
	
	public void setLibImage(BufferedImage image) {
		libImage = image;
	}
	public void setballRoomImage(BufferedImage image) {
		ballRoomImage = image;
	}
	public void setBRImage(BufferedImage image) {
		brImage = image;
	}
	public void setConsImage(BufferedImage image) {
		consImage = image;
	}
	public void setDRImage(BufferedImage image) {
		drImage = image;
	}
	public void setHallImage(BufferedImage image) {
		hallImage = image;
	}
	public void setKitImage(BufferedImage image) {
		kitImage = image;
	}
	public void setloungeImage(BufferedImage image) {
		loungeImage = image;
	}
	public void setStudyImage(BufferedImage image) {
		studyImage = image;
	}
	
	static void setScarlettImage(BufferedImage image) {
		scarlettImage = image;
	}
	static void setMustardImage(BufferedImage image) {
		mustardImage = image;
	}
	static void setWhiteImage(BufferedImage image) {
		whiteImage = image;
	}
	
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(bg, 0, 0, 1280, 768, this);
		g.drawImage(board, 500, 0, this);
		
		setScarlettImage(scarlettImage);
		g.drawImage(scarlettImage, startX, startY, picWidth, picHeight, this);
		
		setMustardImage(mustardImage);
		g.drawImage(mustardImage, startX + picWidth + space, startY + picHeight/2 + space, picWidth, picHeight, this);
		
		setWhiteImage(whiteImage);
		g.drawImage(whiteImage, startX, startY + picHeight + space , picWidth, picHeight, this);
		
		g.drawImage(logo, 819, 293, 124, 41, this);
		setDSheetImage(dSheetImage);
		g.drawImage(dSheetImage, 819, 293+43, 124, 41, this);
		setSolveImage(solveImage);
		g.drawImage(solveImage, 819, 293+41*2, 124, 41, this);
		setHintImage(hintImage);
		g.drawImage(hintImage, 819, 293+41*3, 124, 41, this);
		setMenuImage(mainMenuImage);
		g.drawImage(mainMenuImage, 819, 293+41*4, 124, 41, this);
		
		setLibImage(libImage);
		g.drawImage(libImage, 571, 469, 139, 26, this);
		
		setballRoomImage(ballRoomImage);
		g.drawImage(ballRoomImage, 808, 144, 950-808, 172-144, this);
		
		setBRImage(brImage);
		g.drawImage(brImage, 612, 240, 31, 84, this);
		
		setLibImage(consImage);
		g.drawImage(consImage, 573, 86, 126, 14, this);
		
		setDRImage(drImage);
		g.drawImage(drImage, 1085, 358, 1123-1085, 443-358, this);
		
		setHallImage(hallImage);
		g.drawImage(hallImage, 859, 627, 926-859, 644-627, this);
		
		setKitImage(kitImage);
		g.drawImage(kitImage, 1049, 137, 1178-1049, 164-137, this);
		
		setloungeImage(loungeImage);
		g.drawImage(loungeImage, 1068, 645, 1168-1068, 664-645, this);
		
		setStudyImage(studyImage);
		g.drawImage(studyImage, 602, 663, 699-602, 20, this);
	}
}
