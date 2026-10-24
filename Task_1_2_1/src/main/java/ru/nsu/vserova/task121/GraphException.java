package ru.nsu.vserova.task121;

/**
 *  Класс для ошибок логики.
 */
public class GraphException extends RuntimeException {

    /** Создать исключение с сообщением. */
    public GraphException(String message) {
        super(message);
    }
}
