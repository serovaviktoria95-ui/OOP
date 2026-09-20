package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SuitTest {

    @Test
    void heartsRussianName() {
        assertEquals("Черви", Suit.Hearts.getRussianName());
    }

    @Test
    void diamondsRussianName() {
        assertEquals("Бубны", Suit.Diamonds.getRussianName());
    }

    @Test
    void clubsRussianName() {
        assertEquals("Крести", Suit.Clubs.getRussianName());
    }

    @Test
    void spadesRussianName() {
        assertEquals("Пики", Suit.Spades.getRussianName());
    }
}