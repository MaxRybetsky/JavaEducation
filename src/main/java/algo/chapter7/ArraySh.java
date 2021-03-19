package algo.chapter7;

import java.util.Arrays;

public class ArraySh {
    private long[] arr;
    private int nElems;

    public ArraySh(int max) {
        arr = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        arr[nElems++] = value;
    }

    public void display() {
        System.out.println(Arrays.toString(arr));
    }

    public void shellSort() {
        int inner;
        int outer;
        long temp;
        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = arr[outer];
                inner = outer;
                while (inner > h - 1 && arr[inner - h] >= temp) {
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }
                arr[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int max = 20;
        ArraySh arr = new ArraySh(max);
        for (int i = 0; i < max; i++) {
            long n = (long) (Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.shellSort();
        arr.display();
    }
}
