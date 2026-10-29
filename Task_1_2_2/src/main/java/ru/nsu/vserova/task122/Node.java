package ru.nsu.vserova.task122;

/** Связный список для работы с коллизиями. */
class Node<K,V> extends Entry<K, V> {
    Node<K, V> next;

    /** Создает новый узел связного списка. */
    public Node(K key, V value, Node<K, V> next) {
        super(key, value);
        this.next = next;
    }
}
