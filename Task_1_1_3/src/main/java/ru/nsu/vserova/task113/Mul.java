package ru.nsu.vserova.task113;

/**
 * Произведение двух операндов.
 */
public class Mul extends BinaryOperation {
    /**
     * Создаёт операцию умножения двух операндов.
     *
     * @param left левый операнд
     * @param right правый операнд
     */
    public Mul(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Возвращает символ операции умножения.
     */
    @Override
    protected String symbol() { return "*"; }

    /**
     * (u * v)' = u'v + v'u
     */
    @Override
    public Expression derivative(String var) {
        return new Add(
                new Mul(left.derivative(var), right),
                new Mul(left, right.derivative(var))
        );
    }

    /**
     * Вычисляет значение произведения при заданном означивании переменных.
     */
    @Override
    public int eval(String a) {
        return left.eval(a) * right.eval(a);
    }
}
