package com.cardgame.obj;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
	private Suit suit = null;
	private Rank rank = null;
	private Integer value = 0;
	private Boolean isJoker = false;	
	private Image image = null;	
	private final String packagePath = "com/cardgame/img/";	 		 
	private JLabel label = new JLabel();
	private final Integer width = 120, height = 144;
	
	public Card (Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;	
		image = new ImageIcon(Card.class.getClassLoader().getResource(packagePath + suit.getValue() + rank.getValue() + ".png")).getImage();
		label.setIcon(new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_DEFAULT)));	
	}
	
	public Card () {
		this.isJoker = true;
		image = new ImageIcon(Card.class.getClassLoader().getResource(packagePath + "Joker.png")).getImage();
		label.setIcon(new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_DEFAULT)));	
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

	public JLabel getLabel() {
		return label;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

}
