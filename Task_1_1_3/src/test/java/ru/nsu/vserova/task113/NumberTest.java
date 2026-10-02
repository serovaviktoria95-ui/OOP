package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void testToString() {
        assertEquals("42", new Number(42).toString());
    }

    @Test
    void testEval() {
        assertEquals(42, new Number(42).eval(""));
    }

    @Test
    void testDerivative() {
        assertEquals(0, new Number(42).derivative("x").eval(""));
    }
}