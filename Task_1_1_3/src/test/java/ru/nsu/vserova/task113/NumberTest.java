package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void testEval() {
        assertEquals(5, new Number(5).eval(""));
    }

    @Test
    void testDerivativeIsZero() {
        Expression d = new Number(42).derivative("x");
        assertEquals(0, d.eval(""));
    }
}