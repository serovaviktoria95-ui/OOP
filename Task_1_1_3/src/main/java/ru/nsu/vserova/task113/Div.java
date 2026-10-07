package ru.nsu.vserova.task113;

import java.util.Map;

/**
 * Деление одного операнда на другой.
 */
public class Div extends BinaryOperation {
    /**
     * Создаёт операцию деленияодного операнда на другой.
     *
     * @param left делимое
     * @param right делитель
     */
    public Div(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Возвращает символ операции деления.
     */
    @Override
    protected String symbol() {
        return "/";
    }

    /**
     * (u/v)' = (u'v - v'u)/(v^2).
     */
    @Override
    public Expression derivative(String var) {
        return new Div(
                new Sub(
                        new Mul(left.derivative(var), right),
                        new Mul(left, right.derivative(var))
                ),
                new Mul(right, right)
        );
    }

    /**
     * Вычисляет значение деления при заданном означивании переменных.
     */
    @Override
    protected int eval(Map<String, Integer> vars) {
        if (right.eval(vars) == 0) {
            throw new ArithmeticException("На 0 делить нельзя!");
        }
        return left.eval(vars) / right.eval(vars);
    }
}
