package ru.nsu.vserova.task121;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OperationsTest {

    @Test
    void equalSameGraphsTest() {
        Graph<String> g1 = new AdjacencyMatrix<>();
        Graph<String> g2 = new AdjacencyList<>();
        g1.addVertex("A");
        g2.addVertex("A");
        assertTrue(Operations.equal(g1, g2));
    }

    @Test
    void equalDifferentGraphsTest() {
        Graph<String> g1 = new AdjacencyMatrix<>();
        Graph<String> g2 = new AdjacencyList<>();
        g1.addVertex("A");
        g2.addVertex("B");
        assertFalse(Operations.equal(g1, g2));
    }

    @Test
    void toStringNotEmptyTest() {
        Graph<String> g = new AdjacencyMatrix<>();
        g.addVertex("A");
        String result = Operations.toString(g);
        assertNotNull(result);
        assertTrue(result.contains("A"));
    }
}