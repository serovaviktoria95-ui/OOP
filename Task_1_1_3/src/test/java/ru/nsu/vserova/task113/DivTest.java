package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DivTest {

    @Test
    void testEvalTwoNumbers() {
        Expression e = new Div(new Number(6), new Number(2));
        assertEquals(3, e.eval(""));
    }

    @Test
    void testEvalNumberAndVariable() {
        Expression e = new Div(new Number(10), new Variable("x"));
        assertEquals(2, e.eval("x = 5"));
    }

    @Test
    void testEvalTwoVariables() {
        Expression e = new Div(new Variable("x"), new Variable("y"));
        assertEquals(3, e.eval("x = 30; y = 10"));
    }
}