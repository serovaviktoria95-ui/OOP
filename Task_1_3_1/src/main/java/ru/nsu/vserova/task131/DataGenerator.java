package ru.nsu.vserova.task131;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

/** Генератор больших тестовых файлов. */
public class DataGenerator {
    /** Записывает файл случайные символы из указанного алфавита в кодировке UTF8. */
    public static Path generate(Path target, long chars, String alph, long seed) throws IOException {
        if (alph.isEmpty()) {
            throw new IllegalArgumentException("Alphabet must be not empty");
        }

        int[] codes = alph.codePoints().toArray();
        Random rand = new Random(seed);

        try (Writer wr = Files.newBufferedWriter(target, StandardCharsets.UTF_8)) {
            for (long i = 0; i < chars; i++) {
                wr.write(codes[rand.nextInt(codes.length)]);
            }
        }
        return target;
    }
}
