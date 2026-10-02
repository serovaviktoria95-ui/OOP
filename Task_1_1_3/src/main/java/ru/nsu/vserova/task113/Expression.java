package ru.nsu.vserova.task113;

/**
 * Абстрактный класс для выражений.
 */
public abstract class Expression {

    public abstract Expression derivative(String var);

    public abstract int eval(String expr);

    /**
     * Печать в консоль.
     */
    public final void print() {
        System.out.print(this);
    }

    /** Печатает выражение и переводит строку. */
    public final void println() {
        System.out.println(this);
    }

    /**
     * Возвращает строковое представление выражения.
     */
    @Override
    public abstract String toString();
}
