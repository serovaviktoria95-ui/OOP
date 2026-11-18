package ru.nsu.vserova.task131;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubstringSearcherTest {
    @TempDir
    Path tmp;

    @Test
    void findsAllOccurrences() throws IOException {
        Path f = tmp.resolve("a.txt");
        Files.writeString(f, "abcabcabc", StandardCharsets.UTF_8);
        assertEquals(List.of(0L, 3L, 6L), SubstringSearcher.find(f, "abc"));
    }

    @Test
    void findsOverlappingOccurrences() throws IOException {
        Path f = tmp.resolve("a.txt");
        Files.writeString(f, "aaaa", StandardCharsets.UTF_8);
        assertEquals(List.of(0L, 1L, 2L), SubstringSearcher.find(f, "aa"));
    }

    @Test
    void noMatchReturnsEmptyList() throws IOException {
        Path f = tmp.resolve("a.txt");
        Files.writeString(f, "hello", StandardCharsets.UTF_8);
        assertEquals(List.of(), SubstringSearcher.find(f, "абв"));
    }

    @Test
    void fileLargerThanMemory() throws Exception {
        Path bigFile = tmp.resolve("big_utf8.txt");
        long chars = 100000000L;
        DataGenerator.generate(bigFile, chars, "abcd", 42L);

        String pattern = "Unique pattern";
        try (var wr = Files.newBufferedWriter(bigFile, StandardCharsets.UTF_8,
                java.nio.file.StandardOpenOption.APPEND)) {
            wr.write(pattern);
        }

        // формируем команду для запуска дочерней JVM с лимитом памяти 64 мб
        // файл ~250МБ > кучи (64МБ)
        String javaBin = Path.of(System.getProperty("java.home"), "bin", "java").toString();
        String classPath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder(
                javaBin,
                "-Xmx64m", // 64 мб
                "-cp", classPath,
                "ru.nsu.vserova.task131.WorkerMain",
                bigFile.toAbsolutePath().toString(),
                pattern
        );

        pb.redirectErrorStream(true);
        Process process = pb.start();

        String output = new String(process.getInputStream().readAllBytes(),
                StandardCharsets.UTF_8);
        int exitCode = process.waitFor();

        assertEquals(0, exitCode, "OutOfMemoryError:" + output);
        assertTrue(output.contains("SUCCESS_FOUND_1"), "Pattern was not found: " + output);

        Files.deleteIfExists(bigFile);
    }
}