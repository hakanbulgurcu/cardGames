package com.cardgame.obj;

public class Player {
	private Hand hand;
	private String name;
	private Boolean isComputer;
	
	public Player(String name, Boolean isComputer){
		this.name = name;				
		this.isComputer = isComputer;
		hand = new Hand();
	}
	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public Boolean getIsComputer() {
		return isComputer;
	}

}
