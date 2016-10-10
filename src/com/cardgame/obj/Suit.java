package com.cardgame.obj;

public enum Suit {
    SPADES("S"), HEARTS("H"), DIAMONDS("D"), CLUBS("C");

    private String abbr;

    private Suit(String abbr) {
    	this.abbr = abbr;
    }
    
    public String getValue() {
    	return abbr;
    }    

}
