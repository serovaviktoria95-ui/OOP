package ru.nsu.vserova.task111;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Тесты для класса Sort.
 */
class SortTest {

    @Test
    void shortArray() {
        int[] array = new int[]{1, 3, 2};
        var result = Sort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void longArray() {
        int[] array = new int[]{1, 5, 2, 4, 3, 6, 9, 7, 8};
        var result = Sort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, result);
    }

    @Test
    void duplicates() {
        int[] array = new int[]{3, 3, 2};
        var result = Sort.sort(array);
        assertArrayEquals(new int[]{2, 3, 3}, result);
    }

    @Test
    void negative_duplicates() {
        int[] array = new int[]{-3, -3, -2};
        var result = Sort.sort(array);
        assertArrayEquals(new int[]{-3, -3, -2}, result);
    }

    @Test
    void empty() {
        int[] array = new int[]{};
        var result = Sort.sort(array);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void singleElement() {
        int[] array = new int[]{0};
        var result = Sort.sort(array);
        assertArrayEquals(new int[]{0}, result);
    }
}