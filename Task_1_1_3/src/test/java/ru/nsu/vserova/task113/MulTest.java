package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MulTest {

    @Test
    void testEvalTwoNumbers() {
        Expression e = new Mul(new Number(3), new Number(1));
        assertEquals(3, e.eval(""));
    }

    @Test
    void testEvalNumberAndVariable() {
        Expression e = new Mul(new Number(10), new Variable("x"));
        assertEquals(30, e.eval("x = 3"));
    }

    @Test
    void testEvalTwoVariables() {
        Expression e = new Mul(new Variable("x"), new Variable("y"));
        assertEquals(130, e.eval("x = 13; y = 10"));
    }
}