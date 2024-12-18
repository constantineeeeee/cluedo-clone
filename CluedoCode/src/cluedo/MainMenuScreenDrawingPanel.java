package cluedo;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class MainMenuScreenDrawingPanel extends JPanel{
	BufferedImage revolver, wrench, candlestick, dagger, logo;
	
	public MainMenuScreenDrawingPanel() {
		try {
			logo 		= ImageIO.read(this.getClass().getResource("clogo.png"));
			
			revolver 	= ImageIO.read(this.getClass().getResource("revolver.png"));
			candlestick = ImageIO.read(this.getClass().getResource("candlestick.jpg"));
			dagger 		= ImageIO.read(this.getClass().getResource("dagger.png"));
			wrench		= ImageIO.read(this.getClass().getResource("wrench.png"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(1.0f, 0.75f, 0.0f));
		g.fillRect(0, 0, getWidth()+5, getHeight());
		
		g.drawImage(revolver, 0, 0, getWidth()/2, getHeight()/2-16, this);
		g.drawImage(dagger, getWidth()/2, 0, getWidth()/2, getHeight()/2-16, this);
		g.drawImage(candlestick, 0, getHeight()/2-16, getWidth()/2, getHeight()/2-16, this);
		g.drawImage(wrench, getWidth()/2, getHeight()/2-16, getWidth()/2, getHeight()/2-16, this);
		
		
		g.drawImage(logo, getWidth()/4, getHeight()/3, getWidth()/2, getHeight()/5, this);
		
		g.setColor(Color.BLACK);
		g.drawString("Click to Start", getWidth()/3+20, getHeight()-50);
	}
	

}
