package com.cardgame.util;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cardgame.obj.Card;
import com.cardgame.obj.GameType;
import com.cardgame.obj.Player;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel; 
	private Game game;
	
	public MainFrame() {
		gui();
		game = new Game(this, GameType.PISTI, 2, 1);
		game.startGame();		
	}
	
	public void gui() {
		setTitle("Ahmet's Game");		
		mainPanel = new JPanel(new BorderLayout());
		setSize(800, 600);				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		add(mainPanel); 
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Integer middleX = this.getWidth() / 2, middleY = this.getHeight() / 2;
		
		if(game.getCardsOnDesk().size() > 0)
		{
			for(Card c : game.getCardsOnDesk()) {
			    g2d.drawImage(c.getImage(), middleX, middleY, 60, 87, this);
			    middleX += 10;
			    middleY += 2;
			}
		}
		
		for(Player p : game.getPlayers()) {
			for(Card c : p.getCardOnHand()) {
				
			}
			
			for(Card c : p.getCardsTaken()) {
				
			}			
		}
		
//		g.clearRect(0, 0, getWidth(), getHeight()); //rengi sýfýrlýyor	   
		g.dispose();
	}

}
