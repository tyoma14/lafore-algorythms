package org.example.ch3;

/**
 * Created by Artyom Zheltyshev on 13.06.2024
 */
public class ArrayIns {

    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
        this.a = new long[max];
        this.nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void insertionSort() {
        for (int i = 1; i < nElems; i++) {
            long temp = a[i];
            int j = i;
            while (j > 0 && a[j-1] >= temp) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }

    public void print() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i]);
        }
    }
}
