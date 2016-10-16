package com.cardgame.util;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cardgame.obj.Card;
import com.cardgame.obj.GameType;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel; 
	private Game game;
 	
	public MainFrame() {
		gui();
		game = new Game(this, GameType.PISTI, 4, 1);
		game.startGame();		
	}
	
	public void gui() {
		setTitle("Ahmet's Game");		
		mainPanel = new JPanel(new BorderLayout());
//		setSize(800, 600);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		add(mainPanel); 
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setResizable(false);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	public void drawLabels() {
		Integer onDeskX = this.getWidth() / 3, onDeskY = this.getHeight() / 3, gap = 15;
		Integer p1X = this.getWidth() * 2 / 6, p1Y = this.getHeight() * 5 / 6, 
				p2X = this.getWidth() * 5 / 6, p2Y = this.getHeight() * 2 / 6, 
				p3X = this.getWidth() * 2 / 6, p3Y = 10, 
				p4X = 10, p4Y = this.getHeight() * 2 / 6;
		Integer p1TX = this.getWidth() * 5 / 6, p1TY = this.getHeight() * 5 / 6, 
				p2TX = this.getWidth() * 5 / 6, p2TY = 10, 
				p3TX = 10, p3TY = 10, 
				p4TX = 10, p4TY = this.getHeight() * 5 / 6;
		
		for(int d = 0; d < game.getCardsOnDesk().size(); d++)
		{
			Card c = game.getCardsOnDesk().get(d);
		    c.getLabel().setVisible(true);
		    c.getLabel().setBounds(onDeskX, onDeskY, c.getWidth(), c.getHeight());
		    mainPanel.add(c.getLabel());
		    onDeskX += gap;
		}
		
		for(int p = 0; p < game.getPlayers().size(); p++) {
			Integer pX = 0, pY = 0, pTX = 0, pTY = 0;
			switch(p)
			{
			case 0: pX = p1X; pY = p1Y; pTX = p1TX; pTY = p1TY; break;			
			case 1: pX = p2X; pY = p2Y; pTX = p2TX; pTY = p2TY; break;
			case 2: pX = p3X; pY = p3Y; pTX = p3TX; pTY = p3TY; break;
			case 3: pX = p4X; pY = p4Y; pTX = p4TX; pTY = p4TY; break;				 
			}
			
			for(Card c : game.getPlayers().get(p).getCardOnHand()) {
			    c.getLabel().setVisible(true);
			    c.getLabel().setBounds(pX, pY, c.getWidth(), c.getHeight());
			    mainPanel.add(c.getLabel());				
			    pX += gap;
			}
			
			for(Card c : game.getPlayers().get(p).getCardsTaken()) {
			    c.getLabel().setVisible(true);
			    c.getLabel().setBounds(pTX, pTY, c.getWidth(), c.getHeight());
			    mainPanel.add(c.getLabel());
			    pTX += gap;
			}			
		}
		
	    this.repaint();
	}

}
