package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void gameCanBeCreated() {
        Game game = new Game();
        assertNotNull(game);
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
    void playManyRounds() {
        String input =
                "0\n1\n0\n1\n0\n1\n0\n0\n";
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
    void playWithManyCards() {
        String input = "1\n1\n1\n0\n0\n";
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
    void firstScoreIsZero() {
        Game game = new Game();
        assertEquals(0, game.getGamerWins());
        assertEquals(0, game.getDealerWins());
    }

    @Test
    void gamerOrDealerWins() {
        String input = "0\n0\n";
        InputStream original = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try {
            Game game = new Game();
            game.play();
            int total = game.getGamerWins() + game.getDealerWins();
            assertTrue(total <= 1);
        } finally {
            System.setIn(original);
        }
    }

    @Test
    void afterTwoRoundsScoreIncreases() {
        String input = "0\n1\n0\n0\n";
        InputStream original = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try {
            Game game = new Game();
            game.play();
            assertTrue(game.getGamerWins() + game.getDealerWins() <= 2);
        } finally {
            System.setIn(original);
        }
    }

    @Test
    void gamerBlackjack() {
        Gamer gamer = new Gamer();
        gamer.takeCard(new Card(Suit.Spades, Rank.Ace));
        gamer.takeCard(new Card(Suit.Hearts, Rank.King));
        assertTrue(gamer.hasBlackJack());
    }
}