package cluedo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HintSolutionDrawingPanel extends JPanel{
	BufferedImage scarlett, mustard, white, plum, green, bg;
	
	BufferedImage personCard = null;
	
	public HintSolutionDrawingPanel() {
		try {
			bg 		= ImageIO.read(this.getClass().getResource("background.jpg"));
			scarlett= ImageIO.read(this.getClass().getResource("MissScarlett.png"));
			mustard = ImageIO.read(this.getClass().getResource("ColMustard.png"));
			white 	= ImageIO.read(this.getClass().getResource("MrsWhite.png"));
			plum 	= ImageIO.read(this.getClass().getResource("ProfessorPlum.png"));
			green 	= ImageIO.read(this.getClass().getResource("RevGreen.png"));
		}catch (IOException ex){
			System.out.println("Image not found");
		}
		BufferedImage[] images = {scarlett, mustard, white, plum, green};
		personCard = images[GameRun.generate.getChosenPerson()];
	}
	
	public void setImage(BufferedImage image) {
		personCard = image;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, 500, 500, this);
		
		setImage(personCard);
		g.drawImage(personCard, 150, 20, 200, 300, this);
		
		g.setColor(Color.BLACK);
		g.drawLine(0, 350, 500, 350);
	}
}
