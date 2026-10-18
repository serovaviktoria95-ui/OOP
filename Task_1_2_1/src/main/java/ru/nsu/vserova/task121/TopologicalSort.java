package ru.nsu.vserova.task121;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Алгоритм Кана.
 */
public class TopologicalSort {
    public <I> List<I> sort(Graph<I> g) {
        // Всем входящую степень 0.
        Map<I, Integer> degree = new HashMap<>();
        for (I vertex : g.getVertices()) {
            degree.put(vertex, 0);
        }

        // Для каждого ребра степень вхождения увеличить на 1.
        for (I[] e : g.getEdges()) {
            I to = e[1];
            degree.put(to, degree.get(to) + 1);
        }

        // Создаем очередь с вершинами со степенью вхождения 0.
        Deque<I> queue = new ArrayDeque<>();
        for (I vertex : g.getVertices()) {
            if (degree.get(vertex) == 0) {
                queue.add(vertex);
            }
        }

        // Удаляем вершины и уменьшаем степени соседей.
        List<I> order = new ArrayList<>();
        while(!queue.isEmpty()) {
            I vertex = queue.poll();
            order.add(vertex);

            List<I> neighbours = g.getNeighbours(vertex);
            for (I nb : neighbours) {
                int newDegree = degree.get(nb) - 1;
                degree.put(nb, newDegree); // новые степени у соседей
                if (newDegree == 0) {
                    queue.add(nb);
                }
            }
        }

        if (order.size() != g.vertexCnt()) {
            throw new GraphException("В графе есть цикл");
        }
        return order;
    }
}
