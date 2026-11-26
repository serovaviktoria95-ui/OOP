package ru.nsu.vserova.task141;

/** Оценка за экзамен. */
public enum Grades {
    EXCELLENT(5),
    GOOD(4),
    SATISFIED(3),
    UNSATISFIED(2),
    PASSED(null),
    NOT_PASSED(null);

    private final Integer value;

    /** Создать оценку с числовым значением. */
    Grades(Integer value) {
        this.value = value;
    }

    /** Возвращает цифровое значение оценки. */
    public Integer getValue() {
        return value;
    }

    /** Является ли оценка числом. */
    public boolean isNumeric() {
        return value != null;
    }
}
