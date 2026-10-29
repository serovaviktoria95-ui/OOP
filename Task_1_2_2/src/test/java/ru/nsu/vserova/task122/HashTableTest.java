package ru.nsu.vserova.task122;

import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HashTableTest {

    @Test
    void testPutAndGet() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("A", 1);
        table.put("B", 2);

        assertEquals(1, table.get("A"));
        assertEquals(2, table.get("B"));
        assertNull(table.get("C"));
    }

    @Test
    void testUpdate() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("A", 1);

        Integer oldValue = table.update("A", 5);
        assertEquals(1, oldValue);
        assertEquals(5, table.get("A"));

        assertNull(table.update("B", 10));
    }

    @Test
    void testHasValue() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("A", 1);

        assertTrue(table.hasValue("A"));
        assertFalse(table.hasValue("B"));
    }

    @Test
    void testRemove() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("A", 1);
        table.put("B", 2);

        table.remove("A");

        assertNull(table.get("A"));
        assertFalse(table.hasValue("A"));
        assertEquals(2, table.get("B"));
    }

    @Test
    void testCollisions() {
        HashTable<String, String> table = new HashTable<>();

        table.put("Aa", "First");
        table.put("BB", "Second");

        assertEquals("First", table.get("Aa"));
        assertEquals("Second", table.get("BB"));
    }

    @Test
    void testEqualsAndHashCode() {
        HashTable<String, Integer> t1 = new HashTable<>();
        HashTable<String, Integer> t2 = new HashTable<>();

        t1.put("A", 1);
        t1.put("B", 2);

        t2.put("B", 2);
        t2.put("A", 1);

        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());

        t2.put("C", 3);
        assertFalse(t1.equals(t2));

        t2.remove("C");
        t2.put("A", 100);
        assertFalse(t1.equals(t2));
    }

    @Test
    void testToString() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("A", 1);

        String result = table.toString();
        assertTrue(result.startsWith("{ "));
        assertTrue(result.endsWith(" }"));
        assertTrue(result.contains("A=1"));
    }

    @Test
    void testIterator() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("A", 1);
        table.put("B", 2);

        int count = 0;
        for (Entry<String, Integer> entry : table) {
            assertTrue(entry.getKey().equals("A") || entry.getKey().equals("B"));
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    void testConcurrentModificationException() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("A", 1);
        table.put("B", 2);

        assertThrows(ConcurrentModificationException.class, () -> {
            for (Entry<String, Integer> entry : table) {
                if (entry.getKey().equals("A")) {
                    table.put("C", 3);
                }
            }
        });
    }
}