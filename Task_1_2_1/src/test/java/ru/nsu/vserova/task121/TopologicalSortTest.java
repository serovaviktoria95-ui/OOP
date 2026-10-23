package ru.nsu.vserova.task121;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class TopologicalSortTest {

    @Test
    void sortCorrectOrderTest() {
        Graph<String> g = new AdjacencyList<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addEdge("A", "B");
        g.addEdge("B", "C");

        TopologicalSort sorter = new TopologicalSort();
        List<String> result = sorter.sort(g);

        assertEquals(3, result.size());
        assertTrue(result.indexOf("A") < result.indexOf("B"));
        assertTrue(result.indexOf("B") < result.indexOf("C"));
    }

    @Test
    void sortCycleThrowsTest() {
        Graph<String> g = new AdjacencyList<>();
        g.addVertex("X");
        g.addVertex("Y");
        g.addEdge("X", "Y");
        g.addEdge("Y", "X");

        TopologicalSort sorter = new TopologicalSort();
        assertThrows(GraphException.class, () -> sorter.sort(g));
    }
}