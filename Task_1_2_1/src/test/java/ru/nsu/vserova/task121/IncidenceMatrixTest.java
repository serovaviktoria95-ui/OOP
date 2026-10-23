package ru.nsu.vserova.task121;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncidenceMatrixTest {

    @Test
    void addVertexTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        assertEquals(1, g.vertexCnt());
    }

    @Test
    void addEdgeTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        assertEquals(1, g.getEdges().size());
    }

    @Test
    void removeVertexRemovesEdgesTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.removeVertex("B");
        assertEquals(2, g.vertexCnt());
        assertEquals(0, g.getEdges().size()); // ребра A->B и B->C удалились
    }

    @Test
    void getEdgesTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        assertEquals("A", g.getEdges().get(0).get(0));
        assertEquals("B", g.getEdges().get(0).get(1));
    }
}