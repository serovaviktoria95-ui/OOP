package ru.nsu.vserova.task113;

public class Parser {
    private final String str;
    private int pos = 0;

    /**
     * Убирает пробелы.
     */
    public Parser(String input) {
        this.str = input.replace(" ", "");
    }

    /**
     * Разбирает всю строку целиком.
     */
    public Expression parse() {
        Expression e = parseExpr();
        return e;
    }

    /**
     * Проверяет, является ли символ цифрой.
     */
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * Проверяет, является ли символ буквой.
     */
    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private Expression parseExpr() {
        if (str.charAt(pos) == '(') {
            pos++;                              // пропускаем '('
            Expression left = parseExpr();      // левое подвыражение
            char operation = str.charAt(pos++); // символ операции
            Expression right = parseExpr();     // правое подвыражение
            pos++;                              // пропускаем ')'
            return switch (operation) {
                case '+' -> new Add(left, right);
                case '-' -> new Sub(left, right);
                case '*' -> new Mul(left, right);
                case '/' -> new Div(left, right);
                default  -> throw new RuntimeException("Неизвестный оператор: " + operation);
            };
        }

        // иначе — токен число или переменная
        int start = pos;
        while (pos < str.length() && (isDigit(str.charAt(pos)) || isLetter(str.charAt(pos)))) {
            pos++;
        }
        String token = str.substring(start, pos);

        if (isDigit(token.charAt(0))) {
            return new Number(Integer.parseInt(token));
        }
        return new Variable(token);
    }
}