package com.cardgame.obj;

import javax.swing.ImageIcon;

public class Card {
	private Suit suit = null;
	private Rank rank = null;
	private Boolean isJoker = false;	
	private ImageIcon image = null;	
	private String packagePath = "com/cardgame/img/";		 		 
	
	public Card (Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		image = new ImageIcon(Card.class.getClassLoader().getResource(packagePath + suit.getValue() + rank.getValue() + ".png"));
	}
	
	public Card () {
		this.isJoker = true;
		image = new ImageIcon(Card.class.getClassLoader().getResource(packagePath + "Joker.png"));
	}	

}
