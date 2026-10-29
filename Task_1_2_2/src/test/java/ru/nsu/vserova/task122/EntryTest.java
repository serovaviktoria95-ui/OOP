package ru.nsu.vserova.task122;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class EntryTest {

    @Test
    void testSetValue() {
        Entry<String, Integer> entry = new Entry<>("A", 1);
        Integer oldValue = entry.setValue(2);

        assertEquals(1, oldValue);
        assertEquals(2, entry.getValue());
    }

    @Test
    void testToString() {
        Entry<String, Integer> entry = new Entry<>("A", 1);
        assertEquals("A=1", entry.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Entry<String, Integer> entry1 = new Entry<>("A", 1);
        Entry<String, Integer> entry2 = new Entry<>("A", 1);
        Entry<String, Integer> entry3 = new Entry<>("B", 1);

        assertEquals(entry1, entry2);
        assertEquals(entry1.hashCode(), entry2.hashCode());

        assertNotEquals(entry1, entry3);

        Entry<String, Integer> entry4 = new Entry<>("A", 2);
        assertNotEquals(entry1, entry4);

        assertNotEquals(entry1, null);
        assertNotEquals(entry1, "String");

    }
}