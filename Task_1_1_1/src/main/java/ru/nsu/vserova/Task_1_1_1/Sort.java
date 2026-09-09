package ru.nsu.vserova.Task_1_1_1;
/**
 * Класс реализует алгоритм пирамидальной сортировки
 * Сортирует массив целых чисел по возрастанию
 */
public class Sort {
    /**
     * Восстанавливает свойство кучи для поддерева
     * @param array массив
     * @param n размер кучи
     * @param i индекс корня поддерева
     */
    public static  void siftDown(int[] array, int n, int i) {
        int l = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < n && array[left] > array[l]) {
            l = left;
        }
        if (right < n && array[right] > array[l]) {
            l = right;
        }
        if (l != i) {
            int t = array[i];
            array[i] = array[l];
            array[l] = t;
            siftDown(array, n, l);
        }
    }

    /**
     * Сортирует массив по возрастанию
     * @param array массив для сортировки
     * @return отсортированная копия исходного массива
     */
    public static int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        int[] res = array.clone();
        int len = array.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            siftDown(res, len, i);
        }
        for (int i = len - 1; i > 0; i--) {
            int t = res[0];
            res[0] = res[i];
            res[i] = t;
            siftDown(res, i, 0);
        }
        return res;
    }
}