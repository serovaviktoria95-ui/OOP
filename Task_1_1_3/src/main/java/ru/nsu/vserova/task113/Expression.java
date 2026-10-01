package ru.nsu.vserova.task113;

/**
 * Абстрактный класс для выражений.
 */
public abstract class Expression {
    public abstract void print();

    public abstract Expression derivative(String var);

    public abstract int eval(String expr);

    /**
     * Печать в консоль.
     */
    public void println() {
        print();
        System.out.println();
    }
}
