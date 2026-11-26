package ru.nsu.vserova.task141;

import java.util.Scanner;

/** Заполнение зачетки в консоли. */
public class Main {
    /** Запуск программы. */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Электронная зачетная книжка");

        System.out.println("Выберите основу обучения:");
        System.out.println("1. Бюджет");
        System.out.println("2. Платное обучение");

        int financial = scanner.nextInt();
        FinancialType financialType;

        if (financial == 1) {
            financialType = FinancialType.BUDGET;
        } else if (financial == 2) {
            financialType = FinancialType.PAID;
        } else {
            System.out.println("Неизвестная команда");
            scanner.close();
            return;
        }

        GradeBook gradeBook = new GradeBook(financialType);

        System.out.println("Введите номер текущего семестра:");
        gradeBook.setCurrentSemester(scanner.nextInt());

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("0. Выход");
            System.out.println("1. Добавить семестр");
            System.out.println("2. Посчитать средний балл");
            System.out.println("3. Проверить возможность перевода на бюджет");
            System.out.println("4. Проверить возможность получения красного диплома");
            System.out.println("5. Проверить возможность получать повышенную стипендию");

            switch (scanner.nextInt()) {
                case 0:
                    System.out.println("До свидания!");
                    scanner.close();
                    return;

                case 1:
                    addSemester(scanner, gradeBook);
                    break;

                case 2:
                    System.out.printf("Средний балл: %.2f%n", gradeBook.averageGrade());
                    break;

                case 3:
                    printResult(gradeBook.canChangeFinancialType());
                    break;

                case 4:
                    printResult(gradeBook.canGetHonorDiploma());
                    break;

                case 5:
                    printResult(gradeBook.canGetIncreasedScholarship());
                    break;

                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }

    /** Добавить семестр в зачетную книжку. */
    private static void addSemester(Scanner scanner, GradeBook gradeBook) {
        System.out.println("Введите номер семестра:");
        int num = scanner.nextInt();

        Semester semester = new Semester(num);

        while (true) {
            System.out.println("Добавить аттестацию? (да/нет)");

            if (!scanner.next().equalsIgnoreCase("да")) {
                break;
            }

            addRecord(scanner, semester);
        }

        System.out.println("Семестр завершен? (да/нет)");

        semester.setCompleted(
                scanner.next().equalsIgnoreCase("да"));

        gradeBook.addSemester(semester);

        System.out.println("Семестр успешно добавлен.");
    }

    /** Добавить запись об аттестации в семестр. */
    private static void addRecord(Scanner scanner, Semester semester) {
        System.out.println("Выберите тип аттестации:");
        System.out.println("1. Экзамен");
        System.out.println("2. Зачет");
        System.out.println("3. Дифференцированный зачет");
        System.out.println("4. Курсовая работа");
        System.out.println("5. Выпускная квалификационная работа");

        ExamType examType;

        switch (scanner.nextInt()) {
            case 1:
                examType = ExamType.EXAM;
                break;

            case 2:
                examType = ExamType.TEST;
                break;

            case 3:
                examType = ExamType.DIFFERENTIATED_TEST;
                break;

            case 4:
                examType = ExamType.COURSE_WORK;
                break;

            case 5:
                examType = ExamType.QUALIFYING_WORK;
                break;

            default:
                System.out.println("Неверный тип аттестации.");
                return;
        }

        Grades grade;

        if (examType == ExamType.TEST) {
            System.out.println("Выберите результат зачета:");
            System.out.println("1. Зачтено");
            System.out.println("0. Не зачтено");
            System.out.println("-1. Зачет еще не сдан");

            switch (scanner.nextInt()) {
                case 1:
                    grade = Grades.PASSED;
                    break;

                case 0:
                    grade = Grades.NOT_PASSED;
                    break;

                case -1:
                    grade = null;
                    break;

                default:
                    System.out.println("Неверный результат зачета.");
                    return;
            }

        } else {
            System.out.println("Выберите оценку:");
            System.out.println("5. Отлично");
            System.out.println("4. Хорошо");
            System.out.println("3. Удовлетворительно");
            System.out.println("2. Неудовлетворительно");
            System.out.println("-1. Оценка еще не получена");

            switch (scanner.nextInt()) {
                case 5:
                    grade = Grades.EXCELLENT;
                    break;

                case 4:
                    grade = Grades.GOOD;
                    break;

                case 3:
                    grade = Grades.SATISFIED;
                    break;

                case 2:
                    grade = Grades.UNSATISFIED;
                    break;

                case -1:
                    grade = null;
                    break;

                default:
                    System.out.println("Неверная оценка.");
                    return;
            }
        }

        boolean finalAssessment = false;

        if (examType != ExamType.TEST) {
            System.out.println("Аттестация итоговая? (да/нет)");

            finalAssessment = scanner.next().equalsIgnoreCase("да");
        }

        GradeRecord record = new GradeRecord(examType, grade, finalAssessment);

        semester.addRecord(record);

        System.out.println("Аттестация успешно добавлена.");
    }

    /** Вывести результат проверки возможности. */
    private static void printResult(boolean result) {
        if (result) {
            System.out.println("Да, возможно.");
        } else {
            System.out.println("Нет, невозможно.");
        }
    }
}