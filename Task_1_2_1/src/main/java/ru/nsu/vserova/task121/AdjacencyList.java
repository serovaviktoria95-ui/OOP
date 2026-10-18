package ru.nsu.vserova.task121;

import java.util.ArrayList;
import java.util.List;

/**
 * Список смежности.
 */
public class AdjacencyList<I> implements Graph<I> {
    private VertexID<I> idx = new VertexID<>();
    private List<List<Integer>> adj = new ArrayList<>();

    @Override
    public void addVertex(I vertex) {
        idx.add(vertex);
        adj.add(new ArrayList<>());
    }

    @Override
    public void removeVertex(I vertex) {
        int k = idx.remove(vertex);
        adj.remove(k);
        for (List<Integer> l : adj) {
            for (int i = l.size() - 1; i >= 0; i--) {
                int x = l.get(i);
                if (x == k) l.remove(i);
                else if (x>k) l.set(i, x - 1);
            }
        }
    }

    @Override
    public void addEdge(I from, I to) {
        adj.get(idx.id(from)).add(idx.id(to));
    }

    /**
     * Удаляет ориентированное ребро.
     */
    @Override
    public void removeEdge(I from, I to) {
        int toID = idx.id(to);
        int fromID = idx.id(from);

        List<Integer> neighbours = adj.get(fromID);

        neighbours.remove(Integer.valueOf(toID));
    }

    @Override
    public List<I> getNeighbours(I vertex) {
        List<I> res = new ArrayList<>();
        for (int i : adj.get(idx.id(vertex))) {
            res.add(idx.name(i));
        }
        return res;
    }

    @Override
    public void clear() {
        idx.clear();
        adj.clear();
    }

    @Override
    public List<I[]> getEdges() {
        List<I[]> res = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i)) {
                I[] pair = (I[]) new Object[2];
                pair[0] = idx.name(i);
                pair[1] = idx.name(j);
                res.add(pair);
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
