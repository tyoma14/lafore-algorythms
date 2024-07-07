package org.example.ch5;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artyom Zheltyshev on 30.06.2024
 */
class SortedListTest {

    @Test
    void test() {
        SortedList<Integer> theList = SortedList.withNaturalOrder();
        theList.insert(20);
        theList.insert(40);

        theList.displayList();

        theList.insert(10);
        theList.insert(30);
        theList.insert(50);

        theList.displayList();

        theList.remove();

        theList.displayList();
    }

    /**
     * Сортировка вставками с помощью упорядоченного связного списка.
     * Использует N*2 операций копирования (в отличие от классической
     * сортировки вставками с N^2 операций копирования).
     */
    @Test
    void insertionSort() {
        int size = 10;
        Integer[] arr = new Integer[size];

        for (int j = 0; j < arr.length; j++) {
            int n = (int) (Math.random()*99);
            arr[j] = n;
        }
        System.out.print("Unsorted array: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();

        SortedList<Integer> sortedList = new SortedList<>(Comparator.naturalOrder(), arr);
        for (int j = 0; j < arr.length; j++) {
            arr[j] = sortedList.remove().data;
        }
        System.out.print("Sorted Array: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}