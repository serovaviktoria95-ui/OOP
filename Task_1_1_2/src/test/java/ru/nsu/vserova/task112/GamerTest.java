package ru.nsu.vserova.task112;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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