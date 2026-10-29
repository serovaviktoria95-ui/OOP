package ru.nsu.vserova.task122;

import java.util.Objects;

/** Ячейка ключ=значение. */
class Entry<K, V> {
    K key;
    V value;

    /** Создает новую ячейку с заданным ключом и значением. */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /** Вернуть ключ. */
    public K getKey() {
        return key;
    }

    /** Вернуть значение. */
    public V getValue() {
        return value;
    }

    /** Заменить текущее значение на новое. */
    public V setValue(V newValue) {
        V oldValue = this.value;
        this.value = newValue;
        return oldValue;
    }

    /** Возвращает строковое представление ячейки в формате ключ=значение. */
    public String toString() {
        return key + "=" + value;
    }

    /** Сравнить два поля одной ячейки. */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
    }

    /** Переопределение хэш-кода после equals. */
    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
