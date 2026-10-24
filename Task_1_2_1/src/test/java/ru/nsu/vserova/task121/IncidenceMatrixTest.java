package ru.nsu.vserova.task121;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class IncidenceMatrixTest {

    @Test
    void addVertexTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        assertEquals(1, g.vertexCnt());
        assertTrue(g.getVertices().contains("A"));
    }

    @Test
    void addDuplicateVertexThrowsTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        assertThrows(GraphException.class, () -> g.addVertex("A"));
    }

    @Test
    void addEdgeTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        assertEquals(1, g.getEdges().size());
        assertTrue(g.getNeighbours("A").contains("B"));
    }

    @Test
    void addEdgeNonExistentThrowsTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        assertThrows(GraphException.class, () -> g.addEdge("A", "B"));
    }

    @Test
    void removeEdgeTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        g.removeEdge("A", "B");
        assertEquals(0, g.getEdges().size());
    }

    @Test
    void removeNonExistentEdgeDoesNothingTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.removeEdge("A", "B"); // ребра нет, не должно упасть
        assertEquals(0, g.getEdges().size());
    }

    @Test
    void removeVertexRemovesEdgesTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.removeVertex("B"); // B в середине

        assertEquals(2, g.vertexCnt());
        assertEquals(0, g.getEdges().size()); // ребра A->B и B->C удалились
    }

    @Test
    void removeVertexShiftsIndicesTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addEdge("A", "C");
        g.removeVertex("B"); // Удаляем B (индекс 1), C должен сдвинуться на 1

        List<List<String>> edges = g.getEdges();
        assertEquals(1, edges.size());
        assertEquals("A", edges.get(0).get(0));
        assertEquals("C", edges.get(0).get(1));
    }

    @Test
    void removeNonExistentVertexThrowsTest() {
        Graph<String> g = new IncidenceMatrix<>();
        assertThrows(GraphException.class, () -> g.removeVertex("X"));
    }

    @Test
    void clearTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        g.clear();
        assertEquals(0, g.vertexCnt());
        assertEquals(0, g.getEdges().size());
    }

    @Test
    void getNeighboursEmptyTest() {
        Graph<String> g = new IncidenceMatrix<>();
        g.addVertex("A");
        assertTrue(g.getNeighbours("A").isEmpty());
    }

    @Test
    void equalsAndHashCodeTest() {
        Graph<String> g1 = new IncidenceMatrix<>();
        Graph<String> g2 = new IncidenceMatrix<>();
        g1.addVertex("A");
        g2.addVertex("A");
        assertEquals(g1, g2);
        assertEquals(g1.hashCode(), g2.hashCode());
    }
}