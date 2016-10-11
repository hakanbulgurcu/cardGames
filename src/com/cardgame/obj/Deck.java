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
				cards.add(new Card(s, r));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}
