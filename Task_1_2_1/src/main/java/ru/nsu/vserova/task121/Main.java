package ru.nsu.vserova.task121;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** Входная точка. */
public class Main {

    /** Запуск программы. */
    public static void main(String[] args) throws IOException {
        String file = "graph.txt";
        Files.writeString(Path.of(file), "A B C D\n" + "A B\n A C\n D C\n");

        Graph<String> matrix = new AdjacencyMatrix<>();
        Graph<String> list = new AdjacencyList<>();
        Graph<String> incidence = new IncidenceMatrix<>();

        GraphIO.readInto(matrix, file);
        GraphIO.readInto(list, file);
        GraphIO.readInto(incidence, file);

        System.out.println("Матрица смежности: ");
        System.out.println(matrix);

        System.out.println("Список смежности: ");
        System.out.println(list);

        System.out.println("Матрица инцидентности: ");
        System.out.println(incidence);

        TopologicalSort sorter = new TopologicalSort();
        System.out.println("Отсортированная матрица смежности: " + sorter.sort(matrix));
        System.out.println("Отсортированный список смежности: " + sorter.sort(list));
        System.out.println("Отсортированная матрица инцидентности: " + sorter.sort(incidence));

        System.out.println("Матрица смежности == список смежности: " + matrix.equals(list));
        System.out.println("Матрица смежности == матрица инцидентности: " + matrix.equals(incidence));

        Graph<String> cyclic = new AdjacencyList<>();
        cyclic.addVertex("X");
        cyclic.addVertex("Y");
        cyclic.addVertex("Z");
        cyclic.addEdge("X", "Y");
        cyclic.addEdge("Y", "Z");
        cyclic.addEdge("Z", "X");

        System.out.println("\nГраф с циклом:");
        System.out.println(cyclic);
        try {
            sorter.sort(cyclic);
        } catch (GraphException e) {
            System.out.println("Ожидаемое исключение: " + e.getMessage());
        }

        Graph<Integer> intGraph = new AdjacencyList<>();
        intGraph.addVertex(10);
        intGraph.addVertex(20);
        intGraph.addVertex(30);
        intGraph.addEdge(10, 20);
        intGraph.addEdge(20, 30);

        System.out.println("Граф, индексы - целые числа");
        System.out.println(intGraph);
        System.out.println("Отсортированный граф: " + sorter.sort(intGraph));

        GraphIO.writeFrom(matrix, "out.txt");
        System.out.println("\nГраф записан в out.txt");
    }
}
