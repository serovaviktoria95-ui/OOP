package ru.nsu.vserova.task131;

import java.nio.file.Path;

/** Вспомогательный класс для тестов.
 * Запускается в JVM с ограниченной памятью.
 */
public final class WorkerMain {
    void main(String[] args) throws Exception {
        Path file = Path.of(args[0]);
        String pattern = args[1];

        var hits = SubstringSearcher.find(file, pattern);
        System.out.println("SUCCESS_FOUND_" + hits.size());
    }
}