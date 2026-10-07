package ru.nsu.vserova.task113;

import java.util.Map;

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
     * Возвращает имя переменной.
     */
    @Override
    public String toString() {
        return name;
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
        } else {
            return new Number(0);
        }
    }

    /**
     * Ищет значение переменной в таблице имя=значение.
     */
    @Override
    protected int eval(Map<String, Integer> vars) {
        if (!vars.containsKey(name)) {
            throw new IllegalArgumentException("Переменная не задана: " + name);
        }
        return vars.get(name);
    }
}
