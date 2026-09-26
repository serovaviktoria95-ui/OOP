package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class GamerTest {
    @Test
    void getHandCorrect() {
        Gamer gamer = new Gamer();
        assertNotNull(gamer.getHand());
        assertEquals(0, gamer.getHand().getScore());
    }

    @Test
    void getNameCorrect() {
        assertNull(new Gamer().getName());
    }

    @Test
    void takeCardCorrect() {
        Gamer gamer = new Gamer();
        gamer.takeCard(new Card(Suit.Spades, Rank.Ace));
        assertEquals(11, gamer.getHand().getScore());
    }

    @Test
    void hasBlackJackTrue() {
        Gamer gamer = new Gamer();
        gamer.takeCard(new Card(Suit.Spades, Rank.Ace));
        gamer.takeCard(new Card(Suit.Hearts, Rank.King));
        assertTrue(gamer.hasBlackJack());
    }

    @Test
    void hasBlackJackFalse() {
        Gamer gamer = new Gamer();
        gamer.takeCard(new Card(Suit.Spades, Rank.Queen));
        assertFalse(gamer.hasBlackJack());
    }
}