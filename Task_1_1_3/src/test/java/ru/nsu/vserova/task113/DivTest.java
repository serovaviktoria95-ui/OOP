package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DivTest {

    @Test
    void testEvalTwoNumbers() {
        assertEquals(3, new Div(new Number(12), new Number(4)).eval(""));
    }

    @Test
    void testEvalNumberAndVariable() {
        assertEquals(5, new Div(new Number(10), new Variable("x")).eval("x = 2"));
    }

    @Test
    void testEvalTwoVariables() {
        assertEquals(4, new Div(new Variable("x"), new Variable("y")).eval("x = 12; y = 3"));
    }

    @Test
    void testEvalIntegerDivision() {
        assertEquals(2, new Div(new Number(5), new Number(2)).eval(""));
    }

    @Test
    void testDivisionByComputedZero() {
        Expression e = new Div(new Number(5), new Sub(new Number(3), new Number(3)));
        assertThrows(ArithmeticException.class, () -> e.eval(""));
    }

    @Test
    void testDivisionByVariableZero() {
        Expression e = new Div(new Number(5), new Variable("x"));
        assertThrows(ArithmeticException.class, () -> e.eval("x = 0"));
    }

    @Test
    void testDerivativeNumbers() {
        assertEquals(0, new Div(new Number(6), new Number(2)).derivative("x").eval(""));
    }
}