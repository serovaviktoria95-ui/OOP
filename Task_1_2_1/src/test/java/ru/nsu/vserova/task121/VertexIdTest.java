package ru.nsu.vserova.task121;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VertexIdTest {

    @Test
    void addAndIdTest() {
        VertexId<String> idx = new VertexId<>();
        int i = idx.add("A");
        assertEquals(0, i);
        assertEquals(0, idx.id("A"));
    }

    @Test
    void removeTest() {
        VertexId<String> idx = new VertexId<>();
        idx.add("A");
        idx.add("B");
        idx.remove("A");
        assertEquals(1, idx.size());
        assertEquals(0, idx.id("B")); // B сдвинулся на 0
    }

    @Test
    void nameTest() {
        VertexId<Integer> idx = new VertexId<>();
        idx.add(100);
        assertEquals(100, idx.name(0));
    }

    @Test
    void missingIdThrowsTest() {
        VertexId<String> idx = new VertexId<>();
        assertThrows(GraphException.class, () -> idx.id("X"));
    }
}