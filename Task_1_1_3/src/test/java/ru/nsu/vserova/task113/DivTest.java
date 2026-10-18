package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DivTest {

    @Test
    void testEval() {
        assertEquals(5, new Div(new Number(10), new Variable("x")).eval("x = 2"));
    }

    @Test
    void testDerivative() {
        assertEquals(-2, new Div(new Number(2),
                new Variable("x")).derivative("x").eval("x = 1"));
    }

    @Test
    void testDivisionByZeroThrows() {
        assertThrows(ArithmeticException.class,
                () -> new Div(new Number(5), new Number(0)).eval(""));
    }
}