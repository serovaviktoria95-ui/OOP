package ru.nsu.vserova.task112;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamerTest {

    @Test
    void getHandCorrect() {
        Gamer gamer = new Gamer();

        assertNotNull(gamer.getHand());
        assertEquals(0, gamer.getHand().getCards().size());
    }

    @Test
    void getNameCorrect() {
        Gamer gamer = new Gamer();
        assertNull(gamer.getName());
    }
}