package ru.nsu.vserova.task113;

import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный класс для выражений.
 */
public abstract class Expression {

    public abstract Expression derivative(String var);

    protected abstract int eval(Map<String, Integer> vars);

    public final int eval(String expr) {
        return eval(parseAssignments(expr));
    }

    /**
    * Разбирает строку имя=значение в таблицу значений.
    */
    private Map<String, Integer> parseAssignments(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (String pair : s.split(";")) {
            pair = pair.trim();
            if (pair.isEmpty()) {
                continue;
            }
            String[] p = pair.split("=");
            map.put(p[0].trim(), Integer.parseInt(p[1].trim()));
        }
        return map;
    }

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
