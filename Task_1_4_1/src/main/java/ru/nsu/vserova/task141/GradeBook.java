package ru.nsu.vserova.task141;

import java.util.ArrayList;
import java.util.List;

/** Основной класс работы с зачетной книжкой. */
public class GradeBook {
    private final List<Semester> semesters;
    private final FinancialType financialType;
    private int currentSemester;

    /** Создать пустую зачетную книжку. */
    public GradeBook(FinancialType financialType) {
        this.semesters = new ArrayList<>();
        this.financialType = financialType;
        this.currentSemester = 1;
    }

    /** Добавить новый семестр. */
    public void addSemester(Semester semester) {
        semesters.add(semester);
    }

    /** Установить текущий семестр. */
    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    /** Текущий средний балл за время обучения. */
    public double averageGrade() {
        int sum = 0;
        int cnt = 0;

        for (Semester semester : semesters) {
            for (GradeRecord record : semester.getRecords()) {
                Grades grade = record.getGrade();
                if (grade != null && grade.isNumeric()) {
                    cnt++;
                    sum += grade.getValue();
                }
            }
        }
        if (cnt == 0) {
            return 0;
        }
        return (double) sum / cnt;
    }

    /** Возможность перевода с платной основы на бюджетную. */
    public boolean canChangeFinancialType() {
        if (financialType == FinancialType.BUDGET) {
            return false;
        }

        int cnt = 0;
        for (int i = semesters.size() - 1; i >= 0; i--) {
            Semester semester = semesters.get(i);
            if (!semester.isCompleted()) {
                continue;
            }

            for (GradeRecord record : semester.getRecords()) {
                if (record.getExamType() == ExamType.EXAM) {
                    if (record.getGrade() == Grades.SATISFIED
                            || record.getGrade() == Grades.UNSATISFIED) {
                        return false;
                    }
                }
                if (record.getExamType() == ExamType.DIFFERENTIATED_TEST) {
                    if (record.getGrade() == Grades.UNSATISFIED) {
                        return false;
                    }
                }
            }
            cnt++;

            if (cnt == 2) {
                return true;
            }
        }
        return false;
    }

    /** Возможность получить красный диплом. */
    public boolean canGetHonorDiploma() {
        int cnt = 0;
        int excellent = 0;
        int remaining = 0;
        for (Semester semester : semesters) {
            for (GradeRecord record : semester.getRecords()) {
                Grades grade = record.getGrade();

                if (record.getExamType() == ExamType.TEST || !record.isFinalAssessment()) {
                    continue;
                }

                if (record.getExamType() == ExamType.QUALIFYING_WORK
                        && (grade != Grades.EXCELLENT && grade != null)) {
                    return false;
                }

                if ((record.getExamType() == ExamType.DIFFERENTIATED_TEST
                        || record.getExamType() == ExamType.EXAM)
                        && (grade == Grades.UNSATISFIED
                        || grade == Grades.SATISFIED
                        || grade == Grades.NOT_PASSED)) {
                    return false;
                }

                if (grade == Grades.EXCELLENT) {
                    excellent++;
                }

                if (grade == null) {
                    remaining++;
                }
                cnt++;
            }
        }
        if (cnt == 0) {
            return false;
        }
        return (double) (excellent + remaining) / cnt >= 0.75;
    }

    /** Возможность получения повышенной стипендии. */
    public boolean canGetIncreasedScholarship() {
        if (financialType == FinancialType.PAID) {
            return false;
        }
        for (Semester semester : semesters) {
            if (semester.getNum() != currentSemester - 1) {
                continue;
            }
            if (!semester.isCompleted()) {
                return false;
            }

            for (GradeRecord record : semester.getRecords()) {
                Grades grade = record.getGrade();

                if (grade == Grades.GOOD
                        || grade == Grades.SATISFIED
                        || grade == Grades.UNSATISFIED
                        || grade == Grades.NOT_PASSED) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
