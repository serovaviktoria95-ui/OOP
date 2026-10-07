package ru.nsu.vserova.task113;

import java.util.Map;

/**
 * Класс для констант (числа внутри выражения).
 */
public class Number extends Expression {
    private final int value;

    /**
     * Создает константу с заданным значением.
     */
    public Number(int value) {
        this.value = value;
    }

    /**
     * Возвращает строковое представление константы.
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    /**
     * Производная константы = 0.
     */
    @Override
    public Expression derivative(String var) {
        return new Number(0);
    }

    /**
     * У константы значение - она сама.
     */
    @Override
    protected int eval(Map<String, Integer> vars) {
        return value;
    }
}
