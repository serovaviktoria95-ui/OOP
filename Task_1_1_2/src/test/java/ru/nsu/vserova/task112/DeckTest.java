package ru.nsu.vserova.task112;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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