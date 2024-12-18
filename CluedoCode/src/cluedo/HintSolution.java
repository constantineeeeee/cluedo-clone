package cluedo;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;

public class HintSolution implements MouseListener{
	private String title = "Hint/Solution";
	JFrame hintFrame = new JFrame();
	JButton back;
	Border line = BorderFactory.createLineBorder(Color.BLACK);
	
	HintSolutionDrawingPanel hsDPanel;
	
	
	public HintSolution(String title) {
		this.title = title;
		initializeUI();
	}

	public void initializeUI() {
		
		hintFrame.setTitle(title);
		hintFrame.setSize(500, 500);
		hintFrame.setLocationRelativeTo(null);
		hintFrame.setLayout(null);
		
		hsDPanel = new HintSolutionDrawingPanel();
		hsDPanel.setBounds(0, 0, 500, 500);		
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 325, 80, 50);
		leftPanel.setLayout(new GridLayout(2, 1));
		
		JLabel roomLabel = new JLabel("ROOM: ");
		JLabel weaponLabel = new JLabel("WEAPON: ");
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(80, 325, 450, 50);
		rightPanel.setLayout(new GridLayout(2, 1));
		
		JLabel room = new JLabel(GameRun.generate.getRoomName(GameRun.generate.getChosenRoom()));
		JLabel weapon = new JLabel(GameRun.generate.getWeaponName(GameRun.generate.getChosenWeapon()));
		
		room.setBounds((500/2)-50, 0, 50, 50);
		weapon.setBounds((500/2)-50, 0, 50, 50);
		
		rightPanel.add(room);
		rightPanel.add(weapon);
		
		leftPanel.add(roomLabel);
		leftPanel.add(weaponLabel);
		
		roomLabel.setBorder(line);
		weaponLabel.setBorder(line);
		room.setBorder(line);
		weapon.setBorder(line);
		leftPanel.setBorder(line);
		rightPanel.setBorder(line);
		
		back = new JButton("Back");
		back.setBounds(0, 375, 500, 75);
		
		hintFrame.add(rightPanel);
		hintFrame.add(leftPanel);
		hintFrame.add(back);
		hintFrame.add(hsDPanel);
		
		back.addMouseListener(this);
		
		hintFrame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			hintFrame.dispose();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
