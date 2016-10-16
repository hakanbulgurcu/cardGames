package com.cardgame.util;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

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
	private MainFrame frame;
	private Player lastPlayerTaken;
	
	public Game(MainFrame frame, GameType gameType, Integer numOfPlayers, Integer numOfDecks) {
		this.gameType = gameType;	
		this.numOfPlayers = numOfPlayers;
		this.numOfDecks = numOfDecks; 
		this.frame = frame; 
		
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
		run();
	}

	private void dealCardOnDesk() {
		for(int i = 0; i < numOfCardsOnDeskBeforeStart; i++) {
			cardsOnDesk.add(cardsOnDeck.get(i));
		}

		for(int i = 0; i < numOfCardsOnDeskBeforeStart; i++) {
			cardsOnDeck.remove(cardsOnDeck.get(0));
		}
		
	}
	
	private void dealCardToPlayers() {
		for(Player p: players) {
			for(int i = 0; i < numOfCardsEachDeal; i++) {
				p.getCardOnHand().add(cardsOnDeck.get(i));
			}
			
			for(int i = 0; i < numOfCardsEachDeal; i++) {
				if(cardsOnDeck.size() > 1)
					cardsOnDeck.remove(cardsOnDeck.get(0));
				else
					cardsOnDeck = new ArrayList<Card>();
			}
		}		
	}
	
	private void run() {		
		while(cardsOnDeck.size() > 0) {
			dealCardToPlayers();
			while(calculateNumOfCardOnPlayersHand() > 0) {
				for(Player p: players) {
					p.dealCardToDesk();
					p.getScore();
					frame.drawLabels();
				}
			}
		}
		
		//Yerde kalan kartlar en son kart alan oyuncuya aktarýlýyor.
		lastPlayerTaken.getCardsTaken().addAll(cardsOnDesk);
		lastPlayerTaken.setScore(lastPlayerTaken.getScore() + lastPlayerTaken.totalScoreOfTaken(cardsOnDesk));
		cardsOnDesk = new ArrayList<Card>();

		//Elinde en çok kart olan oyuncu belirlenip puanlarý aktarýlýyor.
		Integer maxCard = 0;
		Player temp = null;
		
		for(Player p: players) {
			if(maxCard < p.getCardsTaken().size()) {
				maxCard = p.getCardsTaken().size();
				temp = p;
			}			
		}
		
		temp.setScore(temp.getScore() + 3 * numOfDecks);

		for(Player p: players) {
			System.out.println(p.getName() + "-" + p.getScore());			
		}

		frame.drawLabels();
	}	
	
	private Integer calculateNumOfCardOnPlayersHand() {
		Integer cnt = 0;
		for(Player p: players) {
			cnt += p.getCardOnHand().size();
		}
		
		return cnt;
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

	public void setLastPlayerTaken(Player lastPlayerTaken) {
		this.lastPlayerTaken = lastPlayerTaken;
	}

	public void setCardsOnDesk(ArrayList<Card> cardsOnDesk) {
		this.cardsOnDesk = cardsOnDesk;
	}

	public JFrame getFrame() {
		return frame;
	}
}
