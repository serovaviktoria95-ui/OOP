package ru.nsu.vserova.task121;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* Хранит соответствие имя вершины-индекс и упорядоченный список имен.
*/
public class VertexId<I> {
    private Map<I, Integer> vertexId = new LinkedHashMap<>();
    private List<I> vertices = new ArrayList<>();

    /**
     * Индекс вершины.
     */
    public int id(I vertex) {
        Integer i = vertexId.get(vertex);
        if (i == null) {
            throw new GraphException("Нет такой вершины: " + vertex);
        }
        return i;
    }

    /**
     * Количество вершин.
     */
    public int size() {
        return vertices.size();
    }

    /**
     * Добавить вершину.
     *
     * @param vertex имя вершины
     * @return индекс вершины.
     */
    public int add(I vertex) {
        if (vertexId.containsKey(vertex)) {
            throw new GraphException("Вершина уже существует: " + vertex);
        }
        int i = vertices.size();
        vertexId.put(vertex, i);
        vertices.add(vertex);
        return i;
    }

    /**
     * Удалить вершину.
     *
     * @param vertex имя вершины
     * @return индекс вершины
     */
    public int remove(I vertex) {
        if (vertexId.containsKey(vertex)) {
            int k = id(vertex);
            vertices.remove(k);
            vertexId.remove(vertex);
            for (int i = k; i < vertices.size(); i++) {
                vertexId.put(vertices.get(i), i);
            }
            return k;
        } else {
            throw new GraphException("Нет такой вершины: " + vertex);
        }
    }

    /** Имя вершины по индексу. */
    public I name(int i) {
        return vertices.get(i);
    }

    public void clear() {
        vertices.clear();
        vertexId.clear();
    }

    /**
     * Нужен, чтобы клиент не мог портить внутреннее состояние графа, если передавать сам vertices.
     *
     * @return копия списка имен вершин.*/
    public List<I> list() {
        return new ArrayList<>(vertices);
    }
}
