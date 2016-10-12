package com.cardgame.obj;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private GameType gameType;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck(GameType gameType) {
		this.gameType = gameType;
		initalizeDeck();
		shuffle();
	}
	
	public void initalizeDeck() {
		for (Suit s: Suit.values()) {
			for (Rank r: Rank.values()) {
				Card card = new Card(s, r);
				assignValueToCard(card);
				cards.add(card);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void assignValueToCard(Card card) {
		switch(gameType)
		{
		case PISTI:
			if(card.getSuit() == Suit.CLUBS && card.getRank() == Rank.TWO)
				card.setValue(2);
			else if(card.getSuit() == Suit.DIAMONDS && card.getRank() == Rank.TEN)
				card.setValue(3);
			else if(card.getRank() == Rank.ACE || card.getRank() == Rank.JACK)
				card.setValue(1);
			break;
		}
	}
}
