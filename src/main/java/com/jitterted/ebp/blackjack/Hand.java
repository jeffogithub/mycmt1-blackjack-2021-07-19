package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    //GOAL: Get rid of this.
    public List<Card> getCards() {
        return cards;
    }

    void dealCardFrom(Deck deck) {
        cards.add(deck.draw());
    }

    void displayFirstCard() {
        System.out.print(ansi().eraseScreen().cursor(1, 1));
        System.out.println("Dealer has: ");
        System.out.println(cards.get(0).display()); // first card is Face Up
    }

    public int value() {
        int handValue = cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce() && handValue < 11) {
            handValue += 10;
        }

        return handValue;
    }

    private boolean hasAce() {
        // does the hand contain at least 1 Ace?
        return cards
                .stream()
                .anyMatch(card -> card.rankValue() == 1);
    }
}