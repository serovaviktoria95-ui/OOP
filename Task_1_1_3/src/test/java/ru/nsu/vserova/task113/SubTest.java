package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubTest {

    @Test
    void testEvalTwoNumbers() {
        Expression e = new Sub(new Number(3), new Number(1));
        assertEquals(2, e.eval(""));
    }

    @Test
    void testEvalNumberAndVariable() {
        Expression e = new Sub(new Number(10), new Variable("x"));
        assertEquals(7, e.eval("x = 3"));
    }

    @Test
    void testEvalTwoVariables() {
        Expression e = new Sub(new Variable("x"), new Variable("y"));
        assertEquals(3, e.eval("x = 13; y = 10"));
    }
}