package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void testParseNumberAndVariable() {
        assertEquals("42", new Parser("42").parse().toString());
        assertEquals("x", new Parser("x").parse().toString());
    }

    @Test
    void testParseAllOperations() {
        assertEquals("(1+2)", new Parser("(1+2)").parse().toString());
        assertEquals("(5-3)", new Parser("(5-3)").parse().toString());
        assertEquals("(4*3)", new Parser("(4*3)").parse().toString());
        assertEquals("(12/4)", new Parser("(12/4)").parse().toString());
    }

    @Test
    void testParseExampleFromTask() {
        Expression e = new Parser("(3+(2*x))").parse();
        assertEquals("(3+(2*x))", e.toString());
        assertEquals(23, e.eval("x = 10"));
    }

    @Test
    void testParseNested() {
        assertEquals("((1+2)*3)", new Parser("((1+2)*3)").parse().toString());
        assertEquals("(1+(2*3))", new Parser("(1+(2*3))").parse().toString());
    }

    @Test
    void testParseWithSpaces() {
        assertEquals("(3+(2*x))", new Parser("( 3 + ( 2 * x ) )").parse().toString());
    }

    @Test
    void testErrors() {
        assertThrows(RuntimeException.class, () -> new Parser("").parse());
        assertThrows(RuntimeException.class, () -> new Parser("(1+2").parse());
        assertThrows(RuntimeException.class, () -> new Parser("(1^2)").parse());
    }
}