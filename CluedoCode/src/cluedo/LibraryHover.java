package cluedo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LibraryHover extends JPanel{
	private BufferedImage libHover;
	
	public LibraryHover() {

		try {
			libHover = ImageIO.read(this.getClass().getResource("libHover.png"));
		}catch (IOException ex){
			System.out.println("Image not found");
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(libHover, 0, 0, this);
	}
}
