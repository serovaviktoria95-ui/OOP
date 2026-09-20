package ru.nsu.vserova.task112;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void gameCreated() {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    void blackJackCorrect() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Spades, Rank.Ace));
        hand.addCard(new Card(Suit.Hearts, Rank.King));
        assertTrue(hand.blackJack());
    }

    @Test
    void tooMuchCorrect() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Hearts, Rank.King));
        hand.addCard(new Card(Suit.Hearts, Rank.Queen));
        hand.addCard(new Card(Suit.Hearts, Rank.Two));
        assertTrue(hand.tooMuch());
    }

    @Test
    void notTooMuch21() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.Hearts, Rank.Ace));
        hand.addCard(new Card(Suit.Hearts, Rank.King));
        assertFalse(hand.tooMuch());
    }

    @Test
    void dealerWinsCorrect() {
        Hand gamer = new Hand();
        gamer.addCard(new Card(Suit.Hearts, Rank.Ten));
        gamer.addCard(new Card(Suit.Hearts, Rank.Eight));

        Hand dealer = new Hand();
        dealer.addCard(new Card(Suit.Spades, Rank.Ten));
        dealer.addCard(new Card(Suit.Spades, Rank.Nine));

        assertTrue(dealer.score() > gamer.score());
    }

    @Test
    void dealerPullsUnder17() {
        Dealer dealer = new Dealer();
        dealer.getHand().addCard(new Card(Suit.Spades, Rank.Ten));
        dealer.getHand().addCard(new Card(Suit.Spades, Rank.Two));
        assertTrue(dealer.dealerPulls());
    }

    @Test
    void dealerDoesntPullWhen17() {
        Dealer dealer = new Dealer();
        dealer.getHand().addCard(new Card(Suit.Spades, Rank.Queen));
        dealer.getHand().addCard(new Card(Suit.Diamonds, Rank.Seven));
        assertFalse(dealer.dealerPulls());
    }
}