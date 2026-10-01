package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void testParseNumber() {
        assertEquals(42, new Parser("42").parse().eval(""));
    }

    @Test
    void testParseVariable() {
        assertEquals(5, new Parser("x").parse().eval("x = 5"));
    }

    @Test
    void testParseAdd() {
        assertEquals(3, new Parser("(1+2)").parse().eval(""));
    }

    @Test
    void testParseSub() {
        assertEquals(2, new Parser("(5-3)").parse().eval(""));
    }

    @Test
    void testParseMul() {
        assertEquals(12, new Parser("(4*3)").parse().eval(""));
    }

    @Test
    void testParseDiv() {
        assertEquals(3, new Parser("(12/4)").parse().eval(""));
    }

    @Test
    void testParseExampleFromTask() {
        assertEquals(23, new Parser("(3+(2*x))").parse().eval("x = 10"));
    }

    @Test
    void testParseNestedLeft() {
        assertEquals(9, new Parser("((1+2)*3)").parse().eval(""));
    }

    @Test
    void testParseNestedRight() {
        assertEquals(7, new Parser("(1+(2*3))").parse().eval(""));
    }

    @Test
    void testParseDeeplyNested() {
        assertEquals(21, new Parser("((1+2)*(3+4))").parse().eval(""));
    }

    @Test
    void testParseWithSpaces() {
        assertEquals(23, new Parser("( 3 + ( 2 * x ) )").parse().eval("x = 10"));
    }

    @Test
    void testDerivativeOfParsed() {
        assertEquals(2, new Parser("(3+(2*x))").parse().derivative("x").eval("x = 5"));
    }

    @Test
    void testEmptyThrows() {
        assertThrows(RuntimeException.class, () -> new Parser("").parse());
    }

    @Test
    void testUnknownOperatorThrows() {
        assertThrows(RuntimeException.class, () -> new Parser("(1^2)").parse());
    }
}