package org.example.ch4;

import java.util.Comparator;

/**
 * Created by Artyom Zheltyshev on 18.06.2024
 */
public class PriorityQ<T> {

    private int maxSize;
    private T[] queArray;
    private Comparator<T> comparator;
    private int nItems;

    public PriorityQ(int maxSize, Comparator<T> comparator) {
        this.maxSize = maxSize;
        this.queArray = (T[]) new Object[maxSize];
        this.comparator = comparator;
        this.nItems = 0;
    }

    public static <C extends Comparable<C>> PriorityQ<C> withNaturalOrder(int maxSize) {
        return new PriorityQ<C>(maxSize, Comparator.naturalOrder());
    }

    public void insert(T element) {
        int j;

        if (nItems == 0) {
            queArray[nItems++] = element;
        } else {
            for (j=nItems-1; j>=0; j--) {
                if (comparator.compare(element, queArray[j]) > 0) {
                    queArray[j+1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j+1] = element;
            nItems++;
        }
    }

    public T remove() {
        return queArray[--nItems];
    }

    public T peekMin() {
        return queArray[nItems-1];
    }

    public boolean isEmpty() {
        return nItems==0;
    }

    public boolean isFull() {
        return nItems==maxSize;
    }
}
