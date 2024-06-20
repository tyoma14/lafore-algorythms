package org.example.ch3;

/**
 * Created by Artyom Zheltyshev on 13.06.2024
 */
public class ArraySel {

    private long[] a;
    private int nElems;

    public ArraySel(int max) {
        this.a = new long[max];
        this.nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void selectionSort() {
        for (int i = 0; i < nElems; i++) {
            int min = i;
            for (int j = i; j < nElems; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(i, min);
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
