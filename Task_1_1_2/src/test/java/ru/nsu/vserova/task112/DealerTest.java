package ru.nsu.vserova.task112;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    void getHandCorrect() {
        Gamer gamer = new Gamer();

        assertNotNull(gamer.getHand());
        assertEquals(0, gamer.getHand().getCards().size());
    }

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
}