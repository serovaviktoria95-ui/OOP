package ru.nsu.vserova.task121;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

/**
 * Чтение/запись графа в фиксированном текстовом формате.
 */
public class GraphIo {
    private GraphIo() {}

    /** Для уже строковых графов. */
    public static void readInto(Graph<String> g, String path) throws IOException {
        readInto(g, path, s -> s);
    }

    /** Прочитать граф любого типа из файла. */
    public static <I> void readInto(Graph<I> g, String path,
                                    Function<String, I> parser) throws IOException {
        // try-with-resources, автоматическая очистка ресурсов
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            g.clear(); // очищаем граф перед чтением
            boolean first = true;
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] p = line.split("\\s+");
                if (first) {
                    for (String v : p) {
                        g.addVertex(parser.apply(v));
                    }
                    first = false;
                } else {
                    if (p.length != 2) {
                        throw new IOException("Ожидается 'from to': " + line);
                    }
                    g.addEdge(parser.apply(p[0]), parser.apply(p[1]));
                }
            }
        }
    }

    /** Записать строковый граф в файл. */
    public static void writeFrom(Graph<String> g, String path) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(path))) {
            bw.write(String.join(" ", g.getVertices()));
            bw.newLine();
            for (List<String> e : g.getEdges()) {
                bw.write(e.get(0));
                bw.write(' ');
                bw.write(e.get(1));
                bw.newLine();
            }
        }
    }
}
