package ru.nsu.vserova.task121;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Список смежности.
 */
public class AdjacencyList<I> implements Graph<I> {
    private VertexId<I> idx = new VertexId<>();
    private List<List<Integer>> adj = new ArrayList<>();

    /** Добавить вершину. */
    @Override
    public void addVertex(I vertex) {
        idx.add(vertex);
        adj.add(new ArrayList<>());
    }

    /** Удалить вершину. */
    @Override
    public void removeVertex(I vertex) {
        int k = idx.remove(vertex);
        adj.remove(k);
        for (List<Integer> l : adj) {
            for (int i = l.size() - 1; i >= 0; i--) {
                int x = l.get(i);
                if (x == k) {
                    l.remove(i);
                }
                else if (x>k) {
                    l.set(i, x - 1);
                }
            }
        }
    }

    /** Добавить ориентированное ребро. */
    @Override
    public void addEdge(I from, I to) {
        adj.get(idx.id(from)).add(idx.id(to));
    }

    /** Удалить ориентированное ребро. */
    @Override
    public void removeEdge(I from, I to) {
        int toId = idx.id(to);
        int fromId = idx.id(from);

        List<Integer> neighbours = adj.get(fromId);

        neighbours.remove(Integer.valueOf(toId));
    }

    /** Получить список соседей вершины. */
    @Override
    public List<I> getNeighbours(I vertex) {
        List<I> res = new ArrayList<>();
        for (int i : adj.get(idx.id(vertex))) {
            res.add(idx.name(i));
        }
        return res;
    }

    /** Очистить граф. */
    @Override
    public void clear() {
        idx.clear();
        adj.clear();
    }

    /** Список всех ребер графа. */
    @Override
    public List<List<I>> getEdges() {
        List<List<I>> res = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i)) {
                List<I> pair = new ArrayList<>();
                pair.add(idx.name(i));
                pair.add(idx.name(j));
                res.add(pair);
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
