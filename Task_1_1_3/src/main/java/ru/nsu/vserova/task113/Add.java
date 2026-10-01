package ru.nsu.vserova.task113;

/**
 * Сложение 2х выражений.
 */
public class Add extends BinaryOperation {

    /**
     * Создаёт операцию сложения двух выражений.
     *
     * @param left  левое слагаемое
     * @param right правое слагаемое
     */
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Возвращает символ операции сложения.
     */
    @Override
    protected String symbol() { return "+"; }

    /**
     * (u + v)' = u' + v'
     */
    @Override
    public Expression derivative(String var) {
        return new Add(left.derivative(var), right.derivative(var));
    }

    /**
     * Вычисляет значение суммы при заданном означивании переменных.
     */
    @Override
    public int eval(String a) {
        return left.eval(a) + right.eval(a);
    }
}
