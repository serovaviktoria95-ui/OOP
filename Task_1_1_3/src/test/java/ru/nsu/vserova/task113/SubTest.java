package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubTest {

    @Test
    void testEvalTwoNumbers() {
        assertEquals(1, new Sub(new Number(3), new Number(2)).eval(""));
    }

    @Test
    void testEvalNumberAndVariable() {
        assertEquals(7, new Sub(new Number(10), new Variable("x")).eval("x = 3"));
    }

    @Test
    void testEvalTwoVariables() {
        assertEquals(3, new Sub(new Variable("x"), new Variable("y")).eval("x = 13; y = 10"));
    }

    @Test
    void testDerivativeNumbers() {
        assertEquals(0, new Sub(new Number(1), new Number(2)).derivative("x").eval(""));
    }
}