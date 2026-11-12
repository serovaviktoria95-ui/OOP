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
    void findsInLargeGeneratedFile() throws IOException {
        Path f = DataGenerator.generate(
                tmp.resolve("big.txt"), 5000000L, "абвгд ", 42L);

        List<Long> hits = SubstringSearcher.find(f, "абв");
        assertTrue(hits.size() > 0);
        assertTrue(hits.get(0) >= 0);
    }
}