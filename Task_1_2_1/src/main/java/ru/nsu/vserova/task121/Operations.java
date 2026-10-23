package ru.nsu.vserova.task121;

import java.util.HashSet;
import java.util.Set;

public class Operations {

    /** Сравнение по содержимому. */
    public static <I> boolean equal(Graph<I> a, Graph<I> b) {
        if (a == b) {
            return true;
        }
        if (!(b instanceof Graph)) {
            return false;
        }
        if (a.vertexCnt() != b.vertexCnt()) {
            return false;
        }
        if (a.getEdges().size() != b.getEdges().size()) {
            return false;
        }

        for (I v : a.getVertices()) {
            if (!b.getVertices().contains(v)) {
                return false;
            }
            Set<I> na = new HashSet<>(a.getNeighbours(v));
            Set<I> nb = new HashSet<>(b.getNeighbours(v));
            if (!na.equals(nb)) {
                return false;
            }
        }
        return true;
    }

    /** Представление графа в виде строки. */
    public static <I> String toString(Graph<I> g) {
        StringBuilder sb = new StringBuilder();
        sb.append("Граф:\n");
        for (I v : g.getVertices()) {
            sb.append("  ").append(v).append(" -> ").append(g.getNeighbours(v)).append('\n');
        }
        return sb.toString();
    }
}
