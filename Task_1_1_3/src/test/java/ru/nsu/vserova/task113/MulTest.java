package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MulTest {

    @Test
    void testEvalTwoNumbers() {
        assertEquals(12, new Mul(new Number(4), new Number(3)).eval(""));
    }

    @Test
    void testEvalNumberAndVariable() {
        assertEquals(20, new Mul(new Number(2), new Variable("x")).eval("x = 10"));
    }

    @Test
    void testEvalTwoVariables() {
        assertEquals(30, new Mul(new Variable("x"), new Variable("y")).eval("x = 5; y = 6"));
    }

    @Test
    void testEvalNegative() {
        assertEquals(-6, new Mul(new Number(-2), new Number(3)).eval(""));
    }

    @Test
    void testDerivativeNumbers() {
        assertEquals(0, new Mul(new Number(2), new Number(3)).derivative("x").eval(""));
    }
}