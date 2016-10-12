package com.cardgame.obj;

public enum GameType {
    PISTI("PÝÞTÝ");

    private String desc;

    private GameType(String desc) {
    	this.desc = desc;
    }
    
    public String getValue() {
    	return desc;
    }    
}
