package ru.nsu.vserova.task122;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/** Собственная реализация хэш-таблицы. */
public class HashTable<K, V> implements Iterable<Entry<K, V>> {

    private Node<K, V>[] table;
    private int modCnt;
    private int size;

    /** 1. cоздание пустой хеш-таблицы. */
    public HashTable() {
        table = (Node<K, V>[]) new Node[16];
        size = 0;
        modCnt = 0;
    }

    /** Вычисление хэша по ключу. */
    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % table.length);
    }

    /** 2. добавление пары ключ-значение (k, v). */
    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> cur = table[index];

        while (cur != null) {
            if (Objects.equals(cur.getKey(), key)) {
                cur.setValue(value);
                modCnt++;
                return;
            }
            cur = cur.next;
        }
        table[index] = new Node<>(key, value, table[index]);
        size++;
        modCnt++;
    }

    /** 3. удаление пары ключ-значение (k, v). */
    public void remove(K key) {
        int index = hash(key);
        Node<K, V> cur = table[index];
        Node<K, V> prev = null;

        while (cur != null) {
            if (Objects.equals(cur.getKey(), key)) {
                if (prev == null) {
                    table[index] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                modCnt++;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    /** 4. поиск значения по ключу. */
    public V get(K key) {
        int index = hash(key);
        Node<K, V> cur = table[index];

        while (cur != null) {
            if (Objects.equals(cur.getKey(), key)) {
                return cur.getValue();
            }
            cur = cur.next;
        }
        return null;
    }

    /** 5. обновление значения по ключу. */
    public V update(K key, V newValue) {
        int index = hash(key);
        Node<K, V> cur = table[index];

        while (cur != null) {
            if (Objects.equals(cur.getKey(), key)) {
                V oldValue = cur.getValue();
                cur.setValue(newValue);
                modCnt++;
                return oldValue;
            }
            cur = cur.next;
        }
        return null;
    }

    /** 6. проверка наличия значения по ключу. */
    public boolean hasValue(K key) {
        return get(key) != null;
    }

    /** 7. итерирование по элементам коллекции (по парам (k, v))
     * с обработкой исключительной ситуации ConcurrentModificationException.
     */
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashTableIterator();
    }

    /** Внутренний класс итератора. */
    private class HashTableIterator implements Iterator<Entry<K, V>> {
        private int expectedModCnt = modCnt; // заводим переменную,
        // чтобы ловить ConcurrentModificationException
        private int curIndex = 0;
        private Node<K, V> curNode = null;
        private Node<K, V> nextNode = null;

        /** Проверяет, есть ли еще элементы в таблице для обхода. */
        @Override
        public boolean hasNext() {
            if (expectedModCnt != modCnt) {
                throw new ConcurrentModificationException();
            }
            if (nextNode != null) {
                return true;
            }

            for (int i = curIndex; i< table.length; i++) {
                if (table[i] != null) {
                    nextNode = table[i];
                    curIndex = i + 1;
                    return true;
                }
            }
            return false;
        }

        /** Передвижение итератора вперед и возврат текущего элемента. */
        @Override
        public Entry<K, V> next() {
            if (expectedModCnt != modCnt) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            curNode = nextNode;
            nextNode = nextNode.next;
            return curNode;
        }
    }

    /** Вспомогательный метод для получения значения по ключу типа Object. */
    private Object getValueByObject(Object key) {
        int index;
        if (key == null) {
            index = 0;
        } else {
            index = Math.abs(key.hashCode() % table.length);
        }
        Node<K, V> cur = table[index];
        while (cur != null) {
            if (Objects.equals(cur.getKey(), key)) {
                return cur.getValue();
            }
            cur = cur.next;
        }
        return null;
    }

    /** 8. сравнение на равенство с другой хеш-таблицей. */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HashTable<?, ?> another = (HashTable<?, ?>) o; // приводим к одному типу, чтобы иметь доступ к size
        if (size != another.size) {
            return false;
        }
        for (Entry<K, V> entry : this) {
            Object anotherValue = another.getValueByObject(entry.getKey());
            if (anotherValue == null || !Objects.equals(entry.getValue(),anotherValue)) {
                return false;
            }
        }
        return true;
    }

    /** Возвращает хэш-код таблицы. */
    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    /** Превращаем объект в строку. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        Iterator<Entry<K, V>> iter = iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.append(" }").toString();
    }
}
