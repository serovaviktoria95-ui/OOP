package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubTest {

    @Test
    void testEval() {
        assertEquals(7, new Sub(new Number(10), new Variable("x")).eval("x = 3"));
    }

    @Test
    void testDerivative() {
        assertEquals(1, new Sub(new Variable("x"), new Number(1)).derivative("x").eval(""));
    }
}