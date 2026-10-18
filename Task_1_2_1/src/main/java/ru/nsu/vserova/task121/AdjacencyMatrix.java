package ru.nsu.vserova.task121;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix<I> implements Graph<I> {
    private VertexID<I> idx = new VertexID<>();
    private boolean[][] matrix = new boolean[0][0];
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

    @Override
    public void addEdge(I from, I to) {
        matrix[idx.id(from)][idx.id(to)] = true;
    }

    @Override
    public void removeEdge(I from, I to) {
        matrix[idx.id(from)][idx.id(to)] = false;
    }

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

    @Override
    public void clear() {
        idx.clear();
        matrix = new boolean[0][0];
    }

    @Override
    public List<I[]> getEdges() {
        List<I[]> res = new ArrayList<>();
        for (int i = 0; i < idx.size(); i++) {
            for (int j = 0; j < idx.size(); j++) {
                if (matrix[i][j]) {
                    I[] pair = (I[]) new Object[2];
                    pair[0] = idx.name(i);
                    pair[1] = idx.name(j);
                    res.add(pair);
                }
            }
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
