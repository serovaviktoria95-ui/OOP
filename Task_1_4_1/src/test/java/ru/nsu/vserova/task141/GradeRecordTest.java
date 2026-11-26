package ru.nsu.vserova.task141;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class GradeRecordTest {

    @Test
    void testGoodAssessment() {
        GradeRecord record = new GradeRecord(
                ExamType.EXAM, Grades.GOOD, false);

        assertFalse(record.isFinalAssessment());
    }

    @Test
    void testFutureAssessment() {
        GradeRecord record = new GradeRecord(
                ExamType.EXAM, null, true);

        assertNull(record.getGrade());
    }

    @Test
    void testSetGrade() {
        GradeRecord record = new GradeRecord(
                ExamType.EXAM, null, true);

        record.setGrade(Grades.EXCELLENT);

        assertEquals(Grades.EXCELLENT, record.getGrade());
    }

    @Test
    void testChangeGrade() {
        GradeRecord record = new GradeRecord(
                ExamType.EXAM, Grades.GOOD, true);

        record.setGrade(Grades.EXCELLENT);

        assertEquals(Grades.EXCELLENT, record.getGrade());
    }
}