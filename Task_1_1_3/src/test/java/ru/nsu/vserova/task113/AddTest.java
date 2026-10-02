package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddTest {

    @Test
    void testEval() {
        assertEquals(13, new Add(new Number(3), new Variable("x")).eval("x = 10"));
    }

    @Test
    void testDerivative() {
        assertEquals(1, new Add(new Number(3), new Variable("x")).derivative("x").eval(""));
    }
}