package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    void dealCardFrom(Deck deck) {
        cards.add(deck.draw());
    }

    void displayFirstCard() {
        System.out.print(ansi().eraseScreen().cursor(1, 1));
        System.out.println("Dealer has: ");
        System.out.println(cards.get(0).display()); // first card is Face Up
    }

    private int value() {
        int handValue = cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce() && handValue <= 11) {
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

    boolean isBust() {
        return value() > 21;
    }

    boolean beats(Hand other) {
        return other.value() < value();
    }

    boolean pushes(Hand other) {
        return other.value() == value();
    }

    boolean isBeneathThreshold() {
        return value() <= 16;
    }

    void displayHand() {
        System.out.println(cards.stream()
                                .map(Card::display)
                                .collect(Collectors.joining(
                                        ansi().cursorUp(6).cursorRight(1).toString())));
    }

    void displayValue() {
        System.out.println(" (" + value() + ")");
    }

    public boolean hasValueOf(int i) {
        return i == value();
    }
}