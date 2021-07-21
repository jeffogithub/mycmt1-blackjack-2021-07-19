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

    @Override
    public String toString() {
        return symbol;
    }

    boolean isRed() {
        return "♥♦".contains(symbol);
    }
}
