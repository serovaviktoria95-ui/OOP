package ru.nsu.vserova.task121;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdjacencyMatrixTest {

    @Test
    void addVertexTest() {
        Graph<String> g = new AdjacencyMatrix<>();
        g.addVertex("A");
        assertEquals(1, g.vertexCnt());
        assertTrue(g.getVertices().contains("A"));
    }

    @Test
    void addEdgeTest() {
        Graph<String> g = new AdjacencyMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        assertEquals(1, g.getEdges().size());
        assertTrue(g.getNeighbours("A").contains("B"));
    }

    @Test
    void removeVertexTest() {
        Graph<String> g = new AdjacencyMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        g.removeVertex("A");
        assertEquals(1, g.vertexCnt());
        assertEquals(0, g.getEdges().size());
    }

    @Test
    void removeEdgeTest() {
        Graph<String> g = new AdjacencyMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        g.removeEdge("A", "B");
        assertEquals(0, g.getEdges().size());
    }

    @Test
    void clearTest() {
        Graph<String> g = new AdjacencyMatrix<>();
        g.addVertex("A");
        g.clear();
        assertEquals(0, g.vertexCnt());
    }

    @Test
    void equalsAndHashCodeTest() {
        Graph<String> g1 = new AdjacencyMatrix<>();
        Graph<String> g2 = new AdjacencyMatrix<>();
        g1.addVertex("A");
        g2.addVertex("A");
        assertEquals(g1, g2);
        assertEquals(g1.hashCode(), g2.hashCode());
    }
}