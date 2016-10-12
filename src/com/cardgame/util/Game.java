package com.cardgame.util;

import java.util.ArrayList;
import java.util.Collections;

import com.cardgame.obj.Card;
import com.cardgame.obj.Deck;
import com.cardgame.obj.GameType;
import com.cardgame.obj.Player;

public class Game {
	private GameType gameType;
	private ArrayList<Card> cardsOnDesk = new ArrayList<Card>();
	private ArrayList<Card> cardsOnDeck = new ArrayList<Card>();
	private ArrayList<Player> players = new ArrayList<Player>();

	private Integer numOfPlayers = 0;
	private Integer numOfDecks = 0;
	private Integer numOfCardsOnDeskBeforeStart = 0;
	private Integer numOfCardsEachDeal = 0;

	public Game(GameType gameType, Integer numOfPlayers, Integer numOfDecks) {
		this.gameType = gameType;	
		this.numOfPlayers = numOfPlayers;
		this.numOfDecks = numOfDecks; 
		
		switch(gameType)
		{
		case PISTI:  
			numOfCardsOnDeskBeforeStart = 4;
			numOfCardsEachDeal = 4;
			break;
		}
	}
	
	public void createDeck() {
		cardsOnDeck = new ArrayList<Card>();
		for(int num = 1; num <= numOfDecks; num++) {
			Deck temp = new Deck(gameType);
			cardsOnDeck.addAll(temp.getCards());
		}
		Collections.shuffle(cardsOnDeck);
	}

	public void createPlayers() {
		players = new ArrayList<Player>();
		for(int num = 1; num <= numOfPlayers; num++) {
			Player temp = new Player(this, String.valueOf(num), num==1?false:true);
			players.add(temp);
		}		
	}

	public void startGame() {
		cardsOnDesk = new ArrayList<Card>();
		createDeck();		
		createPlayers();
		dealCardOnDesk();
		dealCardToPlayers();
	}

	private void dealCardOnDesk() {
		for(int i = 0; i < numOfCardsOnDeskBeforeStart; i++) {
			cardsOnDesk.add(cardsOnDeck.get(i));
		}

		for(int i = 0; i < numOfCardsOnDeskBeforeStart; i++) {
			cardsOnDeck.remove(0);
		}
	}
	
	private void dealCardToPlayers() {
		for(Player p: players) {
			for(int i = 0; i < numOfCardsEachDeal; i++) {
				p.getCardOnHand().add(cardsOnDeck.get(i));
			}
			
			for(int i = 0; i < numOfCardsEachDeal; i++) {
				cardsOnDeck.remove(0);
			}			
		}		
	}
	
	public ArrayList<Card> getCardsOnDesk() {
		return cardsOnDesk;
	}

	public ArrayList<Card> getCardsOnDeck() {
		return cardsOnDeck;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setNumOfPlayers(Integer numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public void setNumOfDecks(Integer numOfDecks) {
		this.numOfDecks = numOfDecks;
	}

}
