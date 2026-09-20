package ru.nsu.vserova.task112;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void numberValues() {
        assertEquals(2, Rank.Two.getValue());
        assertEquals(3, Rank.Three.getValue());
        assertEquals(4, Rank.Four.getValue());
        assertEquals(5, Rank.Five.getValue());
        assertEquals(6, Rank.Six.getValue());
        assertEquals(7, Rank.Seven.getValue());
        assertEquals(8, Rank.Eight.getValue());
        assertEquals(9, Rank.Nine.getValue());
        assertEquals(10, Rank.Ten.getValue());
    }

    @Test
    void peopleValues() {
        assertEquals(10, Rank.Jack.getValue());
        assertEquals(10, Rank.Queen.getValue());
        assertEquals(10, Rank.King.getValue());
        assertEquals(11, Rank.Ace.getValue());
    }

    @Test
    void russianNames() {
        assertEquals("Двойка", Rank.Two.getRussianName());
        assertEquals("Тройка", Rank.Three.getRussianName());
        assertEquals("Четвёрка", Rank.Four.getRussianName());
        assertEquals("Пятёрка", Rank.Five.getRussianName());
        assertEquals("Шестёрка", Rank.Six.getRussianName());
        assertEquals("Семёрка", Rank.Seven.getRussianName());
        assertEquals("Восьмёрка", Rank.Eight.getRussianName());
        assertEquals("Девятка", Rank.Nine.getRussianName());
        assertEquals("Десятка", Rank.Ten.getRussianName());
        assertEquals("Валет", Rank.Jack.getRussianName());
        assertEquals("Дама", Rank.Queen.getRussianName());
        assertEquals("Король", Rank.King.getRussianName());
        assertEquals("Туз", Rank.Ace.getRussianName());
    }
}