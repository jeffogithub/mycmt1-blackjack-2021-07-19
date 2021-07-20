package com.jitterted.ebp.blackjack;

public enum Suit {
    HEARTS("♥"),
    SPADES("♠"),
    CLUBS("♣"),
    DIAMONDS("♦");


    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    //GOAL:MAYBE get rid of this
    public String getSymbol() {
        return symbol;
    }

    public static Suit fromSymbol(String symbol) {
        for(Suit suit : Suit.values()) {
            if (suit.symbol.equals(symbol)) {
                return suit;
            }
        }
        return Suit.CLUBS;
    }
}
