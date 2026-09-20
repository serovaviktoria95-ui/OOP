package ru.nsu.vserova.task112;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void queenAndTwo() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Spades, Rank.Queen));
        hand.addCard(new Card(Suit.Spades, Rank.Two));
        assertEquals(12, hand.score());
    }

    @Test
    void threeAndFive() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Hearts, Rank.Three));
        hand.addCard(new Card(Suit.Spades, Rank.Five));
        assertEquals(8, hand.score());
    }

    @Test
    void twoAces() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Spades, Rank.Ace));
        hand.addCard(new Card(Suit.Hearts, Rank.Ace));
        assertEquals(12, hand.score());
    }

    @Test
    void addCardCorrect() {
        Hand hand = new Hand();
        Card card = new Card(Suit.Spades, Rank.Queen);

        hand.addCard(card);

        assertEquals(1, hand.getCards().size());
        assertEquals(card, hand.getCards().get(0));
    }

    @Test
    void tooMuchCorrect() {
        Hand hand = new Hand();

        hand.addCard(new Card(Suit.Spades, Rank.King));
        hand.addCard(new Card(Suit.Hearts, Rank.Queen));
        hand.addCard(new Card(Suit.Clubs, Rank.Two));

        assertTrue(hand.tooMuch());
    }

    @Test
    void blackJackCorrect() {
        Hand hand = new Hand();

        hand.addCard(new Card(Suit.Spades, Rank.Ace));
        hand.addCard(new Card(Suit.Hearts, Rank.King));

        assertTrue(hand.blackJack());
    }
}