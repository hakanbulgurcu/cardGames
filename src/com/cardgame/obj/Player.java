package com.cardgame.obj;

import java.util.ArrayList;

import com.cardgame.util.Game;

public class Player {
	private ArrayList<Card> cardOnHand = new ArrayList<Card>();
	private ArrayList<Card> cardsTaken = new ArrayList<Card>();
	private String name;
	private Boolean isComputer = true;
	private Game game;
	private Integer pisti = 0;
	private Integer score = 0;
	
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
	
	public void dealCardToDesk() {
		Card card = decideCardToPlay();
		Integer numOfCardOnDesk = game.getCardsOnDesk().size();
		Card topDesk = null;
		System.out.println(this.getName() + " player " + card.getSuit().getValue() + card.getRank().getValue() + " Score: " + this.getScore() + " piþti: " + pisti);
		
		if(numOfCardOnDesk != 0)
			topDesk = game.getCardsOnDesk().get(numOfCardOnDesk - 1);
		
		cardOnHand.remove(card);
		
		if(topDesk != null && card.getRank() == topDesk.getRank()) {
			if(numOfCardOnDesk == 1) {
				pisti++;
				this.setScore(this.getScore() + 10);
			}
			
			game.getCardsOnDesk().add(card);
			cardsTaken.addAll(game.getCardsOnDesk());
			this.setScore(this.getScore() + totalScoreOfTaken(game.getCardsOnDesk()));
			game.getCardsOnDesk().clear();
			game.setLastPlayerTaken(this);
		} else if (card.getRank() == Rank.JACK){
			game.getCardsOnDesk().add(card);
			cardsTaken.addAll(game.getCardsOnDesk());
			this.setScore(this.getScore() + totalScoreOfTaken(game.getCardsOnDesk()));
			game.getCardsOnDesk().clear();
			game.setLastPlayerTaken(this);			
		} else {
			game.getCardsOnDesk().add(card);			
		}		
	}
	
	public Integer totalScoreOfTaken(ArrayList<Card> cards) {
		Integer score = 0;
		for(Card c: cards) {
			score += c.getValue();
		}
		
		return score;	
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
