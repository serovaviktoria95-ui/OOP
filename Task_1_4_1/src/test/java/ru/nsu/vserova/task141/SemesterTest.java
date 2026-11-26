package ru.nsu.vserova.task141;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SemesterTest {

    @Test
    void testAddRecord() {
        Semester semester = new Semester(1);

        GradeRecord record = new GradeRecord(
                ExamType.EXAM, Grades.EXCELLENT, true);

        semester.addRecord(record);

        assertEquals(1, semester.getRecords().size());
        assertEquals(record, semester.getRecords().get(0));
    }

    @Test
    void testSetCompleted() {
        Semester semester = new Semester(1);

        assertFalse(semester.isCompleted());

        semester.setCompleted(true);
        assertTrue(semester.isCompleted());

        semester.setCompleted(false);
        assertFalse(semester.isCompleted());
    }
}