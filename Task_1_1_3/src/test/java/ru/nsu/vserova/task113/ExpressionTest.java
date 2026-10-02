package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class ExpressionTest {

    private String capturePrint(Expression e) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        try {
            e.print();
            return buffer.toString();
        } finally {
            System.setOut(original);
        }
    }

    private String capturePrintln(Expression e) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        try {
            e.println();
            return buffer.toString();
        } finally {
            System.setOut(original);
        }
    }

    @Test
    void testPrint() {
        assertEquals("(1+2)",
                    capturePrint(new Add(new Number(1), new Number(2))));
    }

    @Test
    void testPrintln() {
        assertEquals("(1+2)" + System.lineSeparator(),
                    capturePrintln(new Add(new Number(1), new Number(2))));
    }
}