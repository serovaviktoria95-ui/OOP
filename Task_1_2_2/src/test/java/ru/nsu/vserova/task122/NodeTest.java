package ru.nsu.vserova.task122;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NodeTest {

    @Test
    void testNodeCreation() {
        Node<String, Integer> nextNode = new Node<>("B", 2, null);
        Node<String, Integer> node = new Node<>("A", 1, nextNode);

        assertEquals("A", node.getKey());
        assertEquals(1, node.getValue());
        assertEquals(nextNode, node.next);
        assertNull(nextNode.next);
    }
}