package cluedo;

import javax.swing.*;
import java.awt.*;

public class HowToPlay {
	private JFrame frame;
	private JPanel panel1;
	private JLabel line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11;
	private JLabel[] labels = {line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11};;
	private String[] lines = {"You are a detective solving a murder mystery case.",
								"Click on one of the difficulties to start.",
								"Clicking on the labels of the rooms allows you to enter them,",
								"providing you with clues for the room, weapon, and people.",
								"You may enter the rooms more than once to refresh the clues.",
								"Pressing the \"Detective's Sheet\" allows you to check the clues you have gathered so far.",
								"Pressing \"Solve Mystery\" allows you to select your answers. You may only skip during odd-numbered rounds.",
								"Prompting the wrong answers on one of the three categories will eliminate a person card.",
								"Carefully deduce the clues to win.",
								"You will only lose if you are left with the culprit.",
								"Best of luck, Detective!"};
	
	public HowToPlay() {
		
		frame = new JFrame("How To Play");
		frame.setSize(800, 640);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		panel1 = new JPanel();
		panel1.setBounds(0, 0, frame.getWidth()-15, frame.getHeight()-15);
		panel1.setLayout(new GridLayout(11, 1));
		
		panel1.setBackground(new Color(0.96f, 0.96f, 0.86f));
		
		line1 = new JLabel(lines[0]);
		line2 = new JLabel(lines[1]);
		line3 = new JLabel(lines[2]);
		line4 = new JLabel(lines[3]);
		line5 = new JLabel(lines[4]);
		line6 = new JLabel(lines[5]);
		line7 = new JLabel(lines[6]);
		line8 = new JLabel(lines[7]);
		line9 = new JLabel(lines[8]);
		line10 = new JLabel(lines[9]);
		line11 = new JLabel(lines[10]);
		
		panel1.add(line1);
		panel1.add(line2);
		panel1.add(line3);
		panel1.add(line4);
		panel1.add(line5);
		panel1.add(line6);
		panel1.add(line7);
		panel1.add(line8);
		panel1.add(line9);
		panel1.add(line10);
		panel1.add(line11);
		
		frame.add(panel1);
		
		frame.setVisible(true);
	}
	
	
	
}
