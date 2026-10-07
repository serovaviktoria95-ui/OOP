package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class VariableTest {

    @Test
    void testToString() {
        assertEquals("x", new Variable("x").toString());
    }

    @Test
    void testEval() {
        assertEquals(10, new Variable("x").eval("x = 10; y = 13"));
    }

    @Test
    void testDerivativeByItself() {
        assertEquals(1, new Variable("x").derivative("x").eval(""));
    }

    @Test
    void testDerivativeByOther() {
        assertEquals(0, new Variable("x").derivative("y").eval(""));
    }

    @Test
    void testEvalUndefinedThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Variable("x").eval("y = 10"));
    }
}