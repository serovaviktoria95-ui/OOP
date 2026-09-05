package ru.nsu.vserova.task_1_1_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    @Test
    void first() {
        int[] array = new int[]{1, 3, 2};
        var result = HeapSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }
    @Test
    void second() {
        int[] array = new int[]{1, 5, 2, 4, 3, 6, 9, 7, 8};
        var result = HeapSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, result);
    }
    @Test
    void third() {
        int[] array = new int[]{3, 3, 2};
        var result = HeapSort.sort(array);
        assertArrayEquals(new int[]{2, 3, 3}, result);
    }
    @Test
    void fourth() {
        int[] array = new int[]{-3, -3, -2};
        var result = HeapSort.sort(array);
        assertArrayEquals(new int[]{-3, -3, -2}, result);
    }
    @Test
    void fifth() {
        int[] array = new int[]{};
        var result = HeapSort.sort(array);
        assertArrayEquals(new int[]{}, result);
    }
    @Test
    void sixth() {
        int[] array = new int[]{0};
        var result = HeapSort.sort(array);
        assertArrayEquals(new int[]{0}, result);
    }
}