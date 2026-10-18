package ru.nsu.vserova.task121;

import java.util.List;

public interface Graph<I> {
    // 1. добавление и удаление вершины;
    void addVertex(I vertex);
    void removeVertex(I vertex);

    // 2. добавление и удаление ребра;
    void addEdge(I from, I to);
    void removeEdge(I from, I to);

    // 3. получение списка всех “соседей” вершины;
    List<I> getNeighbours(I vertex);

    // доп.функции
    void clear();
    List<I[]> getEdges();
    List<I> getVertices();
    int vertexCnt();
}
