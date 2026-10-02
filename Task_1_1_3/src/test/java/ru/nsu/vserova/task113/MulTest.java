package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MulTest {

    @Test
    void testEval() {
        assertEquals(20, new Mul(new Number(2), new Variable("x")).eval("x = 10"));
    }

    @Test
    void testDerivative() {
        // (2 * x)' = 2 → при x=5 всё равно 2
        assertEquals(2, new Mul(new Number(2), new Variable("x"))
                .derivative("x")
                .eval("x = 5"));
    }
}