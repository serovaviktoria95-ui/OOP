package ru.nsu.vserova.task131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/** Потоковый поиск всех вхождений строки. */
public class SubstringSearcher {
    /** Находит индексы вхождения подстроки. */
    public static List<Long> find(Path file, String pattern) throws IOException {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("Pattern must be not empty");
        }
        int[] p = pattern.codePoints().toArray();
        int len = p.length;

        int[] window = new int[len];
        int k = 0;
        long start = 0;

        List<Long> res = new ArrayList<>();

        try (Reader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(file), StandardCharsets.UTF_8))
        ) {
            int ch;
            while ((ch = reader.read()) != -1) {
                if (k < len) {
                    window[k++] = ch;
                } else {
                    System.arraycopy(window, 1, window, 0, len - 1);
                    window[len - 1] = ch;
                    start++;
                }
                if (k == len && Arrays.equals(window, p)) {
                    res.add(start);
                }
            }
        }
        return res.isEmpty() ? List.of() : List.copyOf(res);
    }
}