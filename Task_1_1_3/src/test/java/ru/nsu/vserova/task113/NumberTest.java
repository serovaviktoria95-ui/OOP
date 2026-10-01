package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void testEvalPositive() {
        assertEquals(5, new Number(5).eval(""));
    }

    @Test
    void testEvalZero() {
        assertEquals(0, new Number(0).eval(""));
    }

    @Test
    void testEvalNegative() {
        assertEquals(-3, new Number(-3).eval(""));
    }

    @Test
    void testEvalIgnoresAssignments() {
        assertEquals(7, new Number(7).eval("x = 10; y = 13"));
    }

    @Test
    void testDerivativeIsZero() {
        assertEquals(0, new Number(42).derivative("x").eval(""));
    }

    @Test
    void testDerivativeByAnyVarIsZero() {
        assertEquals(0, new Number(5).derivative("y").eval(""));
        assertEquals(0, new Number(5).derivative("x").eval(""));
    }

    @Test
    void testDerivativeIsNewObject() {
        Number n = new Number(5);
        assertNotSame(n, n.derivative("x"));
    }
}