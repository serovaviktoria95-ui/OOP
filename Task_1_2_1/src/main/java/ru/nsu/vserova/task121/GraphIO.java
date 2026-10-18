package ru.nsu.vserova.task121;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Чтение/запись графа в фиксированном текстовом формате.
 */
public class GraphIO {
    private GraphIO() {}

    public static void readInto(Graph<String> g, String path) throws IOException {
        // try-with-resources, автоматическая очистка ресурсов
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            g.clear(); // очищаем граф перед чтением
            boolean first = true;
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] p = line.split("\\s+");
                if (first) {
                    for (String v : p) g.addVertex(v);
                    first = false;
                } else {
                    if (p.length != 2) {
                        throw new IOException("Ожидается 'from to': " + line);
                    }
                    g.addEdge(p[0], p[1]);
                }
            }
        }
    }

    public static void writeFrom(Graph<String> g, String path) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(path))) {
            bw.write(String.join(" ", g.getVertices()));
            bw.newLine();
            for (Object[] e : g.getEdges()) {
                bw.write((String) e[0]);
                bw.write(' ');
                bw.write((String) e[1]);
                bw.newLine();
            }
        }
    }
}
