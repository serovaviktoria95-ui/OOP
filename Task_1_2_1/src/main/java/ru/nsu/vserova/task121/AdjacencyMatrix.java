package ru.nsu.vserova.task121;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Матрица смежности.
 */
public class AdjacencyMatrix<I> implements Graph<I> {
    private VertexID<I> idx = new VertexID<>();
    private boolean[][] matrix = new boolean[0][0];

    /** Добавить вершину. */
    @Override
    public void addVertex(I vertex) {
        int n = idx.size();
        idx.add(vertex);
        boolean[][] m = new boolean[n + 1][n + 1];
        for (int r = 0; r < n; r++) {
            System.arraycopy(matrix[r], 0, m[r], 0, n);
        }
        matrix = m;
    }

    /** Удалить вершину. */
    @Override
    public void removeVertex(I vertex) {
        int k = idx.remove(vertex);

        int n = matrix.length;
        boolean[][] m = new boolean[n - 1][n - 1];

        int row = 0;
        for (int i = 0; i < n; i++) {
            if (i == k) continue;
            int col = 0;
            for (int j = 0; j < n; j++) {
                if (j == k) continue;
                m[row][col++] = matrix[i][j];
            }
            row++;
        }
        matrix = m;
    }

    /** Добавить ориентированное ребро. */
    @Override
    public void addEdge(I from, I to) {
        matrix[idx.id(from)][idx.id(to)] = true;
    }

    /** Удалить ориентированное ребро. */
    @Override
    public void removeEdge(I from, I to) {
        matrix[idx.id(from)][idx.id(to)] = false;
    }

    /** Получить список всех соседей вершины. */
    @Override
    public List<I> getNeighbours(I vertex) {
        int i = idx.id(vertex);
        List<I> res = new ArrayList<>();
        for (int j = 0; j < idx.size(); j++) {
            if (matrix[i][j]) {
                res.add(idx.name(j));
            }
        }
        return res;
    }

    /** Очистить граф. */
    @Override
    public void clear() {
        idx.clear();
        matrix = new boolean[0][0];
    }

    /** Список всех ребер графа. */
    @Override
    public List<List<I>> getEdges() {
        List<List<I>> res = new ArrayList<>();
        for (int i = 0; i < idx.size(); i++) {
            for (int j = 0; j < idx.size(); j++) {
                if (matrix[i][j]) {
                    List<I> pair = new ArrayList<>();
                    pair.add(idx.name(i));
                    pair.add(idx.name(j));
                    res.add(pair);
                }
            }
        }
        return res;
    }

    /** Список всех вершин графа. */
    @Override
    public List<I> getVertices() {
        return idx.list();
    }

    /** Количество вершин в графе. */
    @Override
    public int vertexCnt() {
        return idx.size();
    }

    /** Сравнить граф с другим по содержимому. */
    @Override
    public boolean equals(Object o) {
        return o instanceof Graph && Operations.equal(this, (Graph<I>) o);
    }

    /** Хэшкод на основе вершин. */
    @Override
    public int hashCode() {
        return Objects.hash(getVertices());
    }

    /** Возвращает строковое представление графа в виде списка. */
    @Override
    public String toString() {
        return Operations.toString(this);
    }
}
