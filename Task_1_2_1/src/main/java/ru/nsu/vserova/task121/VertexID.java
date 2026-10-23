package ru.nsu.vserova.task121;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* Хранит соответствие имя вершины-индекс и упорядоченный список имен.
*/
public class VertexID<I> {
    private Map<I, Integer> vertexID = new LinkedHashMap<>();
    private List<I> vertices = new ArrayList<>();

    /**
     * Индекс вершины.
     */
    public int id(I vertex) {
        Integer i = vertexID.get(vertex);
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
     * @param vertex
     * @return индекс вершины.
     */
    public int add(I vertex) {
        if (vertexID.containsKey(vertex)) throw new GraphException("Вершина уже существует: " + vertex);
        int i = vertices.size();
        vertexID.put(vertex, i);
        vertices.add(vertex);
        return i;
    }

    /**
     * Удалить вершину.
     * @param vertex
     * @return индекс вершины
     */
    public int remove(I vertex) {
        if (vertexID.containsKey(vertex)) {
            int k = id(vertex);
            vertices.remove(k);
            vertexID.remove(vertex);
            for (int i = k; i < vertices.size(); i++) {
                vertexID.put(vertices.get(i), i);
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
        vertexID.clear();
    }

    /**
     * Нужен, чтобы клиент не мог портить внутреннее состояние графа, если передавать сам vertices.
     * @return копия списка имен вершин.*/
    public List<I> list() {
        return new ArrayList<>(vertices);
    }
}
