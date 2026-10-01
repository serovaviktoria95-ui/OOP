package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddTest {

    @Test
    void testEvalTwoNumbers() {
        assertEquals(3, new Add(new Number(1), new Number(2)).eval(""));
    }

    @Test
    void testEvalNumberAndVariable() {
        assertEquals(13, new Add(new Number(3), new Variable("x")).eval("x = 10"));
    }

    @Test
    void testEvalTwoVariables() {
        assertEquals(23, new Add(new Variable("x"), new Variable("y")).eval("x = 10; y = 13"));
    }

    @Test
    void testDerivativeNumbers() {
        assertEquals(0, new Add(new Number(1), new Number(2)).derivative("x").eval(""));
    }
}