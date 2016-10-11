package com.cardgame.util;

import java.util.ArrayList;

import com.cardgame.obj.Card;
import com.cardgame.obj.GameType;

public class Game {
	private GameType gameType;
	private ArrayList<Card> cardsOnDesk = new ArrayList<Card>();

	private Integer numOfPlayers = 0;
	private Integer numOfCardsOnDeskBeforeStart = 0;
	private Integer numOfCardsOnHand = 0;
	private Integer numOfDecks = 0;
	
	public Game(GameType gameType) {
		this.gameType = gameType;
		
	}
	
	
}
