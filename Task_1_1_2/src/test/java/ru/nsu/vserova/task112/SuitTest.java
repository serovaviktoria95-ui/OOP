package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;
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