package com.cardgame.obj;

public enum GameType {
    PISTI("P��T�");

    private String desc;

    private GameType(String desc) {
    	this.desc = desc;
    }
    
    public String getValue() {
    	return desc;
    }    
}
