package ru.nsu.vserova.task113;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinaryOperationTest {

    @Test
    void testConstructorStoresOperandsAdd() {
        assertEquals(3, new Add(new Number(1), new Number(2)).eval(""));
    }

    @Test
    void testConstructorStoresOperandsSub() {
        assertEquals(2, new Sub(new Number(5), new Number(3)).eval(""));
    }

    @Test
    void testConstructorStoresOperandsMul() {
        assertEquals(12, new Mul(new Number(4), new Number(3)).eval(""));
    }

    @Test
    void testConstructorStoresOperandsDiv() {
        assertEquals(3, new Div(new Number(12), new Number(4)).eval(""));
    }
}