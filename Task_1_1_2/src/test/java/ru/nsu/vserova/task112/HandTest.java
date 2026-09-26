package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class HandTest {

    @Test
    void queenAndTwo() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Spades, Rank.Queen));
        hand.addCard(new Card(Suit.Spades, Rank.Two));
        assertEquals(12, hand.getScore());
    }

    @Test
    void threeAndFive() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Hearts, Rank.Three));
        hand.addCard(new Card(Suit.Spades, Rank.Five));
        assertEquals(8, hand.getScore());
    }

    @Test
    void twoAces() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Spades, Rank.Ace));
        hand.addCard(new Card(Suit.Hearts, Rank.Ace));
        assertEquals(12, hand.getScore());
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

    @Test
    void blackJackFalse() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Spades, Rank.Seven));
        hand.addCard(new Card(Suit.Hearts, Rank.Seven));
        hand.addCard(new Card(Suit.Diamonds, Rank.Seven));
        assertEquals(21, hand.getScore());
        assertFalse(hand.blackJack());
    }

    @Test
    void getFirstAndSecondCard() {
        Hand hand = new Hand();
        Card first = new Card(Suit.Spades, Rank.Queen);
        Card second = new Card(Suit.Hearts, Rank.Three);
        hand.addCard(first);
        hand.addCard(second);
        assertEquals(first, hand.getFirstCard());
        assertEquals(second, hand.getSecondCard());
    }

    @Test
    void toStringCorrect() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Spades, Rank.Queen));
        hand.addCard(new Card(Suit.Hearts, Rank.Three));
        assertTrue(hand.toString().contains("13"));
    }


}