package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ExpressionTest {

    @Test
    void testAllAreExpressions() {
        Expression[] exprs = {
            new Number(1),
            new Variable("x"),
            new Add(new Number(1), new Number(2)),
            new Sub(new Number(5), new Number(3)),
            new Mul(new Number(2), new Number(3)),
            new Div(new Number(6), new Number(2)),
        };
        for (Expression e : exprs) {
            assertNotNull(e);
            assertDoesNotThrow(() -> e.eval("x = 1"));
            assertDoesNotThrow(() -> e.derivative("x"));
        }
    }
}