package ru.nsu.vserova.task121;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Список смежности.
 */
class AdjacencyListTest {

    @Test
    void addVertexTest() {
        Graph<String> g = new AdjacencyList<>();
        g.addVertex("A");
        assertEquals(1, g.vertexCnt());
    }

    @Test
    void addEdgeTest() {
        Graph<String> g = new AdjacencyList<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        assertEquals(1, g.getEdges().size());
    }

    @Test
    void removeVertexShiftsIndicesTest() {
        Graph<String> g = new AdjacencyList<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.removeVertex("B");
        assertEquals(1, g.getNeighbours("A").size());
        assertTrue(g.getNeighbours("A").contains("C"));
    }

    @Test
    void removeEdgeTest() {
        Graph<String> g = new AdjacencyList<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        g.removeEdge("A", "B");
        assertTrue(g.getNeighbours("A").isEmpty());
    }

    @Test
    void equalsDifferentRepresentationsTest() {
        Graph<String> m = new AdjacencyMatrix<>();
        Graph<String> l = new AdjacencyList<>();
        m.addVertex("A");
        l.addVertex("A");
        assertEquals(m, l);
    }
}