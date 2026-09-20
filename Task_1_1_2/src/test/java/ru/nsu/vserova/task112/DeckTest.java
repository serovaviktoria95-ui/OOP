package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void newDeckHas52Cards() {
        Deck deck = new Deck();
        assertEquals(52, deck.size());
    }

    @Test
    void pullCorrect() {
        Deck deck = new Deck();
        deck.pull();
        assertEquals(51, deck.size());
    }
}