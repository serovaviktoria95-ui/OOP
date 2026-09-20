package ru.nsu.vserova.task111;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {1000000, 2000000, 4000000};

        for (int n : sizes) {
            int[] array = randomArray(n);

            long start = System.nanoTime();
            Sort.sort(array);
            long end = System.nanoTime();

            double ms = (end - start) / 1000000.0;
            System.out.println(n + " " + ms);
        }
    }

    private static int[] randomArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }
        return array;
    }
}