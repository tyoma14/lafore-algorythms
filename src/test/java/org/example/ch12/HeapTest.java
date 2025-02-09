package org.example.ch12;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    void test() {
        Heap theHeap = new Heap(31);

        theHeap.insert(70); // Вставка 10 items
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);

        theHeap.displayHeap();

        theHeap.insert(53);
        theHeap.displayHeap();

        theHeap.remove();
        theHeap.displayHeap();
    }

    @Test
    void testAscendingHeap() {
        Heap theHeap = new Heap(31, Comparator.naturalOrder());

        theHeap.insert(70); // Вставка 10 items
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);

        theHeap.displayHeap();

        theHeap.insert(53);
        theHeap.displayHeap();

        theHeap.remove();
        theHeap.displayHeap();
    }

    @Test
    void insertAll() {
        Heap theHeap = new Heap(31);

        theHeap.insert(70); // Вставка 10 items
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);

        theHeap.displayHeap();

        theHeap.insertAll(110, 55, 35, 85, 5);
        theHeap.displayHeap();
    }
}