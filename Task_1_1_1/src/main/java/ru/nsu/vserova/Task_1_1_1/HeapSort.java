package ru.nsu.vserova.Task_1_1_1;

public class HeapSort {
    public static  void SiftDown(int[] array, int n, int i){
        int l = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if ( left < n && array[left] > array[l] ){
            l = left;
        }
        if (right < n && array[right] > array[l]){
            l = right;
        }
        if (l != i){
            int t = array[i];
            array[i] = array[l];
            array[l] = t;
            SiftDown(array, n, l);
        }
    }
    public static int[] sort(int[] array){
        if (array == null) {
            return null;
        }
        int[] res = array;
        int len = array.length;
        for ( int i = len / 2 - 1; i >= 0; i--){
            SiftDown( res, len, i);
        }
        for (int i = len - 1; i > 0; i--) {
            int t = res[0];
            res[0] = res[i];
            res[i] = t;
            SiftDown(res, i, 0);
        }
        return res;
    }
}
