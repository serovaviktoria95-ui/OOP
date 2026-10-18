package ru.nsu.vserova.task113;

import java.util.Map;

/**
 * Вычитание одного выражения из другого.
 */
public class Sub extends BinaryOperation {

    /**
     * Создаёт операцию сложения двух выражений.
     *
     * @param left уменьшаемое
     * @param right вычитаемое
     */
    public Sub(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Возвращает символ операции вычитания.
     */
    @Override
    protected String symbol() {
        return "-";
    }

    /**
     * (u - v)' = u' - v'.
     */
    @Override
    public Expression derivative(String var) {
        return new Sub(left.derivative(var), right.derivative(var));
    }

    /**
     * Вычисляет значение разности при заданном означивании переменных.
     */
    @Override
    protected int eval(Map<String, Integer> vars) {
        return left.eval(vars) - right.eval(vars);
    }
}
