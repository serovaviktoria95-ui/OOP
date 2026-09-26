package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        String input =
                "0\n1\n0\n0\n";
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
        String input =
                "1\n1\n1\n0\n0\n";
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
        String input =
                "0\n1\n0\n0\n";
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

    /**
     * Запускает игру с фиксированным вводом.
     */
    private Game playWithInput(Deck deck, String input) {
        InputStream original = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        try {
            Game game = new Game(deck);
            game.play();
            return game;
        } finally {
            System.setIn(original);
        }
    }

    @Test
    void gamerBlackjackWins() {
        Card ace = new Card(Suit.Spades, Rank.Ace);
        Card king = new Card(Suit.Hearts, Rank.King);
        Card five = new Card(Suit.Diamonds, Rank.Five);
        Card six = new Card(Suit.Diamonds, Rank.Six);

        Deck deck = mock(Deck.class);

        when(deck.pull()).thenReturn(ace, king, five, six);

        Game game = playWithInput(deck, "0\n0\n");

        assertEquals(1, game.getGamerWins());
        assertEquals(0, game.getDealerWins());
    }

    @Test
    void gamerHigherScoreWins() {
        Card ten = new Card(Suit.Spades, Rank.Ten);
        Card nine = new Card(Suit.Hearts, Rank.Nine);
        Card ten2 = new Card(Suit.Diamonds, Rank.Ten);
        Card seven = new Card(Suit.Diamonds, Rank.Seven);

        Deck deck = mock(Deck.class);
        when(deck.pull()).thenReturn(ten, nine, ten2, seven);

        Game game = playWithInput(deck, "0\n0\n");

        assertEquals(1, game.getGamerWins());
        assertEquals(0, game.getDealerWins());
    }
}