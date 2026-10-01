package ru.nsu.vserova.task113;

/**
 * Класс для переменных (буквы в выражениях).
 */
public class Variable extends Expression {
    private final String name;

    /**
     * Создает переменную с заданным именем.
     */
    public Variable(String name) {
        this.name = name;
    }

    /**
     * Печатается имя переменной.
     */
    public void print() {
        System.out.print(name);
    }

    /**
     * Производная переменной по самой себе = 1.
     * Производная переменной по другой переменной = 0.
     */
    @Override
    public Expression derivative(String var) {
        // Сравниваем содержимое, а не ссылки
        if (name.equals(var)) {
            return new Number(1);
        } else return new Number(0);
    }

    /**
     * Возвращает значение переменной.
     */
    @Override
    public int eval(String expr) {
        for (String pair : expr.split(";")) {
            pair = pair.trim();
            if (pair.isEmpty()) continue;
            String[] p = pair.split("=");
            if (p[0].trim().equals(name)) {
                return Integer.parseInt(p[1].trim());
            }
        }
        throw new IllegalArgumentException("Переменная не задана: " + name);
    }
}
