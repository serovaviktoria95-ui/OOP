package ru.nsu.vserova.task141;

/** Запись об отдельной аттестации студента. */
public class GradeRecord {
    private final ExamType exam;
    private Grades grade;
    private final boolean finalAssessment;

    /** Создать запись об аттестации студента. */
    public GradeRecord(ExamType exam, Grades grade, boolean finalAssessment) {
        this.exam = exam;
        this.grade = grade;
        this.finalAssessment = finalAssessment;
    }

    /** Тип экзамена. */
    public ExamType getExamType() {
        return exam;
    }

    /** Оценка за экзамен. */
    public Grades getGrade() {
        return grade;
    }

    /** Является ли аттестация итоговой. */
    public boolean isFinalAssessment() {
        return finalAssessment;
    }

    /** Добавить оценку. */
    public void setGrade(Grades grade) {
        this.grade = grade;
    }
}