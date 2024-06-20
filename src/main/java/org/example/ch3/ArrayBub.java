package org.example.ch3;

/**
 * Created by Artyom Zheltyshev on 13.06.2024
 */
public class ArrayBub {

    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        this.a = new long[max];
        this.nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void bubbleSort() {
        for (int i = nElems - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void doubleSidedBubbleSort() {
        int left = 0;
        int right = nElems - 1;
        while (left < right) {
            for (int i = 0; i < right; i++) {
                if (a[i] > a[i+1]) {
                    swap(i, i+1);
                }
            }
            right--;
            for (int i = nElems - 1; i > left; i--) {
                if (a[i-1] > a[i]) {
                    swap(i-1, i);
                }
            }
            left++;
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void print() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i]);
        }
    }
}
