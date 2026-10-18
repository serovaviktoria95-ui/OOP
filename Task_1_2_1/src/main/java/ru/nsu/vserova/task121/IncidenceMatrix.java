package ru.nsu.vserova.task121;

import java.util.ArrayList;
import java.util.List;

/**
 * Матрица инцидентности.
 * <p>
 *
 *     Строки - вершины, столбцы - ребра
 *     -1 - ребро входит в вершину, 1 - выходит
 * </p>
 */
public class IncidenceMatrix<I> implements Graph<I> {
    private VertexID<I> idx = new VertexID<>();
    private final List<int[]> edges = new ArrayList<>();
    private int[][] inc = new int[0][0];

    /**
     * Пересобрать матрицу инцидентности по списку ребер.
     */
    private void rebuild() {
        int n = idx.size();
        int m = edges.size();
        inc = new int[n][m];
        for (int e = 0; e < m; e++) {
            inc[edges.get(e)[0]][e] = 1; // выходит
            inc[edges.get(e)[1]][e] = -1; // входит
        }
    }

    @Override
    public void addVertex(I vertex) {
        idx.add(vertex);
        rebuild();
    }

    @Override
    public void removeVertex(I vertex) {
        int k = idx.remove(vertex);

        // Удаляем также ребра, инцидентные этой вершине
        for(int i = edges.size() - 1; i >=0; i--) {
            int[] e = edges.get(i);
            if (e[0] == k || e[1] == k) {
                edges.remove(i);
            }
        }

        for (int[] e : edges) {
            if (e[0] > k) e[0]--;
            if (e[1] > k) e[1]--;
        }
        rebuild();
    }

    /** Добавляет ориентированное ребро. */
    @Override
    public void addEdge(I from, I to) {
        int fromID = idx.id(from);
        int toID = idx.id(to);

        int[] edge = new int[2];
        edge[0] = fromID;
        edge[1] = toID;

        edges.add(edge);
        rebuild();
    }

    /** Удаляет ориентированное ребро. */
    @Override
    public void removeEdge(I from, I to) {
        int fromID = idx.id(from);
        int toID = idx.id(to);

        int found = -1;
        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            if (edge[0] == fromID && edge[1] == toID) {
                found = i;
                break;
            }
        }

        if (found != -1) {
            edges.remove(found);
            rebuild();
        }
    }

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

    @Override
    public void clear() {
        idx.clear();
        edges.clear();
        inc = new int[0][0];
    }

    @Override
    public List<I[]> getEdges() {
        List<I[]> res = new ArrayList<>();
        for (int[] e : edges) {
            I[] pair = (I[]) new Object[2];
            pair[0] = idx.name(e[0]);
            pair[1] = idx.name(e[1]);
            res.add(pair);
        }
        return res;
    }

    @Override
    public List<I> getVertices() {
        return idx.list();
    }

    @Override
    public int vertexCnt() {
        return idx.size();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Graph && Operations.equal(this, (Graph<I>) o);
    }

    @Override
    public String toString() {
        return Operations.toString(this);
    }
}
