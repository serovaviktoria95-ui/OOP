package ru.nsu.vserova.task113;

import java.util.Scanner;

/**
 * Точка входа программы.
 */
public class Main {
    /**
     * Запускает демонстрацию работы выражений.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        String input = sc.nextLine();

        Expression e = new Parser(input).parse();
        e.println();

        System.out.print("Переменная для дифференцирования: ");
        String var = sc.nextLine();
        e.derivative(var).println();

        System.out.print("Означивание (например x = 10; y = 13): ");
        String assignments = sc.nextLine();
        System.out.println(e.eval(assignments));
    }
}