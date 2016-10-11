package com.cardgame.obj;

public enum GameType {
    BLACKJACK("BJ"), PISTI("PT");

    private String abbr;

    private GameType(String abbr) {
    	this.abbr = abbr;
    }
    
    public String getValue() {
    	return abbr;
    }    
}
