package com.cardgame.obj;

import java.util.ArrayList;

import com.cardgame.util.Game;

public class Player {
	private ArrayList<Card> cardOnHand = new ArrayList<Card>();
	private ArrayList<Card> cardsTaken = new ArrayList<Card>();
	private String name;
	private Boolean isComputer;
	private Game game;
	
	public Player(Game game, String name, Boolean isComputer){
		this.game = game;
		this.name = name;				
		this.isComputer = isComputer;
	}
	
	public ArrayList<Card> getCardsTaken() {
		return cardsTaken;
	}

	public void setCardsTaken(ArrayList<Card> cardsTaken) {
		this.cardsTaken = cardsTaken;
	}

	public String getName() {
		return name;
	}

	public Boolean getIsComputer() {
		return isComputer;
	}

	public ArrayList<Card> getCardOnHand() {
		return cardOnHand;
	}

	public void setCardOnHand(ArrayList<Card> cardOnHand) {
		this.cardOnHand = cardOnHand;
	}
	
	public Integer calculateScore() {
		Integer score = 0;
		for(Card c: cardsTaken) {
			score += c.getValue();
		}
		
		return score;	
	}
	
	public Card decideCardToPlay() {
		if(cardOnHand.size() > 0)
		{
			Card onDesk = null;
			
			if(game.getCardsOnDesk().size() > 0)
				onDesk = game.getCardsOnDesk().get(game.getCardsOnDesk().size() - 1);
	
			if(cardOnHand.contains(onDesk))
				return onDesk;
			else
			{
				for(Card t: cardOnHand) {
					if (t.getRank() == Rank.JACK)
						return t;
				}
			}
			
			return cardOnHand.get(0);	
		}
		else
			return null;				
	}

}
