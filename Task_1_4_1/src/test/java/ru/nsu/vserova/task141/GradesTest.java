package ru.nsu.vserova.task141;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GradesTest {

    @Test
    void testGetValue() {
        assertEquals(5, Grades.EXCELLENT.getValue());
        assertEquals(4, Grades.GOOD.getValue());
        assertEquals(3, Grades.SATISFIED.getValue());
        assertEquals(2, Grades.UNSATISFIED.getValue());

        assertNull(Grades.PASSED.getValue());
        assertNull(Grades.NOT_PASSED.getValue());
    }

    @Test
    void testIsNumeric() {
        assertTrue(Grades.EXCELLENT.isNumeric());
        assertTrue(Grades.GOOD.isNumeric());
        assertTrue(Grades.SATISFIED.isNumeric());
        assertTrue(Grades.UNSATISFIED.isNumeric());

        assertFalse(Grades.PASSED.isNumeric());
        assertFalse(Grades.NOT_PASSED.isNumeric());
    }
}