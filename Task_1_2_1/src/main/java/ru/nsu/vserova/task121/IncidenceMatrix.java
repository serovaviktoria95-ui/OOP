package ru.nsu.vserova.task121;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Матрица инцидентности.
 *
 * <p>
 *     Строки - вершины, столбцы - ребра
 *     -1 - ребро входит в вершину, 1 - выходит
 * </p>
 */
public class IncidenceMatrix<I> implements Graph<I> {
    private VertexId<I> idx = new VertexId<>();
    private final List<int[]> edges = new ArrayList<>();
    private int[][] inc = new int[0][0];
    int vertexOut = 1;
    int vertexIn = -1;

    /**
     * Пересобрать матрицу инцидентности по списку ребер.
     */
    private void rebuild() {
        int n = idx.size();
        int m = edges.size();
        inc = new int[n][m];
        for (int e = 0; e < m; e++) {
            inc[edges.get(e)[0]][e] = vertexOut;
            inc[edges.get(e)[1]][e] = vertexIn;
        }
    }

    /** Добавить вершину. */
    @Override
    public void addVertex(I vertex) {
        idx.add(vertex);
        rebuild();
    }

    /** Удалить вершину. */
    @Override
    public void removeVertex(I vertex) {
        int k = idx.remove(vertex);

        // Удаляем также ребра, инцидентные этой вершине
        for (int i = edges.size() - 1; i >= 0; i--) {
            int[] e = edges.get(i);
            if (e[0] == k || e[1] == k) {
                edges.remove(i);
            }
        }

        for (int[] e : edges) {
            if (e[0] > k) {
                e[0]--;
            }
            if (e[1] > k) {
                e[1]--;
            }
        }
        rebuild();
    }

    /** Добавить ориентированное ребро. */
    @Override
    public void addEdge(I from, I to) {
        int fromId = idx.id(from);
        int toId = idx.id(to);

        int[] edge = new int[2];
        edge[0] = fromId;
        edge[1] = toId;

        edges.add(edge);
        rebuild();
    }

    /** Удалить ориентированное ребро. */
    @Override
    public void removeEdge(I from, I to) {
        int fromId = idx.id(from);
        int toId = idx.id(to);

        int found = -1;
        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            if (edge[0] == fromId && edge[1] == toId) {
                found = i;
                break;
            }
        }

        if (found != -1) {
            edges.remove(found);
            rebuild();
        }
    }

    /** Получить список соседей вершины. */
    @Override
    public List<I> getNeighbours(I vertex) {
        int v = idx.id(vertex);
        List<I> res = new ArrayList<>();
        for (int[] e : edges) {
            if (e[0] == v) {
                res.add(idx.name(e[1]));
            }
        }
        return res;
    }

    /** Очистить граф. */
    @Override
    public void clear() {
        idx.clear();
        edges.clear();
        inc = new int[0][0];
    }

    /** Список всех ребер графа. */
    @Override
    public List<List<I>> getEdges() {
        List<List<I>> res = new ArrayList<>();
        for (int[] e : edges) {
            List<I> pair = new ArrayList<>();
            pair.add(idx.name(e[0]));
            pair.add(idx.name(e[1]));
            res.add(pair);
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
