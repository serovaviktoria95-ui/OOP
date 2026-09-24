package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DealerTest {

    @Test
    void getNameCorrect() {
        Gamer gamer = new Gamer();
        assertNull(gamer.getName());
    }

    @Test
    void dealerPullsCorrectUnder17() {
        Dealer dealer = new Dealer();

        dealer.getHand().addCard(new Card(Suit.Hearts, Rank.Ten));
        dealer.getHand().addCard(new Card(Suit.Diamonds, Rank.Five));

        assertTrue(dealer.dealerPulls());
    }

    @Test
    void dealerPullsCorrectAbove17() {
        Dealer dealer = new Dealer();

        dealer.getHand().addCard(new Card(Suit.Hearts, Rank.Ten));
        dealer.getHand().addCard(new Card(Suit.Diamonds, Rank.Eight));

        assertFalse(dealer.dealerPulls());
    }

    @Test
    void openHiddenCardCorrect() {
        Dealer dealer = new Dealer();
        Card first = new Card(Suit.Spades, Rank.Ace);
        Card second = new Card(Suit.Hearts, Rank.King);
        dealer.takeCard(first);
        dealer.takeCard(second);
        assertEquals(second, dealer.openHiddenCard());
    }

    @Test
    void makeTurnTakesCardsUntil17() {
        Dealer dealer = new Dealer();
        dealer.takeCard(new Card(Suit.Spades, Rank.Ten));
        dealer.takeCard(new Card(Suit.Hearts, Rank.Five));
        Deck deck = new Deck();
        List<Card> taken = dealer.makeTurn(deck);
        assertFalse(taken.isEmpty());
        assertTrue(dealer.getHand().getScore() >= 17);
    }
}