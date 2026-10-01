package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class VariableTest {

    @Test
    void testEval() {
        assertEquals(10, new Variable("x").eval("x = 10"));
    }

    @Test
    void testEvalMultiLetter() {
        assertEquals(5, new Variable("name").eval("name = 5"));
    }

    @Test
    void testEvalVariables() {
        assertEquals(13, new Variable("y").eval("x = 10; y = 13"));
    }

    @Test
    void testDerivativeByItself() {
        Expression d = new Variable("x").derivative("x");
        assertEquals(1, d.eval(""));
    }

    @Test
    void testDerivativeByAnother() {
        Expression d = new Variable("x").derivative("y");
        assertEquals(0, d.eval(""));
    }

    @Test
    void testEvalUndefinedThrows() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Variable("x").eval("y = 10")
        );
    }
}