package ru.nsu.vserova.task121;

import java.util.List;

/** Интерфейс с операциями. */
public interface Graph<I> {
    /** Добавить вершину. */
    void addVertex(I vertex);

    /** Удалить вершину. */
    void removeVertex(I vertex);

    /** Добавить ориентированное ребро. */
    void addEdge(I from, I to);

    /** Удалить ориентированное ребро. */
    void removeEdge(I from, I to);

    /** Получить список всех соседей вершины. */
    List<I> getNeighbours(I vertex);

    /** Очистить граф. */
    void clear();

    /** Получить список всех ребер графа. */
    List<List<I>> getEdges();

    /** Получить список всех вершин графа. */
    List<I> getVertices();

    /** Получить количество вершин. */
    int vertexCnt();
}
