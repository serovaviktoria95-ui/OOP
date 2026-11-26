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

    Grades(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public boolean isNumeric() {
        return value != null;
    }
}
