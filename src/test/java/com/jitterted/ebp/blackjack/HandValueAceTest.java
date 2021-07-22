package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private Suit DUMMY_SUIT = Suit.HEARTS;

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        List<Card> cards = List.of(new Card(DUMMY_SUIT, "A"),
                                   new Card(DUMMY_SUIT, "5"));

        Hand hand = new Hand(cards);
        assertThat(hand.hasValueOf(11+5)).isTrue();
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        List<Card> cards = List.of(new Card(DUMMY_SUIT, "A"),
                                   new Card(DUMMY_SUIT, "8"),
                                   new Card(DUMMY_SUIT, "3"));

        Hand hand = new Hand(cards);
        assertThat(hand.hasValueOf(1 + 8 + 3)).isTrue();
    }
    @Test
    public void handWithAcePlus10OrFaceCardTotals21() throws Exception {
        List<Card> cards = List.of(new Card(DUMMY_SUIT, "K"),
                                   new Card(DUMMY_SUIT, "A"));

        Hand hand = new Hand(cards);
        hand.displayValue();
        assertThat(hand.hasValueOf(11+10)).isTrue();
    }
    @Test
    public void handWithAcePlusCardsValue12Totals13() throws Exception {
        List<Card> cards = List.of(new Card(DUMMY_SUIT, "A"),
                                   new Card(DUMMY_SUIT, "8"),
                                   new Card(DUMMY_SUIT, "4"));

        Hand hand = new Hand(cards);
        assertThat(hand.hasValueOf(1+8+4)).isTrue();
    }
}
