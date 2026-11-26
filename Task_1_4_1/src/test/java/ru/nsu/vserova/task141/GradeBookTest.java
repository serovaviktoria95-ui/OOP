package ru.nsu.vserova.task141;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GradeBookTest {

    @Test
    void testAverageGrade() {
        GradeBook book = new GradeBook(FinancialType.BUDGET);
        Semester semester = new Semester(1);

        semester.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.EXCELLENT, true));
        semester.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.GOOD, true));
        semester.addRecord(new GradeRecord(
                ExamType.TEST, Grades.PASSED, true));
        semester.addRecord(new GradeRecord(
                ExamType.EXAM, null, true));

        book.addSemester(semester);

        assertEquals(4.5, book.averageGrade(), 0.001);
    }

    @Test
    void testCanChangeFinancialType() {
        GradeBook book = new GradeBook(FinancialType.PAID);

        Semester first = new Semester(1);
        first.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.GOOD, true));
        first.setCompleted(true);

        Semester second = new Semester(2);
        second.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.EXCELLENT, true));
        second.setCompleted(true);

        book.addSemester(first);
        book.addSemester(second);
        book.setCurrentSemester(3);

        assertTrue(book.canChangeFinancialType());
    }

    @Test
    void testCanGetHonorDiploma() {
        GradeBook book = new GradeBook(FinancialType.BUDGET);
        Semester semester = new Semester(8);

        semester.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.EXCELLENT, true));
        semester.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.EXCELLENT, true));
        semester.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.GOOD, true));
        semester.addRecord(new GradeRecord(
                ExamType.QUALIFYING_WORK, Grades.EXCELLENT, true));
        semester.addRecord(new GradeRecord(
                ExamType.TEST, Grades.PASSED, true));

        book.addSemester(semester);
        book.setCurrentSemester(8);

        assertTrue(book.canGetHonorDiploma());
    }

    @Test
    void testHonorDiplomaWithSatisfiedGrade() {
        GradeBook book = new GradeBook(FinancialType.BUDGET);
        Semester semester = new Semester(1);

        semester.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.SATISFIED, true));

        book.addSemester(semester);

        assertFalse(book.canGetHonorDiploma());
    }

    @Test
    void testHonorDiplomaForecast() {
        final GradeBook book = new GradeBook(FinancialType.BUDGET);

        Semester first = new Semester(1);
        first.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.EXCELLENT, true));
        first.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.GOOD, true));

        Semester second = new Semester(2);
        second.addRecord(new GradeRecord(
                ExamType.EXAM, null, true));

        Semester eighth = new Semester(8);
        eighth.addRecord(new GradeRecord(
                ExamType.QUALIFYING_WORK, null, true));

        book.addSemester(first);
        book.addSemester(second);
        book.addSemester(eighth);

        assertTrue(book.canGetHonorDiploma());
    }

    @Test
    void testCanGetIncreasedScholarship() {
        GradeBook book = new GradeBook(FinancialType.BUDGET);
        Semester semester = new Semester(1);

        semester.addRecord(new GradeRecord(
                ExamType.EXAM, Grades.EXCELLENT, true));
        semester.addRecord(new GradeRecord(
                ExamType.TEST, Grades.PASSED, true));
        semester.setCompleted(true);

        book.addSemester(semester);
        book.addSemester(new Semester(2));
        book.setCurrentSemester(2);

        assertTrue(book.canGetIncreasedScholarship());
    }
}