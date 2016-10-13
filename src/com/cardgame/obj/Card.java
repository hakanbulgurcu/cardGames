package com.cardgame.obj;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Card {
	private Suit suit = null;
	private Rank rank = null;
	private Integer value = 0;
	private Boolean isJoker = false;	
	private Image image = null;	
	private final String packagePath = "com/cardgame/img/";	 		 
	
	public Card (Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;	
		image = new ImageIcon(Card.class.getClassLoader().getResource(packagePath + suit.getValue() + rank.getValue() + ".png")).getImage();
	}
	
	public Card () {
		this.isJoker = true;
		image = new ImageIcon(Card.class.getClassLoader().getResource(packagePath + "Joker.png")).getImage();
	}	
		
	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Boolean getIsJoker() {
		return isJoker;
	}

	public Image getImage() {
		return image;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}


}
