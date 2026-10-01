package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddTest {

    @Test
    void testEvalTwoNumbers() {
        Expression e = new Add(new Number(1), new Number(2));
        assertEquals(3, e.eval(""));
    }

    @Test
    void testEvalNumberAndVariable() {
        Expression e = new Add(new Number(3), new Variable("x"));
        assertEquals(13, e.eval("x = 10"));
    }

    @Test
    void testEvalTwoVariables() {
        Expression e = new Add(new Variable("x"), new Variable("y"));
        assertEquals(23, e.eval("x = 10; y = 13"));
    }
}