package ru.nsu.vserova.task121;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VertexIDTest {

    @Test
    void addAndIdTest() {
        VertexID<String> idx = new VertexID<>();
        int i = idx.add("A");
        assertEquals(0, i);
        assertEquals(0, idx.id("A"));
    }

    @Test
    void removeTest() {
        VertexID<String> idx = new VertexID<>();
        idx.add("A");
        idx.add("B");
        idx.remove("A");
        assertEquals(1, idx.size());
        assertEquals(0, idx.id("B")); // B сдвинулся на 0
    }

    @Test
    void nameTest() {
        VertexID<Integer> idx = new VertexID<>();
        idx.add(100);
        assertEquals(100, idx.name(0));
    }

    @Test
    void missingIdThrowsTest() {
        VertexID<String> idx = new VertexID<>();
        assertThrows(GraphException.class, () -> idx.id("X"));
    }
}