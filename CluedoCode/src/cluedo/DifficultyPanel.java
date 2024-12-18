package cluedo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DifficultyPanel extends JPanel{
	BufferedImage easy, medium, hard, howToPlay, saveLoad, logo;
	BufferedImage easy1, medium1, hard1, howToPlay1, exit1;
	BufferedImage revolver, wrench, candlestick, dagger;
	BufferedImage easyImage, mediumImage, hardImage, howToPlayImage, saveLoadImage;
	
	public DifficultyPanel() {
		try {
			easy 		= ImageIO.read(this.getClass().getResource("easy0.png"));
			medium 		= ImageIO.read(this.getClass().getResource("medium0.png"));
			hard 		= ImageIO.read(this.getClass().getResource("hard0.png"));
			howToPlay	= ImageIO.read(this.getClass().getResource("howToPlay0.png"));
			saveLoad 	= ImageIO.read(this.getClass().getResource("saveLoad0.png"));
			
			easy1 		= ImageIO.read(this.getClass().getResource("easy1.png"));
			medium1 	= ImageIO.read(this.getClass().getResource("medium1.png"));
			hard1 		= ImageIO.read(this.getClass().getResource("hard1.png"));
			howToPlay1	= ImageIO.read(this.getClass().getResource("howToPlay1.png"));
			exit1 		= ImageIO.read(this.getClass().getResource("saveLoad1.png"));
			
			logo 		= ImageIO.read(this.getClass().getResource("clogo.png"));
			
			revolver 	= ImageIO.read(this.getClass().getResource("revolver.png"));
			candlestick = ImageIO.read(this.getClass().getResource("candlestick.jpg"));
			dagger 		= ImageIO.read(this.getClass().getResource("dagger.png"));
			wrench		= ImageIO.read(this.getClass().getResource("wrench.png"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		easyImage 		= easy;
		mediumImage 	= medium;
		hardImage 		= hard;
		howToPlayImage 	= howToPlay;
		saveLoadImage 		= saveLoad;
	}
	
	public void setEasyImage(BufferedImage image) {
		easyImage = image;
	}
	public void setMediumImage(BufferedImage image) {
		mediumImage = image;
	}
	public void setHardImage(BufferedImage image) {
		hardImage = image;
	}
	public void setHowToPlayImage(BufferedImage image) {
		howToPlayImage = image;
	}
	public void setSaveImage(BufferedImage image) {
		saveLoadImage = image;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(1.0f, 0.75f, 0.0f));
		g.fillRect(0, 0, getWidth()+5, getHeight());
		
		
		setEasyImage(easyImage);
		g.drawImage(easyImage, 0, 0, getWidth()/2 - 20, getHeight()/4, this);
		setEasyImage(mediumImage);
		g.drawImage(mediumImage, 0, getHeight()/3-10, getWidth()/2 - 20, getHeight()/4, this);
		setHardImage(hardImage);
		g.drawImage(hardImage, 0, getHeight()/3 + getHeight()/4+5, getWidth()/2 - 20, getHeight()/4, this);
		
		setHowToPlayImage(howToPlayImage);
		g.drawImage(howToPlayImage, getWidth()/2+5, getHeight()/5-10, getWidth()/2 - 20, getHeight()/4, this);
		
		setSaveImage(saveLoadImage);
		g.drawImage(saveLoadImage, getWidth()/2+5, (getHeight()/5-10)*2+getHeight()/7, getWidth()/2 - 20, getHeight()/4, this);
		
	}
}
