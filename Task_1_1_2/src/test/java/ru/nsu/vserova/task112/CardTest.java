package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void queenValue() {
        Card card = new Card(Suit.Spades, Rank.Queen);
        assertEquals(10, card.getValue());
    }

    @Test
    void kingValue() {
        Card card = new Card(Suit.Spades, Rank.King);
        assertEquals(10, card.getValue());
    }

    @Test
    void jackValue() {
        Card card = new Card(Suit.Hearts, Rank.Jack);
        assertEquals(10, card.getValue());
    }

    @Test
    void aceValue() {
        Card card = new Card(Suit.Clubs, Rank.Ace);
        assertEquals(11, card.getValue());
    }

    @Test
    void getSuitCorrect() {
        Card card = new Card(Suit.Spades, Rank.Queen);
        assertEquals(Suit.Spades, card.getSuit());
    }

    @Test
    void getRankReturnsCorrect() {
        Card card = new Card(Suit.Spades, Rank.Queen);
        assertEquals(Rank.Queen, card.getRank());
    }
}