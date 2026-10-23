package ru.nsu.vserova.task121;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GraphIoTest {

    @Test
    void readStringGraphTest() throws IOException {
        Path temp = Path.of("temp_test_graph.txt");
        Files.writeString(temp, "A B C\nA B\nB C\n");

        Graph<String> g = new AdjacencyList<>();
        GraphIo.readInto(g, temp.toString());

        assertEquals(3, g.vertexCnt());
        assertEquals(2, g.getEdges().size());

        Files.deleteIfExists(temp);
    }

    @Test
    void readIntegerWithParserTest() throws IOException {
        Path temp = Path.of("temp_test_int.txt");
        Files.writeString(temp, "10 20\n10 20\n");

        Graph<Integer> g = new AdjacencyMatrix<>();
        GraphIo.readInto(g, temp.toString(), Integer::parseInt);

        assertEquals(2, g.vertexCnt());
        assertTrue(g.getNeighbours(10).contains(20));

        Files.deleteIfExists(temp);
    }

    @Test
    void writeFromTest() throws IOException {
        Graph<String> g = new AdjacencyList<>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");

        Path temp = Path.of("temp_out.txt");
        GraphIo.writeFrom(g, temp.toString());

        assertTrue(Files.exists(temp));
        String content = Files.readString(temp);
        assertTrue(content.contains("A B"));

        Files.deleteIfExists(temp);
    }
}