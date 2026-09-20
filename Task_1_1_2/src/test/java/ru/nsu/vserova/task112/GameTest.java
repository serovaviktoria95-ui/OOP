package ru.nsu.vserova.task112;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameTest {

    @Test
    void gameCanBeCreated() {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    void playCanBeCompletedWithoutErrors() {
        String input = "0\n0\n";   // 0 — остановиться, 0 — не играть ещё
        InputStream original = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try {
            Game game = new Game();
            assertDoesNotThrow(game::play);
        } finally {
            System.setIn(original);
        }
    }

    @Test
    void playTwoRounds() {
        String input = "0\n1\n0\n0\n";   // 1-й: остановиться, играть ещё; 2-й: остановиться, не играть
        InputStream original = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try {
            Game game = new Game();
            assertDoesNotThrow(game::play);
        } finally {
            System.setIn(original);
        }
    }

    @Test
    void playWithGamerTakingCard() {
        String input = "1\n0\n0\n";   // взять карту, остановиться, не играть ещё
        InputStream original = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try {
            Game game = new Game();
            assertDoesNotThrow(game::play);
        } finally {
            System.setIn(original);
        }
    }
}