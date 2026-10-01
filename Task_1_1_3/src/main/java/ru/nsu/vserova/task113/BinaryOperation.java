package ru.nsu.vserova.task113;

/**
 * Промежуточный класс м/у Expression и Add, Div, Mul, Sub.
 *
 * <p>
 *     Нужен для того, чтобы не переписывать один и тот же код.
 *     Однако нельзя внести в Expression, тк эта часть не нужна потомкам Number и Variable.
 * </p>
 */
public abstract class BinaryOperation extends Expression {
    protected final Expression left;
    protected final Expression right;

    /**
     * Бинарная операция с двумя операндами.
     *
     * @param left левый операнд.
     * @param right правый операнд.
     */
    protected BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Возвращает символ операции, который используется при печати.
     *
     * @return символ операции в виде строки
     */
    protected abstract String symbol();

    /**
     * Печатает выражение в консоль.
     */
    @Override
    public void print() {
        System.out.print('(');
        left.print();
        System.out.print(symbol());
        right.print();
        System.out.print(')');
    }
}
